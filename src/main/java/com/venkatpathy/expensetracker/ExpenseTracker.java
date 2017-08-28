package com.venkatpathy.expensetracker;

import java.util.*;

public class ExpenseTracker {

    private Map<String, Integer> amountDueMap = new HashMap<>();

    public void calculateTripExpense(List<Expense> expenseList){
        expenseList.forEach(expense -> {
            List<String> personsSpentForList = expense.getPersonsSpentFor();
            Integer splitNos = personsSpentForList.size();
            Integer splitValue = expense.getAmountSpent()/splitNos;
            if(!amountDueMap.containsKey(expense.getPersonSpent())){
                if(personsSpentForList.contains(expense.getPersonSpent())) {
                    amountDueMap.put(expense.getPersonSpent(), expense.getAmountSpent() - splitValue);
                } else {
                    amountDueMap.put(expense.getPersonSpent(), expense.getAmountSpent());
                }
                personsSpentForList.forEach(personSpentFor -> {
                    updateAmountDueMap(amountDueMap, personSpentFor, expense.getPersonSpent(), splitValue);
                });
            } else {
                if(personsSpentForList.contains(expense.getPersonSpent())) {
                    amountDueMap.put(expense.getPersonSpent(), amountDueMap.get(expense.getPersonSpent()) + (expense.getAmountSpent() - splitValue));
                } else {
                    amountDueMap.put(expense.getPersonSpent(), amountDueMap.get(expense.getPersonSpent()) + expense.getAmountSpent());
                }
                personsSpentForList.forEach(personSpentFor -> {
                    updateAmountDueMap(amountDueMap, personSpentFor, expense.getPersonSpent(), splitValue);
                });
            }
        });

        amountDueMap.forEach((person, amount) -> {
            if(amount < 0){
                System.out.println(person + " has to give " + Math.abs(amount));
            } else {
                System.out.println(person + " has to get " + amount);
            }
        });

    }

    private void updateAmountDueMap(Map<String, Integer> amountDueMap, String personSpentFor, String personSpent, Integer splitValue){
        if(!amountDueMap.containsKey(personSpentFor)
                && !personSpentFor.equals(personSpent)){
            amountDueMap.put(personSpentFor, -splitValue);
        }else if(!personSpentFor.equals(personSpent)){
            amountDueMap.put(personSpentFor, amountDueMap.get(personSpentFor) - splitValue);
        }
    }

}
