package com.admin.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.admin.demo.model.Usuario;
import com.admin.demo.repository.UsuarioRepository;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	    String login = authentication.getPrincipal() + "";
	    String senha = authentication.getCredentials() + "";

	    Usuario usuario = usuarioRepository.buscarPorLoginESenha(login, senha);
	    if (usuario == null) {
	        throw new BadCredentialsException("1000");
	    }
	    return new UsernamePasswordAuthenticationToken(login, senha);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}