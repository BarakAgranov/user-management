package com.barak.user.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorBean {

    private List<Violation> violations = new ArrayList<>();

    public ValidationErrorBean(List<Violation> violations) {
        this.violations = violations;
    }

    public ValidationErrorBean() {
    }

    public List<Violation> getViolations() {
        return violations;
    }

    public void setViolations(List<Violation> violations) {
        this.violations = violations;
    }
}
