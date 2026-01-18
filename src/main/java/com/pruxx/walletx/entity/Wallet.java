package com.pruxx.walletx.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private AppUser user;

    @Column(name = "balance_cents", nullable = false)
    private long balanceCents = 0;

    @Column(nullable = false, length = 3)
    private String currency = "CAD";

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    public Wallet() {}

    public Wallet(AppUser user) {
        this.user = user;
    }

    public Long getId() { return id; }
    public AppUser getUser() { return user; }
    public long getBalanceCents() { return balanceCents; }
    public String getCurrency() { return currency; }
    public Instant getCreatedAt() { return createdAt; }

    public void setUser(AppUser user) { this.user = user; }
    public void setBalanceCents(long balanceCents) { this.balanceCents = balanceCents; }
    public void setCurrency(String currency) { this.currency = currency; }
}
