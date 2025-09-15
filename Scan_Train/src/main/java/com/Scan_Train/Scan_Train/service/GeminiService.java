package com.Scan_Train.Scan_Train.service;

import com.Scan_Train.Scan_Train.DTO.AskRequest;
import com.Scan_Train.Scan_Train.DTO.AskResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GeminiService
{
    private final RestTemplate restTemplate;
    private final String apiKey;
    private final String apiUrl;
    private final String model;
    private final int timeoutMs;

    public GeminiService(
            @Value("${gemini.api.key}") String apiKey,
            @Value("${gemini.api.url}") String apiUrl,
            @Value("${gemini.model}") String model,
            @Value("${gemini.timeout-ms}") int timeoutMs
    ){
        this.apiKey = apiKey;
        this.apiUrl = apiUrl;
        this.model = model;
        this.timeoutMs = timeoutMs;
        this.restTemplate = new RestTemplate();
    }

    public AskResponse ask(AskRequest req) {
        if (req == null || req.getPrompt() == null || req.getPrompt().trim().isEmpty()) {
            throw new IllegalArgumentException("Prompt must not be empty");
        }

        // Build Gemini request body
        Map<String, Object> body = new HashMap<>();
        body.put("model", model);

        List<Map<String, String>> messages = new ArrayList<>();
        Map<String, String> userMsg = new HashMap<>();
        userMsg.put("role", "user");
        userMsg.put("content", req.getPrompt());
        messages.add(userMsg);
        body.put("messages", messages);

        if (req.getTemperature() != null) {
            body.put("temperature", req.getTemperature());
        }
        if (req.getMaxTokens() != null) {
            body.put("max_tokens", req.getMaxTokens());
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<Map> respEntity;
        try {
            respEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, Map.class);
        } catch (Exception e) {
            throw new RuntimeException("Error calling Gemini API: " + e.getMessage(), e);
        }

        Map<?, ?> respBody = respEntity.getBody();
        String answer = extractAnswer(respBody);

        return new AskResponse(answer, respBody);
    }

    private String extractAnswer(Map<?, ?> resp) {
        if (resp == null) return "";
        Object choicesObj = resp.get("choices");
        if (!(choicesObj instanceof List)) {
            return resp.toString();
        }
        List<?> choices = (List<?>) choicesObj;
        if (choices.isEmpty()) {
            return "";
        }
        Object first = choices.get(0);
        if (!(first instanceof Map)) {
            return first.toString();
        }
        Map<?, ?> firstChoice = (Map<?, ?>) first;
        Object messageObj = firstChoice.get("message");
        if (messageObj instanceof Map) {
            Object content = ((Map<?, ?>) messageObj).get("content");
            if (content != null) return content.toString().trim();
        }
        Object text = firstChoice.get("text");
        if (text != null) return text.toString().trim();

        return resp.toString();
    }
}
