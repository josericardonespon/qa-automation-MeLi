package com.salesforce.tesa.utils;

import io.cucumber.guice.ScenarioScoped;

import java.util.concurrent.Flow;

@ScenarioScoped
public class Context {

    private FlowType flowType;

    public void setFlowType(FlowType flowType) {
        this.flowType = flowType;
    }

}
