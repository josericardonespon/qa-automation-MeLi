package com.salesforce.tesa.utils;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;


public class Users {

    private final EnvironmentVariables environmentVariables;

    public Users() {
        this.environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    }

    public String getUsername() {
        return EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("salesforce.username");
    }

    public String getPassword() {
        return EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("salesforce.password");
    }
}
