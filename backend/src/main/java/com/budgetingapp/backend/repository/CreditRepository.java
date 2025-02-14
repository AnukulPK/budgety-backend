package com.budgetingapp.backend.repository;

import com.budgetingapp.backend.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {
    List<Credit> findCreditByDate(Date date);

    List<Credit> findCreditByDateBetween(Date startDate, Date endDate);
}
