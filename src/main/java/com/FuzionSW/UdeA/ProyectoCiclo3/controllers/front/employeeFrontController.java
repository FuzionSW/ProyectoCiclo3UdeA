package com.FuzionSW.UdeA.ProyectoCiclo3.controllers.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class employeeFrontController {
    @GetMapping(value= "/front/users")
    public String showUsuarios() {
        return "/pages/employee/employee";
    }
}
