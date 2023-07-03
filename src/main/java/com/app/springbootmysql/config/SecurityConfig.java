package com.app.springbootmysql.config;

import com.app.springbootmysql.security.JwtAuthenticationEntryPoint;
import com.app.springbootmysql.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    @Autowired
    private JwtAuthenticationEntryPoint point;
    @Autowired
    private JwtAuthenticationFilter filter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        http
                .csrf().disable()                                //with admin roles this code we can use
                .authorizeRequests()
                .antMatchers("/auth/login").permitAll()          // Permit all users to access the login API
                .antMatchers("/topics").hasRole("ADMIN")   // Specify the ADMIN role for admin-api
                .antMatchers("/update/**").hasRole("ADMIN")  // Specify the ADMIN role for admin-api
                .antMatchers("/topics/**").hasRole("USER")   // Specify the USER role for user-api
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(point)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

        return http.build();




// Without ADMIN roles this code we can use
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/topics").authenticated()
//                .antMatchers("/auth/login").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .exceptionHandling().authenticationEntryPoint(point)
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
    }
}




























//        http.csrf(csrf->csrf.disable())
//                .cors(cors->cors.disable())
//                .authorizeHttpRequests(
//                        auth->
//                              auth.requestMatchers("/topics/**").authenticated()
//                               .requestMatchers("/auth/login").permitAll()
//                                      .anyRequest().authenticated())
//                .exceptionHandling(ex->ex.authenticationEntryPoint(point))
//                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                ;
//
//        http.addFilterBefore(filter,UsernamePasswordAuthenticationFilter.class);
       // return http.build();


//        http.csrf(csrf -> csrf.disable())
//                .authorizeRequests().
//                requestMatchers("/test").authenticated().requestMatchers("/auth/login").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and().exceptionHandling(ex -> ex.authenticationEntryPoint(point))
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
//        return http.build();
