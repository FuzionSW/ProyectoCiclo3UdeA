package com.FuzionSW.UdeA.ProyectoCiclo3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController
{
    @GetMapping(value = "/")
    public String showHomePage() {
        return "index";
    }

    @GetMapping(value = "/ingresos-y-egresos")
    public String showIngresosYEgresos() {
        return "/pages/ingresos-y-egresos";
    }

    @GetMapping(value= "/usuarios")
    public String showUsuarios() {
        return "/pages/usuarios";
    }

    @GetMapping(value= "/empresas")
    public String showEmpresas() {
        return "/pages/empresas";
    }
}