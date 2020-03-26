package com.dawes.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class Seguridad extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		// Páginas que no necesitan ningun rol
        http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();
 
        // Para acceder a /registrado tienes que usuario o administrador
        http.authorizeRequests().antMatchers("/registrado").access("hasAnyRole('USER', 'ADMIN')");
 
        // Para acceder a /admin tienes que administrador
        http.authorizeRequests().antMatchers("/admin").access("hasRole('ADMIN')");
 
        // Pagina a la que te diriges si te logeas con un usuario existente pero que tiene los permisos necesareos
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
 
        // Configuracion de la página de login a donde se te redirige cuando intentas acceder a una pagina restringida sin loguearte
        http.authorizeRequests().and().formLogin()//
                .loginPage("/login")//
                .failureUrl("/login?error=true");
              
                

		
	}
	
	// codifica y decodifica las contraseñas
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
    
    
}
