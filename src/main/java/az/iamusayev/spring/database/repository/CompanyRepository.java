package az.iamusayev.spring.database.repository;

import az.iamusayev.spring.database.entity.Companies;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepository extends JpaRepository<Companies, Integer> {

    @Query("select c from Companies  c where c.name =:name")
    List<Companies> getAllCompany(String name);

}