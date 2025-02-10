package com.budgetingapp.backend.dto;

import java.util.Date;

public class ExpenseDTO {
    private String description;
    private Double amount;
    private Date date;

    public ExpenseDTO(){}

    public ExpenseDTO(String description, Double amount, Date date){
        this.description=description;
        this.amount=amount;
        this.date=date;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public Double getAmount(){
        return amount;
    }

    public void setAmount(Double amount){
        this.amount=amount;
    }

    public Date getDate(){
        return date;
    }

    public void SetDate(Date date){
        this.date = date;
    }
}
