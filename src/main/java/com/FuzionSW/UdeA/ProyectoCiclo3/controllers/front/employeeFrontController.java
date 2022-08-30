package com.FuzionSW.UdeA.ProyectoCiclo3.controllers.front;

import com.FuzionSW.UdeA.ProyectoCiclo3.entities.Employee;
import com.FuzionSW.UdeA.ProyectoCiclo3.entities.Enterprise;
import com.FuzionSW.UdeA.ProyectoCiclo3.services.employee.EmployeeNotFoundException;
import com.FuzionSW.UdeA.ProyectoCiclo3.services.employee.EmployeeService;
import com.FuzionSW.UdeA.ProyectoCiclo3.services.enterprise.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class employeeFrontController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping(value= "/front/users")
    public String showEmployeeList(Model model) {
        List<Employee> employeeList = employeeService.getEmployeeList();
        model.addAttribute("employeeList", employeeList);
        return "/pages/employee/employee";
    }

    @GetMapping(value= "/front/users/new")
    public String showNewEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        List<Enterprise> enterpriseList = enterpriseService.getEnterpriseList();
        model.addAttribute("enterpriseList", enterpriseList);
        model.addAttribute("pageTitle","Crear un nuevo usuario");
        return "/pages/employee/new-employee";
    }

    @PostMapping(value = "/front/users/save")
    public String saveEmployee(Employee employee, RedirectAttributes ra){
        try {
            employeeService.saveEmployee(employee);
            ra.addFlashAttribute("message", "El usuario ha sido creado con éxito.");

            return "redirect:/front/users";
        } catch (Exception e){
            ra.addFlashAttribute("message","No se puede crear el usuario, por favor revise los datos ingresados.");
        }
        return "redirect:/front/users";
    }

    @PostMapping(value = "/front/users/edit")
    public String editEmployee(Employee employee, RedirectAttributes ra){
        try {
            employeeService.saveEmployee(employee);
            ra.addFlashAttribute("message", "El usuario ha sido modificado con éxito.");

            return "redirect:/front/users";
        } catch (Exception e){
            ra.addFlashAttribute("message","No se puede modificar el usuario, por favor revise los datos ingresados.");
        }
        return "redirect:/front/users";
    }

    @GetMapping(value = "/front/users/edit/{id}")
    public String showEditEmployee(@PathVariable("id") long id, Model model, RedirectAttributes ra){
        try {
            List<Enterprise> enterpriseList = enterpriseService.getEnterpriseList();
            model.addAttribute("enterpriseList", enterpriseList);

            Employee employee = employeeService.getEmployee(id);
            model.addAttribute("employee", employee);
            model.addAttribute("pageTitle","Modificar usuario- Id: " + id);
            return ("/pages/employee/edit-employee");
        } catch (EmployeeNotFoundException e){
            ra.addFlashAttribute("message","El usuario no ha sido modificado.");
            return "redirect:/front/users";
        }
    }

    @GetMapping(value = "/front/users/delete/{id}")
    public String deleteEmployee(@PathVariable("id") long id, Model model, RedirectAttributes ra){
        try {
            employeeService.deleteEmployee(id);
            ra.addFlashAttribute("message", "El usuario con Id: " + id + " ha sido eliminado.");
        } catch (EmployeeNotFoundException e){
            ra.addFlashAttribute("message","No se puede encontrar algún usuario con ID: " + id);
        }
        return "redirect:/front/users";
    }
}
