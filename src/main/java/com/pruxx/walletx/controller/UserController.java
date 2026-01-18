package com.pruxx.walletx.controller;

import com.pruxx.walletx.dto.CreateUserRequest;
import com.pruxx.walletx.dto.CreateUserResponse;
import com.pruxx.walletx.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pruxx.walletx.dto.WalletResponse;
import com.pruxx.walletx.dto.AmountRequest;
import com.pruxx.walletx.dto.WalletResponse;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<CreateUserResponse> create(@Valid @RequestBody CreateUserRequest req) {
        return ResponseEntity.ok(userService.createUser(req));
    }
    @GetMapping("/{userId}/wallet")
    public ResponseEntity<WalletResponse> getWallet(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getWalletByUserId(userId));
    }
    @PostMapping("/{userId}/wallet/deposit")
    public ResponseEntity<WalletResponse> deposit(
            @PathVariable Long userId,
            @Valid @RequestBody AmountRequest req
    ) {
        return ResponseEntity.ok(userService.deposit(userId, req));
    }
    @PostMapping("/{userId}/wallet/withdraw")
    public ResponseEntity<WalletResponse> withdraw(
            @PathVariable Long userId,
            @Valid @RequestBody AmountRequest req
    ) {
        return ResponseEntity.ok(userService.withdraw(userId, req));
    }

}
