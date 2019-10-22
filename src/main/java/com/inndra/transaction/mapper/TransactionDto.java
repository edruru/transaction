package com.inndra.transaction.mapper;

import java.time.LocalDate;
import java.util.Objects;

public class TransactionDto{

    private String transactionId;

    private Double amount;

    private Long userId;

    private LocalDate date;

    private String description;

    public TransactionDto() {
    }

    public TransactionDto(String transactionId, Double amount, Long userId, LocalDate date, String description) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.userId = userId;
        this.date = date;
        this.description = description;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionDto)) return false;
        TransactionDto that = (TransactionDto) o;
        return Objects.equals(transactionId, that.transactionId) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(date, that.date) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, amount, userId, date, description);
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "transactionId='" + transactionId + '\'' +
                ", amount=" + amount +
                ", userId=" + userId +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
