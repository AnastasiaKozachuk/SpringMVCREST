package com.test.repository;

import com.test.model.PersonLoan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
@PropertySource("classpath:my.properties")
public class FileRepository implements IFileRepository {

    @Value("${serverFilePath}")
    private String filePath;

    private List<PersonLoan> personLoans = new ArrayList<>();

    @Override
    public List<PersonLoan> findFilteredRows(String year, String state, String gender) throws Exception {

        if (personLoans.size() == 0) {
            parseObjectList();
        }

        List<String> genderParameterList = fillList(gender);
        List<String> statusParameterList = fillList(state);
        List<String> yearParameterList = fillList(year);

        List<PersonLoan> resultList = new ArrayList<>();

        for (PersonLoan loan : personLoans) {

            String loanGender = loan.getGender() == null ? "" : (loan.getGender().equals(BigDecimal.ZERO) ? "male" : "female");
            String loanStatus = loan.getStatus().toLowerCase();
            String loanYear = loan.getDateOfBirth().substring(6);

            Boolean isGenderFit = (genderParameterList.size() > 0 && genderParameterList.contains(loanGender)) || genderParameterList.size() == 0 ? Boolean.TRUE : Boolean.FALSE;
            Boolean isYearFit = (yearParameterList.size() > 0 && yearParameterList.contains(loanYear)) || yearParameterList.size() == 0 ? Boolean.TRUE : Boolean.FALSE;
            Boolean isStatusFit = (statusParameterList.size() > 0 && statusParameterList.contains(loanStatus)) || statusParameterList.size() == 0 ? Boolean.TRUE : Boolean.FALSE;

            if (isGenderFit && isYearFit && isStatusFit) {
                resultList.add(loan);
            }
        }

        return resultList;
    }


    private List<String> fillList(String searchCriteriaValue) {

        List<String> specificationList = new ArrayList<>();

        if (!StringUtils.isEmpty(searchCriteriaValue) && searchCriteriaValue.contains(",")) {
            specificationList.addAll(getListOfUserSpecification(searchCriteriaValue.split(",")));
        } else if (!StringUtils.isEmpty(searchCriteriaValue)) {
            specificationList.add(searchCriteriaValue);
        }


        return specificationList;
    }

    private List<String> getListOfUserSpecification(String[] list) {
        List<String> specificationList = new ArrayList<>();
        for (String specification : list) {
            specificationList.add(specification);
        }
        return specificationList;
    }

    private void parseObjectList() throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(filePath));

        br.readLine();
        String line;

        while ((line = br.readLine()) != null) {
            String lineParam[] = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            PersonLoan personLoan = new PersonLoan();
            Class<?> c = Class.forName("com.test.model.PersonLoan");

            Field allFields[] = c.getDeclaredFields();
            for (int i = 0; i < allFields.length; i++) {

                String methodName = "set" + StringUtils.capitalize(allFields[i].getName());
                Method method = c.getDeclaredMethod(methodName, Class.forName(allFields[i].getType().getName()));

                if (!StringUtils.isEmpty(lineParam[i])) {
                    method.invoke(personLoan, (Class.forName(allFields[i].getType().getName())).getConstructor(String.class).newInstance(lineParam[i]));
                }

            }
            personLoans.add(personLoan);
        }

    }
}
