package az.iamusayev.spring.service;

import az.iamusayev.spring.database.entity.Company;
import az.iamusayev.spring.database.repository.CrudRepository;
import az.iamusayev.spring.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;

}