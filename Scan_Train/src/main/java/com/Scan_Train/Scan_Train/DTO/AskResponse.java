package com.Scan_Train.Scan_Train.DTO;

public class AskResponse {
    private String answer;
    private Object raw;

    public AskResponse(){}

    public AskResponse(String answer, Object raw){
        this.answer = answer;
        this.raw = raw;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Object getRaw() {
        return raw;
    }

    public void setRaw(Object raw) {
        this.raw = raw;
    }
}
