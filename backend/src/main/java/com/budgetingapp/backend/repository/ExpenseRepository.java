package com.budgetingapp.backend.repository;

import com.budgetingapp.backend.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findExpensesByDate(Date date);

    List<Expense> findExpensesByDateBetween(Date startDate, Date endDate);
}
