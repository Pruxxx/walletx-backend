package com.pruxx.walletx.repo;

import java.util.Optional;
import com.pruxx.walletx.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepo extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findByUserId(Long userId);
}
