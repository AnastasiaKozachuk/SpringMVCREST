package com.test;

import com.test.model.PersonLoan;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;

public class UserSpecification implements Specification<PersonLoan> {

    private SearchCriteria criteria;

    public UserSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate
            (Root<PersonLoan> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

         if ( criteria.getKey().equals("status") && !StringUtils.isEmpty(criteria.getValue())) {
                return builder.equal(builder.lower(root.get(criteria.getKey())), criteria.getValue());
        }

        if ( criteria.getKey().equals("dateOfBirth")&& !StringUtils.isEmpty(criteria.getValue())) {
            return builder.equal(builder.substring(root.get(criteria.getKey()), 7), criteria.getValue());
        }

        if ( criteria.getKey().equals("gender")&& !StringUtils.isEmpty(criteria.getValue())) {
            int genderValue = criteria.getValue().equals("male")?0:(criteria.getValue().equals("female")?1:-1);
            if(genderValue!=-1){

                return builder.equal(root.get(criteria.getKey()), new BigDecimal(genderValue));
            }
        }
        return null;
    }
}
