package az.iamusayev.spring.service;

import az.iamusayev.spring.database.entity.Company;
import az.iamusayev.spring.database.repository.CrudRepository;
import az.iamusayev.spring.database.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;

    public UserService(UserRepository userRepository,
            CrudRepository<Integer, Company> companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }
}