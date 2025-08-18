package com.Scan_Train.Scan_Train.MainController;

import com.Scan_Train.Scan_Train.Model.User;
import com.Scan_Train.Scan_Train.Repository.UserRepo;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.http.HttpResponse;

@Controller
public class MainController
{
    @Autowired
    private UserRepo userRepo;

    @PostMapping("/Sign_Up")
    public String SignUp(@ModelAttribute User user, HttpServletResponse response) throws IOException {
        if(!user.getPassword().equals(user.getConPassword()))
        {
            response.setContentType("text/html");
            response.getWriter().println("<script>alert('Passwords do not match!'); window.location.href = '/index.html';</script>");
            return null;
        }
        else {

            return null;
        }
    }

    @GetMapping("/login")
    public void Login(@RequestParam String email, @RequestParam String password)
    {

    }
}
