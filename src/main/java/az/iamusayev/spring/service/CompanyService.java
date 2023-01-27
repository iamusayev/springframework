package az.iamusayev.spring.service;

import az.iamusayev.spring.database.entity.Company;
import az.iamusayev.spring.database.repository.CrudRepository;
import az.iamusayev.spring.dto.CompanyReadDto;
import az.iamusayev.spring.listener.entity.AccessType;
import az.iamusayev.spring.listener.entity.EntityEvent;
import java.util.Optional;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final CrudRepository<Integer, Company> companyCrudRepository;
    private final UserService userService;
    private final ApplicationEventPublisher eventPublisher;

    public CompanyService(CrudRepository<Integer, Company> companyCrudRepository, UserService userService, ApplicationEventPublisher eventPublisher) {
        this.companyCrudRepository = companyCrudRepository;
        this.userService = userService;
        this.eventPublisher = eventPublisher;
    }

    public Optional<CompanyReadDto> findById(Integer id) {
        return companyCrudRepository.findById(id)
                .map(entity -> {
                    eventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                    return new CompanyReadDto(id);
                });
    }
}