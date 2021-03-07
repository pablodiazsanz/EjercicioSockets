package com.psp.hashMVC.modelo.negocio;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psp.hashMVC.modelo.entidad.Usuario;
import com.psp.hashMVC.modelo.persistencia.DaoUsuario;

@Service
public class GestorUsuario {

	@Autowired
	private DaoUsuario daoUsuario;
	
	public boolean validar(Usuario usuario) {
		Optional<Usuario> userBBDD = 
				daoUsuario.findByUsername(usuario.getUsername());
		
		if(!userBBDD.isPresent()) {
			return false;
		}
		
		if(usuario.getPassword().equals(userBBDD.get().getPassword())){
			return true;
		}else {
			return false;
		}
	}
	
	public String hashear(String password) throws NoSuchAlgorithmException {
		
		byte[] nuevoHash = password.getBytes();
		
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		
		md.update(nuevoHash);
		
		byte[] passwordHasheadaBytes = md.digest();
		
		String passwordHasheada = new String(passwordHasheadaBytes);
		
		return passwordHasheada;
	}

	public boolean registrarUsuario(Usuario usuario) {
		daoUsuario.save(usuario);
		return true;
	}
}
