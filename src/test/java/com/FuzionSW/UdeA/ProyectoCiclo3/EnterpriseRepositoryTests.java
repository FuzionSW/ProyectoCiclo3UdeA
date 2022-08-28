package com.FuzionSW.UdeA.ProyectoCiclo3;

import com.FuzionSW.UdeA.ProyectoCiclo3.entities.Enterprise;
import com.FuzionSW.UdeA.ProyectoCiclo3.repositories.EnterpriseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class EnterpriseRepositoryTests {
    @Autowired private EnterpriseRepository enterpriseRepository;

    @Test
    public void testAddNew() {
        Enterprise enterprise = new Enterprise();
        enterprise.setName("Artelak");
        enterprise.setDocument("81238456-9");
        enterprise.setPhone("6017894567");
        enterprise.setAddress("Calle 13");

        Enterprise savedEnterprise = enterpriseRepository.save(enterprise);
        assertThat(savedEnterprise).isNotNull();
        assertThat(savedEnterprise.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll() {
        Iterable<Enterprise> enterprises = enterpriseRepository.findAll();
        assertThat(enterprises).hasSizeGreaterThan(0);

        for (Enterprise enterprise : enterprises) {
            System.out.println(enterprise);
        }
    }

    @Test
    public void testUpdate() {
        long enterpriseId = 1;
        Optional<Enterprise> optionalEnterprise = enterpriseRepository.findById(enterpriseId);
        Enterprise enterprise = optionalEnterprise.get();
        enterprise.setName("La 14");
        enterpriseRepository.save(enterprise);

        Enterprise updatedEnterprise = enterpriseRepository.findById(enterpriseId).get();
        assertThat(updatedEnterprise.getName()).isEqualTo("La 14");
    }

    @Test
    public void testGet(){
        long enterpriseId = 1;
        Optional<Enterprise> optionalEnterprise = enterpriseRepository.findById(enterpriseId);

        assertThat(optionalEnterprise).isPresent();
        System.out.println(optionalEnterprise.get());
    }

    @Test
    public void testDelete(){
        long enterpriseId = 1;
        enterpriseRepository.deleteById(enterpriseId);

        Optional<Enterprise> optionalEnterprise = enterpriseRepository.findById(enterpriseId);
        assertThat(optionalEnterprise).isNotPresent();
    }
}
