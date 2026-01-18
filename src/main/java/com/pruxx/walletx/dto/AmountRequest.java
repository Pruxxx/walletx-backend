package com.pruxx.walletx.dto;

import jakarta.validation.constraints.Min;

public class AmountRequest {
    @Min(1)
    public long amountCents;
}
