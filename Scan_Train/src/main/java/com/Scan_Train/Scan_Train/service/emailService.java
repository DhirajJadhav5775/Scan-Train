package com.Scan_Train.Scan_Train.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class emailService
{
    @Autowired
    private JavaMailSender mailSender;


    public void sendotp(String toEmail, String otp)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("OTP Verification For Scan&Train");
        message.setText("Your OTP is: " + otp);
        mailSender.send(message);
    }
}
