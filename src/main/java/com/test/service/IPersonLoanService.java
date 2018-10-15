package com.test.service;

import com.test.model.PersonLoan;
import java.util.List;

public interface IPersonLoanService {

    void importAll() throws Exception;
    List<PersonLoan> findFilteredRows(String year,String state,String gender);

}
