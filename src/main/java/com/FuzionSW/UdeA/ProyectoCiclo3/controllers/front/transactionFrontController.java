package com.FuzionSW.UdeA.ProyectoCiclo3.controllers.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class transactionFrontController {
    @GetMapping(value = "/front/transaction")
    public String showIngresosYEgresos() {
        return "/pages/transaction/transaction";
    }
}
