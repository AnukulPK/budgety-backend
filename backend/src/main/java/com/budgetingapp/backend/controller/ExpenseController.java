package com.budgetingapp.backend.controller;

import com.budgetingapp.backend.dto.ExpenseDTO;
import com.budgetingapp.backend.model.Expense;
import com.budgetingapp.backend.service.ExpenseService;  // Import the service
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;  // Use the service instead of repository

    // Constructor-based injection (recommended)
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();  // Use the service method
    }

    @PostMapping
    public ResponseEntity<Expense> addExpense(@RequestBody ExpenseDTO expenseDTO) {
        Expense expense = new Expense(
                expenseDTO.getDescription(),
                expenseDTO.getAmount(),
                expenseDTO.getDate(),
                expenseDTO.getCategory(),
                expenseDTO.getCurrency(),
                expenseDTO.getNotes()
        );

        Expense savedExpense = expenseService.addExpense(expense);  // Use the service method
        return ResponseEntity.status(HttpStatus.CREATED).body(savedExpense);
    }
}
