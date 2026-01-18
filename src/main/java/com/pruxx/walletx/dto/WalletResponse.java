package com.pruxx.walletx.dto;

public class WalletResponse {
    public Long walletId;
    public Long userId;
    public String currency;
    public long balanceCents;

    public WalletResponse(Long walletId, Long userId, String currency, long balanceCents) {
        this.walletId = walletId;
        this.userId = userId;
        this.currency = currency;
        this.balanceCents = balanceCents;
    }
}
