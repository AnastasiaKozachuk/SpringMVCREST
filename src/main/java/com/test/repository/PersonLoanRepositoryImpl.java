package com.test.repository;

import com.test.model.PersonLoan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.File;

@Repository
@Transactional
public class PersonLoanRepositoryImpl implements PersonLoanRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Value("${serverFilePath}")
    private String filePath;

    @Override
    public void loadCSVFileIntoTable() {

        String absolutePath =  new File(filePath).getAbsolutePath();
        Query query = entityManager.createNativeQuery("Copy loans FROM '"+absolutePath+"' DELIMITER ',' CSV HEADER ENCODING 'UTF8';", PersonLoan.class);
        query.executeUpdate();

    }
}
