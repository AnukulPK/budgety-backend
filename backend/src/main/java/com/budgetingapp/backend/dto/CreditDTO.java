package com.budgetingapp.backend.dto;

import java.util.Date;

public class CreditDTO {
    private String source;
    private String description;
    private Double amount;
    private Date date;
    private String category;
    private String currency;
    private String notes;

    // Default constructor (required by JPA)
    public CreditDTO() {}

    // Parameterized constructor (includes all fields)
    public CreditDTO(String source, String description, Double amount, Date date, String category, String currency, String notes) {
        this.source = source;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.currency = currency;
        this.notes = notes;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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
