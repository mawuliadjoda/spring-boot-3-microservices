package com.adjoda.photoapp.api.users.security;

import com.adjoda.photoapp.api.users.entity.AuthenticationFilter;
import com.adjoda.photoapp.api.users.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity

@RequiredArgsConstructor
public class WebSecurity {

    private final UsersService usersService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final Environment environment;


    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        // Configure AuthenticationManagerBuilder
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);

        authenticationManagerBuilder.userDetailsService(usersService).passwordEncoder(bCryptPasswordEncoder);

        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

        // Create AuthenticationFilter
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManager, usersService, environment);
        authenticationFilter.setFilterProcessesUrl(environment.getProperty("login.url.path"));


        http.csrf(AbstractHttpConfigurer::disable);

        http.authorizeHttpRequests(request -> request.requestMatchers(HttpMethod.POST, "/api/v1/users")
                        .permitAll()
                        //.access(new WebExpressionAuthorizationManager("hasIpAddress('"+environment.getProperty("gateway.ip")+"')"))

                        .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll())

                .addFilter(authenticationFilter)
                .authenticationManager(authenticationManager)
                .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        http.headers(header->{header.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable);});

        return http.build();
    }
}
