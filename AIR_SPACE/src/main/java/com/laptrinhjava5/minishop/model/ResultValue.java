package com.laptrinhjava5.minishop.model;

import java.util.Map;

public class ResultValue {

    private Object result;
    private Map<String, Object> error;

    public ResultValue() {
    }

    public ResultValue(Object result, Map<String, Object> error) {
        this.result = result;
        this.error = error;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Map<String, Object> getError() {
        return error;
    }

    public void setError(Map<String, Object> error) {
        this.error = error;
    }
}
