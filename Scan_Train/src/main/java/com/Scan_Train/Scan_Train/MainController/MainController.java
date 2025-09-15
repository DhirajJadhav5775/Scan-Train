package com.Scan_Train.Scan_Train.MainController;

import com.Scan_Train.Scan_Train.DTO.AskRequest;
import com.Scan_Train.Scan_Train.DTO.AskResponse;
import com.Scan_Train.Scan_Train.DTO.VerifyOtpRequest;
import com.Scan_Train.Scan_Train.DTO.userDTO;
import com.Scan_Train.Scan_Train.service.GeminiService;
import com.Scan_Train.Scan_Train.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class MainController
{

    @Autowired
    private UserService service;

    @Autowired
    private GeminiService geminiService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody userDTO request) {
        return ResponseEntity.ok(service.signup(request));
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(@RequestBody VerifyOtpRequest request, HttpSession session) {

        return ResponseEntity.ok(service.verifyOtp(request.getEmail(), request.getOtp()));
    }

    @GetMapping("/login")
    public void Login(@RequestParam String email, @RequestParam String password)
    {

    }

    @PostMapping("/ask")
    public ResponseEntity<?> ask(@RequestBody AskRequest request){
        try{
            AskResponse response = geminiService.ask(request);
            return ResponseEntity.ok(response);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to get response from Gemini: " + e.getMessage());
        }
    }
}
