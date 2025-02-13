package com.budgetingapp.backend.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "expenses") // Explicitly naming the table
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Double amount;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String category;
    private String currency;
    private String notes;

    // Default constructor (required by JPA)
    public Expense() {}

    // Parameterized constructor (includes all fields)
    public Expense(String description, Double amount, Date date, String category, String currency, String notes) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.currency = currency;
        this.notes = notes;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
