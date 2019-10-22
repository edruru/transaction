package com.inndra.transaction.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Transaction {

	@Id
	@GeneratedValue
	private Long id;

	private String transactionId;

	private Double amount;

	private Long userId;

	private LocalDate date;

	private String description;

	public Transaction(){}

	public Transaction( String transactionId, Double amount, Long userId, LocalDate date, String description) {
		this.transactionId=transactionId;
		this.amount = amount;
		this.userId = userId;
		this.date = date;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		if (!(o instanceof Transaction)) return false;
		Transaction that = (Transaction) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(transactionId, that.transactionId) &&
				Objects.equals(amount, that.amount) &&
				Objects.equals(userId, that.userId) &&
				Objects.equals(date, that.date) &&
				Objects.equals(description, that.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, transactionId, amount, userId, date, description);
	}

	@Override
	public String toString() {
		return "Transaction{" +
				"id=" + id +
				", transactionId='" + transactionId + '\'' +
				", amount=" + amount +
				", userId=" + userId +
				", date=" + date +
				", description='" + description + '\'' +
				'}';
	}
}
