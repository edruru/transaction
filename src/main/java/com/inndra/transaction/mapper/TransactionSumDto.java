package com.inndra.transaction.mapper;

import java.math.BigDecimal;
import java.util.Objects;

public class TransactionSumDto {

    private Long userId;

    private BigDecimal sum;

    public TransactionSumDto() {
    }

    public TransactionSumDto(Long userId, BigDecimal sum) {
        this.userId = userId;
        this.sum = sum;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionSumDto)) return false;
        TransactionSumDto that = (TransactionSumDto) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(sum, that.sum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, sum);
    }

    @Override
    public String toString() {
        return "TransactionSumDto{" +
                "userId=" + userId +
                ", sum=" + sum +
                '}';
    }
}
