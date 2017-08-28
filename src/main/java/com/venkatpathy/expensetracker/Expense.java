package com.venkatpathy.expensetracker;

import java.util.List;

public class Expense {

    private String personSpent;
    private Integer amountSpent;
    private String spentOnItem;
    private List<String> personsSpentFor;

    public Expense(String personSpent, Integer amountSpent, String spentOnItem, List<String> personsSpentFor) {
        this.personSpent = personSpent;
        this.amountSpent = amountSpent;
        this.spentOnItem = spentOnItem;
        this.personsSpentFor = personsSpentFor;
    }

    public String getPersonSpent() {
        return personSpent;
    }

    public Integer getAmountSpent() {
        return amountSpent;
    }

    public List<String> getPersonsSpentFor() {
        return personsSpentFor;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "personSpent='" + personSpent + '\'' +
                ", amountSpent=" + amountSpent +
                ", spentOnItem='" + spentOnItem + '\'' +
                ", personsSpentFor=" + personsSpentFor +
                '}';
    }
}
