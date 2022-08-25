package com.FuzionSW.UdeA.ProyectoCiclo3.Service;

import com.FuzionSW.UdeA.ProyectoCiclo3.Entity.Enterprise;
import com.FuzionSW.UdeA.ProyectoCiclo3.Repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnterpriseService {
    @Autowired //Conectamos esta clase con el repository de Empresa
    EnterpriseRepository enterpriseRepository; //Creamos un objeto tipo EmpresaRepository para poder usar los metodos que dicha clase hereda

    //Metodo que retornará la lista de empresas usando metodos heredados del jpaRepository
    public List<Enterprise> getAllEnterprises(){
        List<Enterprise> enterpriseList = new ArrayList<>();
        enterpriseRepository.findAll().forEach(enterprise -> enterpriseList.add(enterprise));  //Recorremos el iterable que regresa el metodo findAll del Jpa y lo guardamos en la lista creada
        return enterpriseList;
    }

    //Metodo que me trae un objeto de tipo Empresa cuando cuento con el id de la misma
    public Enterprise getEnterpriseById(long id){
        return enterpriseRepository.findById(id).get();
    }

    //Metodo para guardar o actualizar objetos de tipo Empresa
    public boolean saveOrUpdateEnterprise(Enterprise empresa){
        Enterprise enterprise = enterpriseRepository.save(empresa);
        if (enterpriseRepository.findById(enterprise.getId())!=null){
            return true;
        }
        return false;
    }

    //Metodo para eliminar empresas registradas teniendo el id
    public boolean deleteEnterprise(long id){
        enterpriseRepository.deleteById(id);
        if (getEnterpriseById(id)!=null){
            return false;
        }
        return true;
    }
}
