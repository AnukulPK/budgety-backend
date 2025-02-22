package com.budgetingapp.backend.service;

import com.budgetingapp.backend.dto.ExpenseDTO;
import com.budgetingapp.backend.model.Expense;
import com.budgetingapp.backend.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository)
    {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getAllExpenses()
    {
        return expenseRepository.findAll();
    }

    public Expense addExpense(Expense expense){
        return expenseRepository.save(expense);
    }

    public Expense updateExpense(Long id, ExpenseDTO expenseDTO) {
        return expenseRepository.findById(id).map(expense->{
            expense.setDescription(expenseDTO.getDescription());
            expense.setAmount(expenseDTO.getAmount());
            expense.setDate(expenseDTO.getDate());
            expense.setCategory(expenseDTO.getCategory());
            expense.setCurrency(expenseDTO.getCurrency());
            expense.setNotes(expenseDTO.getNotes());
            return expenseRepository.save(expense);
        }).orElseThrow(()->new RuntimeException("Expense not found with id: "+id));
    }
}
