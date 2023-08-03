package com.practical.practical_bulletin_board_project.config;

import com.practical.practical_bulletin_board_project.domain.UserAccount;
import com.practical.practical_bulletin_board_project.repository.UserAccountRepository;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@Import(SecurityConfig.class)
public class TestSecurityConfig {
    @MockBean private UserAccountRepository userAccountRepository;

    @BeforeTestMethod
    public void securitySetup(){
        given(userAccountRepository.findById(anyString())).willReturn(Optional.of(UserAccount.of(

           "unoTest",
           "pw",
           "uno-test@email.com",
           "uno-test",
           "test memo"
        )));
    }
}
