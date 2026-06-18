package com.project.api.config.security;

//import com.project.api.config.filters.JwtFilter;
import com.project.api.config.filters.JwtFilter;
import com.project.api.repositories.UserRepository;
import com.project.api.utils.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Autowired
    private CustomUserDetailService customUserDetailService;

    Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Bean
    @Order(1)
    public SecurityFilterChain filterChain(HttpSecurity http , LogoutHandler logoutHandler) throws Exception {
        final JwtFilter jwtFilter = new JwtFilter();

        return http.securityMatcher("/api/**")
                .csrf(AbstractHttpConfigurer::disable)
                .cors((corsSource) -> corsSource.configurationSource( corsConfigurationSource() ))
                .authorizeHttpRequests((authorizeHttpRequests) ->
                        authorizeHttpRequests.requestMatchers("/api/auth", "/api/user/signup")
                        .permitAll().anyRequest().authenticated()
                )
                .logout( logout ->
                        logout.logoutUrl("/api/user/logout").deleteCookies("authToken")
                        .logoutSuccessHandler( logoutHandler )
                )
                .sessionManagement( (session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authProvider())
                .addFilterBefore(jwtFilter , UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain adminFilterChain(HttpSecurity http) throws Exception {
        http
                .authenticationProvider(authProvider())
                .authorizeHttpRequests((authorizeHttpRequests) ->
                    authorizeHttpRequests
                            .requestMatchers(HttpMethod.GET, "/admin/login", "/signup", "/ajax/**",
                                    "/signup/**", "/css/**", "/js/**", "/vendors/**", "/assets/**", "/images/**", "/uploads/**").permitAll()
                            .requestMatchers(HttpMethod.POST, "/processLogin", "/signup/**").permitAll()
                            .anyRequest()
                            .authenticated()

                )
                .formLogin( (formLogin) ->
                        formLogin
                                .loginPage("/admin/login")
                                .loginProcessingUrl("/processLogin")
                                .defaultSuccessUrl("/admin/dashboard", true)
                                .failureUrl("/admin/login?failed")
                                .permitAll()
                ).logout( (logout) ->
                        logout
                                .deleteCookies("JSESSIONID")
                                .invalidateHttpSession(true)
                                .logoutUrl("/admin/processLogout")
                                .logoutSuccessUrl("/admin/login")
                                .permitAll()
                );

        return http.build();
    }

    @Bean
    public AuthenticationProvider authProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(customUserDetailService);
        provider.setPasswordEncoder(passwordEncoder());

        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(List.of("http://localhost:3000"));
        corsConfig.setAllowedMethods(List.of("GET" , "POST" , "PUT" , "DELETE" , "OPTIONS"));
        corsConfig.setAllowedHeaders(List.of("*"));
        corsConfig.setAllowCredentials(Boolean.TRUE);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);
        logger.info("CorsConfig data : {} ", source.toString());
        return source;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
