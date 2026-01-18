package com.pruxx.walletx.dto;

public class CreateUserResponse {
    public Long userId;
    public Long walletId;
    public String name;
    public String email;
    public String currency;
    public long balanceCents;

    public CreateUserResponse(Long userId, Long walletId, String name, String email, String currency, long balanceCents) {
        this.userId = userId;
        this.walletId = walletId;
        this.name = name;
        this.email = email;
        this.currency = currency;
        this.balanceCents = balanceCents;
    }
}
