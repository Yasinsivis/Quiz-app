package com.example.luno;

public class ProcessResult {

    private String message;
    private Boolean result;

    public ProcessResult ( Boolean result, String message) {
        this.result = result;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getResult() {
        return result;
    }


    public void setResult(Boolean result) {
        this.result = result;
    }



}
