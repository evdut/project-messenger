package com.project_messenger.rest.project.api.task;

import java.io.Serializable;

import org.javamoney.moneta.Money;

public class AddCostsToTaskRequestBody implements Serializable {

    private Money costs;
    
    
    public AddCostsToTaskRequestBody(Money costs) {

        this.costs = costs;
    }

    public Money costs() {
        return costs;
    }
}
