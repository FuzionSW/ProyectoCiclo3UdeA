package com.FuzionSW.UdeA.ProyectoCiclo3.controllers.front;

import com.FuzionSW.UdeA.ProyectoCiclo3.entities.Employee;
import com.FuzionSW.UdeA.ProyectoCiclo3.entities.Enterprise;
import com.FuzionSW.UdeA.ProyectoCiclo3.entities.Transaction;
import com.FuzionSW.UdeA.ProyectoCiclo3.services.employee.EmployeeService;
import com.FuzionSW.UdeA.ProyectoCiclo3.services.enterprise.EnterpriseNotFoundException;
import com.FuzionSW.UdeA.ProyectoCiclo3.services.enterprise.EnterpriseService;
import com.FuzionSW.UdeA.ProyectoCiclo3.services.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class enterpriseFrontController {
    @Autowired
    private EnterpriseService enterpriseService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TransactionService transactionService;

    @GetMapping(value= "/front/enterprises")
    public String showEnterpriseList(Model model) {
        List<Enterprise> enterpriseList = enterpriseService.getEnterpriseList();
        model.addAttribute("enterpriseList", enterpriseList);
        return "pages/enterprise/enterprise";
    }

    @GetMapping(value= "/front/enterprises/new")
    public String showNewEnterprise(Model model) {
        model.addAttribute("enterprise", new Enterprise());
        model.addAttribute("pageTitle","Crear una nueva empresa");
        return "pages/enterprise/new-enterprise";
    }

    @PostMapping(value = "/front/enterprises/save")
    public String saveEnterprise(Enterprise enterprise, RedirectAttributes ra){
        try {
            enterpriseService.saveEnterprise(enterprise);
            ra.addFlashAttribute("message", "La empresa ha sido creada con ??xito.");

            return "redirect:/front/enterprises";
        } catch (Exception e){
            ra.addFlashAttribute("message","No se puede crear la empresa, por favor revise los datos ingresados.");
        }
        return "redirect:/front/enterprises";
    }

    @PostMapping(value = "/front/enterprises/edit")
    public String editEnterprise(Enterprise enterprise, RedirectAttributes ra){
        try {
            enterpriseService.saveEnterprise(enterprise);
            ra.addFlashAttribute("message", "La empresa ha sido modificada con ??xito.");

            return "redirect:/front/enterprises";
        } catch (Exception e){
            ra.addFlashAttribute("message","No se puede modificar la empresa, por favor revise los datos ingresados.");
        }
        return "redirect:/front/enterprises";
    }

    @GetMapping(value = "/front/enterprises/edit/{id}")
    public String showEditEnterprise(@PathVariable("id") long id, Model model, RedirectAttributes ra){
        try {
            Enterprise enterprise = enterpriseService.getEnterprise(id);
            model.addAttribute("enterprise", enterprise);
            model.addAttribute("pageTitle","Modificar empresa - Id: " + id);
            return ("pages/enterprise/edit-enterprise");
        } catch (EnterpriseNotFoundException e){
            ra.addFlashAttribute("message","La empresa no ha sido modificada.");
            return "redirect:/front/enterprises";
        }
    }

    @GetMapping(value = "/front/enterprises/delete/{id}")
    public String deleteEnterprise(@PathVariable("id") long id, Model model, RedirectAttributes ra){
        try {
            enterpriseService.deleteEnterprise(id);
            ra.addFlashAttribute("message", "La empresa Id: " + id + " ha sido eliminada.");
        } catch (EnterpriseNotFoundException e){
            ra.addFlashAttribute("message","No se puede encontrar alguna empresa con ID: " + id);
        }
        return "redirect:/front/enterprises";
    }

    @GetMapping("/front/enterprises/{id}/employees") //Filtrar los empleados por empresa
    public String listEmployeesByEnterprise(@PathVariable("id") Long id, Model model){
        List<Employee> employeeListByEnterprise = employeeService.getEmployeeListByEnterpriseId(id);
        model.addAttribute("employeeListByEnterprise",employeeListByEnterprise);
        return "pages/employee/viewEmployees";
    }

    @GetMapping("/front/enterprises/{id}/movements") //Filtrar los empleados por empresa
    public String listMovementsByEnterprise(@PathVariable("id") Long id, Model model){
        List<Transaction> transactionListByEnterprise = transactionService.getMovementListByEnterpriseId(id);
        float amountByEnterprise = transactionService.getAmountByEnterprise(id);

        model.addAttribute("amountByEnterprise",amountByEnterprise);
        model.addAttribute("transactionListByEnterprise",transactionListByEnterprise);
        return "pages/transaction/viewTransactions";
    }
}
