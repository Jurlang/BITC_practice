package org.bitcprac.boot04.repository;

import org.bitcprac.boot04.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
