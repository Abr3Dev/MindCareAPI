package br.com.abr3dev.MindCare.service;

import java.util.Optional;

import br.com.abr3dev.MindCare.models.Usuario;

public interface UsuarioService {
	
	Usuario register (Usuario usuario);
	
	Optional<Usuario> findById(Long id);
	
	void deleteById (Long id);
}
