package com.FuzionSW.UdeA.ProyectoCiclo3;

import com.FuzionSW.UdeA.ProyectoCiclo3.entities.UserProfile;
import com.FuzionSW.UdeA.ProyectoCiclo3.services.userprofile.UserProfileService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController
{
    UserProfileService userProfileService;

    public MainController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping(value = "/")
    public String showHomePage(Model model, @AuthenticationPrincipal OidcUser principal) {
        if(principal != null) {
            UserProfile userProfile = this.userProfileService.GetorCreateUser(principal.getClaims());
            model.addAttribute("userProfile", userProfile);
        }

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