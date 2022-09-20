package com.FuzionSW.UdeA.ProyectoCiclo3;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController
{
    @GetMapping(value = "/")
    public String showHomePage(Model model, @AuthenticationPrincipal OidcUser principal) {
        return "index";
    }

    @GetMapping(value = "/front/main")
    public String showMain() {
        return "main";
    }

    @GetMapping(value = "/logout")
    public String showLogout(){
        return "index";
    }
}