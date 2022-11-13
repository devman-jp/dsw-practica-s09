package practica.s09.security;

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

import practica.s09.model.Usuario;
import practica.s09.repository.UsuarioRepository;

@Service
public class UserDetailService implements UserDetailsService{

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario findUsuario = repository.findByUsuario(username);
		
		if (findUsuario != null) {
			List<GrantedAuthority> listGranted = new ArrayList<>();
			GrantedAuthority granted = new SimpleGrantedAuthority(findUsuario.getRol());
			listGranted.add(granted);
			
			return new User(
					findUsuario.getUsuario(),
					findUsuario.getContrasenia(),
					listGranted
					);
		}else {
			throw new UsernameNotFoundException("Usuario no existe " + username);
		}
	}

}
