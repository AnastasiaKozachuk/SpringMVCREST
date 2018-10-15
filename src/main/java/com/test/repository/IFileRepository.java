package com.test.repository;

import com.test.model.PersonLoan;
import java.util.List;

public interface IFileRepository {

    List<PersonLoan> findFilteredRows(String year, String state, String gender) throws Exception;

}
