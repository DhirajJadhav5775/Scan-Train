package com.Scan_Train.Scan_Train.service;

import com.Scan_Train.Scan_Train.DTO.userDTO;
import com.Scan_Train.Scan_Train.Model.User;
import com.Scan_Train.Scan_Train.Repository.UserRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private emailService emailService;

    @Autowired
    private HttpSession session;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String signup(userDTO request) {
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            return "Passwords do not match";
        }

        Optional<User> existingUser = userRepo.findByEmail(request.getEmail());
        if (userRepo.existsByEmail(request.getEmail())) {
            return "Email already registered";
        }

        // Generate OTP
        String otp = String.valueOf(100000 + new Random().nextInt(900000));

        session.setAttribute("userData", request);
        session.setAttribute("otp", otp);
        // Send OTP
        emailService.sendotp(request.getEmail(), otp);

        return "OTP sent to email. Please verify to complete signup.";
    }

    public String verifyOtp(String email, String otp) {

        String sessionOtp = (String) session.getAttribute("otp");
        userDTO request = (userDTO) session.getAttribute("userData");

        if (sessionOtp == null || request == null) {
            return "No OTP session found or OTP expired.";
        }

        if (!request.getEmail().equals(email)) {
            return "Invalid email for verification.";
        }

        if (sessionOtp.equals(otp)) {
            // save user
            User user = new User();
            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());
            user.setEmail(request.getEmail());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setAge(request.getAge());
            user.setGender(request.getGender());

            userRepo.save(user);

            session.removeAttribute("otp");
            session.removeAttribute("userData");

            return "OTP verified successfully! User registered.";
        }
        else {
            return "Invalid OTP";
        }
    }

}