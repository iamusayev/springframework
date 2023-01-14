package az.iamusayev.spring.database.service;

import az.iamusayev.spring.database.repository.CompanyRepository;
import az.iamusayev.spring.database.repository.UserRepository;


public class UserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private CompanyService companyService;

    public UserService(UserRepository userRepository, CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }

    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }
}