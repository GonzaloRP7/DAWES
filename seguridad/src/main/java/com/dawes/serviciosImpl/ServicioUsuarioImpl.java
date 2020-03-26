package com.dawes.serviciosImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dawes.modelo.UsuarioRolVO;
import com.dawes.modelo.UsuarioVO;
import com.dawes.repository.UserRepository;
import com.dawes.servicios.ServicioUsuario;
 
@Service
public class ServicioUsuarioImpl implements UserDetailsService, ServicioUsuario {
 
    @Autowired
    private UserRepository ur;
 

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
	       UsuarioVO u = ur.findByUsername(userName);
	       
	       if (u == null) {
	            throw new UsernameNotFoundException("Usuario " + userName + " no existe en la base de datos");
	       }

	 


			List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
			if(u.getRoles() != null) {
				for(UsuarioRolVO rol: u.getRoles()) {
					
					GrantedAuthority authority = new SimpleGrantedAuthority(rol.getRol().getRolename());
					grantList.add(authority);
				}
			}
			
			UserDetails userDetails = (UserDetails) new User(u.getUsername(),
					u.getPassword(), grantList);
			
			return userDetails;
	   }
 
  
 
}