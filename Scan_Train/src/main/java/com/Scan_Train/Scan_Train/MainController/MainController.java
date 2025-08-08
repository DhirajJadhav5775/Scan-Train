package com.Scan_Train.Scan_Train.MainController;

import com.Scan_Train.Scan_Train.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController
{
    @PostMapping("Sign_Up")
    public void SignUp(@ModelAttribute User user)
    {
        if(user.getPassword().equals(user.getConPassword()))
        {

        }
    }

    @GetMapping("login")
    public void Login(@RequestParam String email, @RequestParam String password)
    {

    }
}
