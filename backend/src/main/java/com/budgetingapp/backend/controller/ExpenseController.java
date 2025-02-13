package com.budgetingapp.backend.controller;

import com.budgetingapp.backend.dto.ExpenseDTO;
import com.budgetingapp.backend.model.Expense;
import com.budgetingapp.backend.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    public ExpenseController(ExpenseRepository expenseRepository){
        this.expenseRepository=expenseRepository;
    }

    @GetMapping
    public List<Expense> getAllExpenses(){
        List<Expense> expenses = expenseRepository.findAll();
        return expenses;
    }

    @PostMapping
    public ResponseEntity<Expense> addExpense(@RequestBody ExpenseDTO expenseDTO){
        Expense expense = new Expense(
                expenseDTO.getDescription(),
                expenseDTO.getAmount(),
                expenseDTO.getDate(),
                expenseDTO.getCategory(),
                expenseDTO.getCurrency(),
                expenseDTO.getNotes()
        );
        Expense savedExpense = expenseRepository.save(expense);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedExpense);
    }

}
