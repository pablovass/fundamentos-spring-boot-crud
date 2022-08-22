package com.pablovass.fundamentos.configuration;

import com.pablovass.fundamentos.caseuse.GetUser;
import com.pablovass.fundamentos.caseuse.GetUserImplement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

    @Bean
    GetUser getUser(UserService userService){
        return new GetUserImplement(userService);
    }

}
