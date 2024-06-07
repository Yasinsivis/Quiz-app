package com.example.luno;

public class ProcessResult {

    private String message;
    private Boolean result;

    private Questions quesiton;

    public ProcessResult ( Boolean result, String message) {
        this.result = result;
        this.message = message;
    }
    public ProcessResult(Boolean result,String message , Questions question){
        this.result=result;
        this.message=message;
        this.quesiton=question;
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

    public Questions getQuestion(){
        return quesiton;
    }

}
