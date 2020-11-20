package br.com.abr3dev.MindCare.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.abr3dev.MindCare.models.Usuario;
import br.com.abr3dev.MindCare.repository.UsuarioRepository;
import br.com.abr3dev.MindCare.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public Optional<Usuario> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Usuario register(Usuario usuario) {
		return repository.save(usuario);
	}

}
