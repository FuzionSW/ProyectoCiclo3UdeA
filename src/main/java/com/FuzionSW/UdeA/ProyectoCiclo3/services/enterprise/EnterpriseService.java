package com.FuzionSW.UdeA.ProyectoCiclo3.services.enterprise;

import com.FuzionSW.UdeA.ProyectoCiclo3.entities.Enterprise;
import com.FuzionSW.UdeA.ProyectoCiclo3.repositories.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseService {
    @Autowired                                         //Conectamos esta clase con el repositorio de Empresa
    private EnterpriseRepository enterpriseRepository; //Creamos un objeto tipo EmpresaRepository para poder usar los metodos que dicha clase hereda

    //Metodo que retornará la lista de empresas usando metodos heredados del jpaRepository
    public List<Enterprise> getEnterpriseList(){
        return enterpriseRepository.findAll();
    }

    public Enterprise getEnterprise(long id) throws EnterpriseNotFoundException {
        Optional<Enterprise> optionalEnterprise = enterpriseRepository.findById(id);

        if (optionalEnterprise.isPresent()){
            return optionalEnterprise.get();
        }

        throw new EnterpriseNotFoundException("No se pudo encontrar ninguna empresa con el Id: " + id);
    }

    public Enterprise createEnterprise(Enterprise enterprise){
        return enterpriseRepository.save(enterprise);
    }

    public void saveEnterprise(Enterprise enterprise) {
        enterpriseRepository.save(enterprise);
    }

    public boolean isEnterpriseDeleted(Long id) throws EnterpriseNotFoundException {
        boolean isRemoved = false;

        Long count = enterpriseRepository.countById(id);
        if (count == null || count ==0){
            throw new EnterpriseNotFoundException("No se pudo encontrar ninguna empresa con el Id: " + id);
        }
        else {
            enterpriseRepository.deleteById(id);
            isRemoved=true;
        }
        return isRemoved;
    }

    public void deleteEnterprise(long id) throws EnterpriseNotFoundException {
        Long count = enterpriseRepository.countById(id);
        if (count == null || count ==0){
            throw new EnterpriseNotFoundException("No se pudo encontrar ninguna empresa con el Id: " + id);
        }
        enterpriseRepository.deleteById(id);
    }
}
