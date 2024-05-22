package org.bitcprac.boot04.repository;

import org.bitcprac.boot04.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	Optional<Expense> findByExpenseId(String expenseId);
	List<Expense> findByNameContainingAndDateBetweenAndUserId(String keyword, Date start, Date end, Long userId);
	List<Expense> findByUserId(Long id);
	List<Expense> findByDateBetweenAndUserId(Date start, Date end, Long userId);
}
