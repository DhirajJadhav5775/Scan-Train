package com.Scan_Train.Scan_Train.MainController;

import com.Scan_Train.Scan_Train.DTO.*;
import com.Scan_Train.Scan_Train.Model.User;
import com.Scan_Train.Scan_Train.Repository.UserRepo;
import com.Scan_Train.Scan_Train.service.GeminiService;
import com.Scan_Train.Scan_Train.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class MainController
{

    @Autowired
    private UserService service;

    @Autowired
    private GeminiService geminiService;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody userDTO request) {
        return ResponseEntity.ok(service.signup(request));
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(@RequestBody VerifyOtpRequest request, HttpSession session) {

        return ResponseEntity.ok(service.verifyOtp(request.getEmail(), request.getOtp()));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request)
    {
        Optional<User> optionalUser = userRepo.findByEmail(request.getEmail());

        if (optionalUser.isEmpty()) {
            return ResponseEntity.badRequest().body("User not found");
        }

        User user = optionalUser.get();

        if (!user.getPassword().equals(request.getPassword())) {
            return ResponseEntity.badRequest().body("Invalid password");
        }

        return ResponseEntity.ok("Login successful! Welcome " + user.getFirstName());
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
