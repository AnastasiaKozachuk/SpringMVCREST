package com.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "loans")
@Entity
public class PersonLoan {

    @Id
    @Column(name="id")
    private BigDecimal id;

    @Column(name="status")
    private String status;

    @Column(name="amount")
    private BigDecimal amount;

    @Column(name="\"applicationSignedHour\"")
    private BigDecimal applicationSignedHour;

    @Column(name="\"applicationSignedWeekday\"")
    private BigDecimal applicationSignedWeekday;

    @Column(name="city")
    private String city;

    @Column(name="country")
    private String country;

    @Column(name="\"creditScoreEsEquifaxRisk\"")
    private String creditScoreEsEquifaxRisk;

    @Column(name="\"dateOfBirth\"")
    private String dateOfBirth;

    @Column(name="\"debtToIncome\"")
    private BigDecimal debtToIncome;

    @Column(name="education")
    private BigDecimal education;

    @Column(name="\"employmentDurationCurrentEmployer\"")
    private String  employmentDurationCurrentEmployer;

    @Column(name="\"employmentPosition\"")
    private String employmentPosition;

    @Column(name="\"employmentStatus\"")
    private BigDecimal employmentStatus;

    @Column(name="\"existingLiabilities\"")
    private BigDecimal existingLiabilities;

    @Column(name="gender")
    private BigDecimal gender;

    @Column(name="\"homeOwnershipType\"")
    private BigDecimal homeOwnershipType;

    @Column(name="\"incomeFromPrincipalEmployer\"")
    private BigDecimal incomeFromPrincipalEmployer;

    @Column(name="\"incomeTotal\"")
    private BigDecimal  incomeTotal;

    @Column(name="interest_rate")
    private BigDecimal  interest_rate;

    @Column(name="\"loanDate\"")
    private String loanDate;

    @Column(name="\"loanDuration\"")
    private BigDecimal loanDuration;

    @Column(name="\"maritalStatus\"")
    private BigDecimal maritalStatus;

    @Column(name="\"newCreditCustomer\"")
    private Boolean newCreditCustomer;

    @Column(name="\"noOfPreviousLoansBeforeLoan\"")
    private BigDecimal noOfPreviousLoansBeforeLoan;

    @Column(name="\"occupationArea\"")
    private BigDecimal occupationArea;

    @Column(name="\"useOfLoan\"")
    private BigDecimal useOfLoan;

    @Column(name="\"verificationType\"")
    private BigDecimal verificationType;

    @Column(name="\"workExperience\"")
    private String  workExperience;

    @Column(name="\"previousScore\"")
    private BigDecimal previousScore;

    @Column(name="defaulted")
    private Boolean  defaulted;

    @Column(name="\"defaultDate\"")
    private String  defaultDate;


    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getApplicationSignedHour() {
        return applicationSignedHour;
    }

    public void setApplicationSignedHour(BigDecimal applicationSignedHour) {
        this.applicationSignedHour = applicationSignedHour;
    }

    public BigDecimal getApplicationSignedWeekday() {
        return applicationSignedWeekday;
    }

    public void setApplicationSignedWeekday(BigDecimal applicationSignedWeekday) {
        this.applicationSignedWeekday = applicationSignedWeekday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCreditScoreEsEquifaxRisk() {
        return creditScoreEsEquifaxRisk;
    }

    public void setCreditScoreEsEquifaxRisk(String creditScoreEsEquifaxRisk) {
        this.creditScoreEsEquifaxRisk = creditScoreEsEquifaxRisk;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public BigDecimal getDebtToIncome() {
        return debtToIncome;
    }

    public void setDebtToIncome(BigDecimal debtToIncome) {
        this.debtToIncome = debtToIncome;
    }

    public BigDecimal getEducation() {
        return education;
    }

    public void setEducation(BigDecimal education) {
        this.education = education;
    }

    public String getEmploymentDurationCurrentEmployer() {
        return employmentDurationCurrentEmployer;
    }

    public void setEmploymentDurationCurrentEmployer(String employmentDurationCurrentEmployer) {
        this.employmentDurationCurrentEmployer = employmentDurationCurrentEmployer;
    }

    public String getEmploymentPosition() {
        return employmentPosition;
    }

    public void setEmploymentPosition(String employmentPosition) {
        this.employmentPosition = employmentPosition;
    }

    public BigDecimal getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(BigDecimal employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public BigDecimal getExistingLiabilities() {
        return existingLiabilities;
    }

    public void setExistingLiabilities(BigDecimal existingLiabilities) {
        this.existingLiabilities = existingLiabilities;
    }

    public BigDecimal getGender() {
        return gender;
    }

    public void setGender(BigDecimal gender) {
        this.gender = gender;
    }

    public BigDecimal getHomeOwnershipType() {
        return homeOwnershipType;
    }

    public void setHomeOwnershipType(BigDecimal homeOwnershipType) {
        this.homeOwnershipType = homeOwnershipType;
    }

    public BigDecimal getIncomeFromPrincipalEmployer() {
        return incomeFromPrincipalEmployer;
    }

    public void setIncomeFromPrincipalEmployer(BigDecimal incomeFromPrincipalEmployer) {
        this.incomeFromPrincipalEmployer = incomeFromPrincipalEmployer;
    }

    public BigDecimal getIncomeTotal() {
        return incomeTotal;
    }

    public void setIncomeTotal(BigDecimal incomeTotal) {
        this.incomeTotal = incomeTotal;
    }

    public BigDecimal getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(BigDecimal interest_rate) {
        this.interest_rate = interest_rate;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    public BigDecimal getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(BigDecimal loanDuration) {
        this.loanDuration = loanDuration;
    }

    public BigDecimal getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(BigDecimal maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Boolean getNewCreditCustomer() {
        return newCreditCustomer;
    }

    public void setNewCreditCustomer(Boolean newCreditCustomer) {
        this.newCreditCustomer = newCreditCustomer;
    }

    public BigDecimal getNoOfPreviousLoansBeforeLoan() {
        return noOfPreviousLoansBeforeLoan;
    }

    public void setNoOfPreviousLoansBeforeLoan(BigDecimal noOfPreviousLoansBeforeLoan) {
        this.noOfPreviousLoansBeforeLoan = noOfPreviousLoansBeforeLoan;
    }

    public BigDecimal getOccupationArea() {
        return occupationArea;
    }

    public void setOccupationArea(BigDecimal occupationArea) {
        this.occupationArea = occupationArea;
    }

    public BigDecimal getUseOfLoan() {
        return useOfLoan;
    }

    public void setUseOfLoan(BigDecimal useOfLoan) {
        this.useOfLoan = useOfLoan;
    }

    public BigDecimal getVerificationType() {
        return verificationType;
    }

    public void setVerificationType(BigDecimal verificationType) {
        this.verificationType = verificationType;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public BigDecimal getPreviousScore() {
        return previousScore;
    }

    public void setPreviousScore(BigDecimal previousScore) {
        this.previousScore = previousScore;
    }

    public Boolean getDefaulted() {
        return defaulted;
    }

    public void setDefaulted(Boolean defaulted) {
        this.defaulted = defaulted;
    }

    public String getDefaultDate() {
        return defaultDate;
    }

    public void setDefaultDate(String defaultDate) {
        this.defaultDate = defaultDate;
    }
}
