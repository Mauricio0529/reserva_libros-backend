package com.reserva_libros.application.config;

import com.reserva_libros.infraestructure.exception.AccessDeniedHandlerException;
import com.reserva_libros.security.JwtAuthFilter;
import com.reserva_libros.security.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Clase que configura lo relacionado a las peticiones HTTP
 */
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final AccessDeniedHandlerException accessDeniedHandlerException;

    private final JwtAuthFilter jwtAuthFilter;

    /**
     * Configura la seguridad de las peticiones HTTP
     * @param http Peticion a configurar
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(withDefaults())
                .exceptionHandling().accessDeniedHandler(accessDeniedHandlerException)
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(requests ->
                        requests
                                .requestMatchers("/auth/**", "/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                                //.requestMatchers(HttpMethod.GET, "/customers").hasAnyRole(Roles.CUSTOMER, Roles.ADMIN)
                                .requestMatchers(HttpMethod.GET, "/usuario/**").hasAnyRole(Roles.CUSTOMER, Roles.ADMIN)
                                .requestMatchers(HttpMethod.DELETE, "/usuario/**").hasRole(Roles.ADMIN)
                                //.requestMatchers(HttpMethod.DELETE, "/customers/**").hasAuthority("ELIMINAR_PRIVILEGE")

                                .requestMatchers(HttpMethod.GET, "/libro/**").hasRole(Roles.CUSTOMER)
                                .requestMatchers(HttpMethod.POST, "/libro/**").hasRole(Roles.ADMIN)

                                //.requestMatchers(HttpMethod.GET, "/professional-careers/**").hasRole(Roles.CUSTOMER)
                                //.requestMatchers(HttpMethod.POST, "/professional-careers/**").hasRole(Roles.ADMIN)

                                //.requestMatchers("/cars").hasAuthority("COMPRAR_PRIVILEGE")
                                //.requestMatchers("/customers").hasRole(Roles.ADMIN)

                                //solo toma el primer filtro, ya no se puede anidar un rol con una autoridad

                                //hasAuthority o hasRole para un solo rol/autoridad
                                //hasAnyAuthority para varios roles
                                .anyRequest().authenticated()
                );

        return http.build();
    }

    /**
     * Configuracion Cors
     * @return
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(CorsConfiguration.ALL));
        configuration.setAllowedMethods(Arrays.asList(CorsConfiguration.ALL));
        configuration.setAllowedHeaders(Arrays.asList(CorsConfiguration.ALL));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}