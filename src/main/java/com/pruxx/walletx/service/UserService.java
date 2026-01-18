package com.pruxx.walletx.service;

import com.pruxx.walletx.dto.CreateUserRequest;
import com.pruxx.walletx.dto.CreateUserResponse;
import com.pruxx.walletx.entity.AppUser;
import com.pruxx.walletx.entity.Wallet;
import com.pruxx.walletx.repo.AppUserRepo;
import com.pruxx.walletx.repo.WalletRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pruxx.walletx.dto.WalletResponse;
import com.pruxx.walletx.entity.Wallet;
import com.pruxx.walletx.dto.AmountRequest;
import com.pruxx.walletx.dto.WalletResponse;
import com.pruxx.walletx.service.InsufficientFundsException;

@Service
public class UserService {

    private final AppUserRepo appUserRepo;
    private final WalletRepo walletRepo;

    public UserService(AppUserRepo appUserRepo, WalletRepo walletRepo) {
        this.appUserRepo = appUserRepo;
        this.walletRepo = walletRepo;
    }

    @Transactional
    public CreateUserResponse createUser(CreateUserRequest req) {
        if (appUserRepo.existsByEmail(req.email)) {
            throw new IllegalArgumentException("Email already exists");
        }

        AppUser user = appUserRepo.save(new AppUser(req.name, req.email));
        Wallet wallet = walletRepo.save(new Wallet(user));

        return new CreateUserResponse(
                user.getId(),
                wallet.getId(),
                user.getName(),
                user.getEmail(),
                wallet.getCurrency(),
                wallet.getBalanceCents()
        );
    }
    public WalletResponse getWalletByUserId(Long userId) {
        Wallet w = walletRepo.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("Wallet not found for userId=" + userId));

        return new WalletResponse(
                w.getId(),
                w.getUser().getId(),
                w.getCurrency(),
                w.getBalanceCents()
        );
    }
    @Transactional
    public WalletResponse deposit(Long userId, AmountRequest req) {
        Wallet w = walletRepo.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("Wallet not found for userId=" + userId));

        w.setBalanceCents(w.getBalanceCents() + req.amountCents);
        // save not strictly required because JPA tracks changes, but keeping it clear:
        walletRepo.save(w);

        return new WalletResponse(w.getId(), w.getUser().getId(), w.getCurrency(), w.getBalanceCents());
    }
    @Transactional
    public WalletResponse withdraw(Long userId, AmountRequest req) {
        Wallet w = walletRepo.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("Wallet not found for userId=" + userId));

        long balance = w.getBalanceCents();
        long amount = req.amountCents;

        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds. balanceCents=" + balance + ", requested=" + amount);
        }

        w.setBalanceCents(balance - amount);
        walletRepo.save(w);

        return new WalletResponse(w.getId(), w.getUser().getId(), w.getCurrency(), w.getBalanceCents());
    }

}
