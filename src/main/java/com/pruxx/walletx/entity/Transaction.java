package com.pruxx.walletx.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "wallet_id", nullable = false)
    private Long walletId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TransactionType type;

    @Column(name = "amount_cents", nullable = false)
    private Long amountCents;

    @Column(name = "balance_after", nullable = false)
    private Long balanceAfter;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    public Transaction() {}

    public Transaction(Long walletId, TransactionType type, Long amountCents, Long balanceAfter) {
        this.walletId = walletId;
        this.type = type;
        this.amountCents = amountCents;
        this.balanceAfter = balanceAfter;
    }

    public Long getId() { return id; }
    public Long getWalletId() { return walletId; }
    public TransactionType getType() { return type; }
    public Long getAmountCents() { return amountCents; }
    public Long getBalanceAfter() { return balanceAfter; }
    public Instant getCreatedAt() { return createdAt; }
}
