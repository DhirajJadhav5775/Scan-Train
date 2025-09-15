package com.Scan_Train.Scan_Train.DTO;

public class AskRequest
{
    private String prompt;
    private String temperature;
    private String maxTokens;

    public String getPrompt(){
        return prompt;
    }

    public void setPrompt(String prompt){
        this.prompt = prompt;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(String maxTokens) {
        this.maxTokens = maxTokens;
    }
}
