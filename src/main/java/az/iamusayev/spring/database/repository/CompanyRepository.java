package az.iamusayev.spring.database.repository;

import az.iamusayev.spring.database.entity.Company;
import java.util.Optional;

public interface CompanyRepository extends org.springframework.data.repository.Repository<Company, Integer> {

    Optional<Company> findById(Integer id);

    void delete(Company entity);
}