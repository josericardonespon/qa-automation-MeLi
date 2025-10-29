package com.salesforce.tesa.utils;

public enum FlowType {
    FLOW("FLOW");

    private final String flowName;

    FlowType(String flowName) {
        this.flowName = flowName;
    }

    public String getFlowName() {
        return flowName;
    }

    @Override
    public String toString() {
        return flowName;
    }
}
