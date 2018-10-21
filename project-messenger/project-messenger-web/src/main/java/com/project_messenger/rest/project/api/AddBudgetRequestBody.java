package com.project_messenger.rest.project.api;

import java.io.Serializable;

import org.javamoney.moneta.Money;

public class AddBudgetRequestBody implements Serializable {
 
    private Money budget;
    
    public AddBudgetRequestBody(String uuid, Money budget) {
        this.budget = budget;
    }

    public Money budget() {
        return budget;
    }
   
}
