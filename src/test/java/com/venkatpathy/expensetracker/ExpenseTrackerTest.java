package com.venkatpathy.expensetracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpenseTrackerTest {

    @Test
    public void getUserInput_shouldGetExpenseInput(){
        ExpenseTracker expenseTracker = new ExpenseTracker();

        List<Expense> expenseList = new ArrayList<Expense>();
        expenseList.add(new Expense("A", 100, "Snacks", Arrays.asList("A","B","C","D")));
        //expenseList.add(new Expense("A", 100, "Snacks", Arrays.asList("A","B","C","D")));
        expenseList.add(new Expense("B", 500, "Taxi", Arrays.asList("C","D")));
        expenseList.add(new Expense("D", 300, "Bus", Arrays.asList("A","B")));

        expenseTracker.calculateTripExpense(expenseList);
    }


}