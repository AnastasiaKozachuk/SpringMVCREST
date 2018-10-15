package com.test.service;


import com.test.SearchCriteria;
import com.test.UserSpecification;
import com.test.model.PersonLoan;
import com.test.repository.PersonLoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonLoanService implements IPersonLoanService {

    @Autowired
    private PersonLoanRepository repository;

    @Override
    public void importAll() throws Exception {
        repository.deleteAll();
        repository.loadCSVFileIntoTable();
    }

    @Override
    public List<PersonLoan> findFilteredRows(String year, String state, String gender) {

        List<UserSpecification> specificationListGender = fillList("gender", gender);
        List<UserSpecification> specificationListStatus = fillList("status", state);
        List<UserSpecification> specificationListYear = fillList("dateOfBirth", year);

        Specifications specificationsGender = fillSpecifications(specificationListGender);
        Specifications specificationsStatus = fillSpecifications(specificationListStatus);
        Specifications specificationsYear = fillSpecifications(specificationListYear);

        return repository.findAll(Specifications.where(specificationsGender).and(specificationsStatus).and(specificationsYear));
    }

    private Specifications fillSpecifications(List<UserSpecification> specificationList) {

        Specifications specifications = Specifications.where(specificationList.get(0));

        for (int i = 1; i < specificationList.size(); i++) {
            specifications = specifications.or(specificationList.get(i));
        }

        return specifications;


    }

    private List<UserSpecification> fillList(String searchCriteriaName, String searchCriteriaValue) {

        List<UserSpecification> specificationList = new ArrayList<>();

        if (!StringUtils.isEmpty(searchCriteriaValue) && searchCriteriaValue.contains(",")) {
            specificationList.addAll(getListOfUserSpecification(searchCriteriaName, searchCriteriaValue.split(",")));
        } else {
            specificationList.add(new UserSpecification(new SearchCriteria(searchCriteriaName, searchCriteriaValue)));
        }


        return specificationList;
    }

    private List<UserSpecification> getListOfUserSpecification(String searchCriteriaName, String[] list) {
        List<UserSpecification> specificationList = new ArrayList<>();
        for (String specification : list) {
            specificationList.add(new UserSpecification(new SearchCriteria(searchCriteriaName, specification)));
        }
        return specificationList;
    }

}
