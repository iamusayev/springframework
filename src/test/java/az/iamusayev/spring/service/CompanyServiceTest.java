package az.iamusayev.spring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import az.iamusayev.spring.database.entity.Company;
import az.iamusayev.spring.database.repository.CrudRepository;
import az.iamusayev.spring.dto.CompanyReadDto;
import az.iamusayev.spring.listener.entity.EntityEvent;
import java.util.Collections;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;


@TestInstance(value = Lifecycle.PER_CLASS)
@ExtendWith({MockitoExtension.class, az.iamusayev.spring.service.Test.class})
class CompanyServiceTest {

    private static final Integer COMPANY_ID = 1;

    @BeforeAll
    void hey() {
        System.out.println("hey everyone");
    }

    @Mock
    private CrudRepository<Integer, Company> companyCrudRepository;
    @Mock
    private UserService userService;
    @Mock
    private ApplicationEventPublisher eventPublisher;
    @InjectMocks
    private CompanyService companyService;

    @Test
    void findById() {
        doReturn(Optional.of(new Company(COMPANY_ID, null, Collections.emptyMap())))
                .when(companyCrudRepository).findById(COMPANY_ID);
        Optional<CompanyReadDto> actualResult = companyService.findById(COMPANY_ID);

        assertTrue(actualResult.isPresent());

        var expectedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));

        verify(eventPublisher).publishEvent(any(EntityEvent.class));
        verifyNoMoreInteractions(eventPublisher, userService);
    }


}