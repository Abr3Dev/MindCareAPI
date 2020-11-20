package br.com.abr3dev.MindCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.abr3dev.MindCare.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
