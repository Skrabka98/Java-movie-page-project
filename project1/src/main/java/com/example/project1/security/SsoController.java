package com.example.project1.security;

import com.example.project1.controller.FilmIndexControler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.rmi.ServerException;

@Controller
public class SsoController {
    @GetMapping("/logout")
    String logout(HttpServletRequest request, FilmIndexControler film) throws ServletException{
        request.logout();
        return "redirect:/";
    }

}
