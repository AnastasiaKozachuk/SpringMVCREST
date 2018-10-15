package com.test.repository;

import com.test.model.PersonLoan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.math.BigDecimal;

public interface PersonLoanRepository extends JpaRepository<PersonLoan, BigDecimal>, JpaSpecificationExecutor<PersonLoan>, PersonLoanRepositoryCustom {

}
