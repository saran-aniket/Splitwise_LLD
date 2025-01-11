package com.lldbackend.splitwise_05012025.configurations;

import com.lldbackend.splitwise_05012025.commands.CommandExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public CommandExecutor commandExecutor() {
//        return new CommandExecutor();
//    }
}
