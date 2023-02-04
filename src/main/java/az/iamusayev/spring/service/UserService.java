package az.iamusayev.spring.service;

import az.iamusayev.spring.database.repository.CompanyRepository;
import az.iamusayev.spring.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

}