package com.FuzionSW.UdeA.ProyectoCiclo3.controllers.rest;

import com.FuzionSW.UdeA.ProyectoCiclo3.entities.Enterprise;
import com.FuzionSW.UdeA.ProyectoCiclo3.services.enterprise.EnterpriseNotFoundException;
import com.FuzionSW.UdeA.ProyectoCiclo3.services.enterprise.EnterpriseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class enterpriseRestController {

    private final EnterpriseService enterpriseService;

    public enterpriseRestController(EnterpriseService enterpriseService){
        this.enterpriseService = enterpriseService;
    }

    @GetMapping({"/enterprises"})
    public List<Enterprise> getEnterpriseList() {
        return this.enterpriseService.getEnterpriseList();
    }

    @GetMapping(value = "/enterprises/{id}")
    public Enterprise getEnterprise(@PathVariable Long id) throws EnterpriseNotFoundException {
        return this.enterpriseService.getEnterprise(id);
    }

    @PostMapping(value = "/enterprises")
    public Enterprise postEnterprise(@RequestBody Enterprise enterprise){
        return this.enterpriseService.createEnterprise(enterprise);
    }

    @PatchMapping(path = "/enterprises/{id}")
    public ResponseEntity<Enterprise> updateEnterprise(@PathVariable Long id, @RequestBody Enterprise enterprise) {
        try {
            Enterprise enterpriseUpdated = enterpriseService.getEnterprise(id);
            enterpriseUpdated.setName(enterprise.getName());
            enterpriseUpdated.setDocument(enterprise.getDocument());
            enterpriseUpdated.setPhone(enterprise.getPhone());
            enterpriseUpdated.setAddress(enterprise.getAddress());
            enterpriseService.saveEnterprise(enterpriseUpdated);
            return ResponseEntity.ok(enterpriseUpdated);
        } catch (EnterpriseNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping(value = "/enterprises/{id}")
    public ResponseEntity<Long> deleteEnterprise(@PathVariable Long id) throws EnterpriseNotFoundException {
        boolean isRemoved = this.enterpriseService.isEnterpriseDeleted(id);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
