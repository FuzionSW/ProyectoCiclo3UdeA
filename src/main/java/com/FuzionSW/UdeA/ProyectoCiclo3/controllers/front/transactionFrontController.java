package com.FuzionSW.UdeA.ProyectoCiclo3.controllers.front;

import com.FuzionSW.UdeA.ProyectoCiclo3.entities.Employee;
import com.FuzionSW.UdeA.ProyectoCiclo3.entities.Enterprise;
import com.FuzionSW.UdeA.ProyectoCiclo3.entities.Transaction;
import com.FuzionSW.UdeA.ProyectoCiclo3.services.employee.EmployeeService;
import com.FuzionSW.UdeA.ProyectoCiclo3.services.enterprise.EnterpriseService;
import com.FuzionSW.UdeA.ProyectoCiclo3.services.transaction.TransactionNotFoundException;
import com.FuzionSW.UdeA.ProyectoCiclo3.services.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.List;


@Controller
public class transactionFrontController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping(value= "/front/movements")
    public String showTransactionList(Model model) {
        List< Transaction> transactionList = transactionService.getTransactionList();
        model.addAttribute("transactionList", transactionList);
        return "/pages/transaction/transaction";
    }

    @GetMapping(value= "/front/movements/new")
    public String showNewTransaction(Model model) {
        List<Employee> employeeList = employeeService.getEmployeeList();
        model.addAttribute("employeeList", employeeList);

        List<Enterprise> enterpriseList = enterpriseService.getEnterpriseList();
        model.addAttribute("enterpriseList", enterpriseList);

        model.addAttribute("transaction", new Transaction());
        model.addAttribute("pageTitle","Crear un nuevo movimiento");
        return "/pages/transaction/new-transaction";
    }

    @PostMapping(value = "/front/movements/save")
    public String saveTransaction(Transaction transaction, RedirectAttributes ra) {
        try {
            transaction.setUpdatedAt(LocalDateTime.now());
            transactionService.saveTransaction(transaction);
            ra.addFlashAttribute("message", "El movimiento ha sido creado con éxito.");
        } catch (Exception e) {
            ra.addFlashAttribute("message","No se puede crear el movimiento, por favor revise los datos ingresados.");
        }
        return "redirect:/front/movements";
    }

    @PostMapping(value = "/front/movements/edit")
    public String editTransaction(Transaction transaction, RedirectAttributes ra) {
        try {
            transaction.setUpdatedAt(LocalDateTime.now());
            transactionService.saveTransaction(transaction);
            ra.addFlashAttribute("message", "El movimiento ha sido modificado con éxito.");
        } catch (Exception e) {
            ra.addFlashAttribute("message","No se puede modificar el movimiento, por favor revise los datos ingresados.");
        }
        return "redirect:/front/movements";
    }

    @GetMapping(value = "/front/movements/edit/{id}")
    public String showEditTransaction(@PathVariable("id") long id, Model model, RedirectAttributes ra) throws TransactionNotFoundException {
        try {
            List<Employee> employeeList = employeeService.getEmployeeList();
            model.addAttribute("employeeList", employeeList);

            List<Enterprise> enterpriseList = enterpriseService.getEnterpriseList();
            model.addAttribute("enterpriseList", enterpriseList);
            
            Transaction transaction = transactionService.getTransaction(id);
            model.addAttribute("transaction", transaction);
            model.addAttribute("pageTitle","Modificar movimiento - Id: " + id);
            return ("/pages/transaction/edit-transaction");
        } catch (TransactionNotFoundException e){
            ra.addFlashAttribute("message","El movimiento ha sido modificado.");
            return "redirect:/front/movements";
        }
    }

    @GetMapping(value = "/front/movements/delete/{id}")
    public String deleteTransaction(@PathVariable("id") long id, Model model, RedirectAttributes ra) {
        try {
            transactionService.deleteTransaction(id);
            ra.addFlashAttribute("message", "El movimiento Id: " + id + " ha sido eliminado.");
        } catch (TransactionNotFoundException e) {
            ra.addFlashAttribute("message","No se puede encontrar algún movimiento con ID: " + id);
        }
        return "redirect:/front/movements";
    }
}
