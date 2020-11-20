package br.com.abr3dev.MindCare.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.abr3dev.MindCare.dtos.UsuarioDto;
import br.com.abr3dev.MindCare.models.Usuario;
import br.com.abr3dev.MindCare.response.Response;
import br.com.abr3dev.MindCare.service.UsuarioService;

@RestController
@RequestMapping("api/mindcare")
@CrossOrigin(origins = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/register")
	public ResponseEntity<Response<UsuarioDto>> register(@Valid @RequestBody UsuarioDto usuarioDto, 
			BindingResult result) {
		Response<UsuarioDto> response = new Response<UsuarioDto>();
		
		validarDadosExistentes(usuarioDto, result); 
		Usuario usuario = this.converterDtoParaUsuario(usuarioDto, result); 
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		usuarioService.register(usuario); 
		
		response.setData(this.converterUsuarioDto(usuario));
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/user/{id}")
	public ResponseEntity<Response<UsuarioDto>> findById (@PathVariable(value = "id") Long id) {
		Response<UsuarioDto> response = new Response<UsuarioDto>();
		Optional<Usuario> usuario = usuarioService.findById(id); 
		
		if(!usuario.isPresent()) {
			response.getErrors().add("Usuário não encontrado");
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(this.converterUsuarioDto(usuario.get())); 
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response<String>> delete(@PathVariable("id") Long id) {
		Response<String> response = new Response<String>();
		Optional<Usuario> usuario = usuarioService.findById(id);
		
		if(!usuario.isPresent()) {
			response.getErrors().add("Erro ao remover usuário. Usuário não encontrado");
			return ResponseEntity.badRequest().body(response);
		}
		
		usuarioService.deleteById(id);
		response.setData("Usuário removido com sucesso");
		return ResponseEntity.ok(response);
	}
	
	private void validarDadosExistentes(UsuarioDto usuarioDto, BindingResult result) {
		
		this.usuarioService.findById(usuarioDto.getId())
		.ifPresent(user -> result.addError(new ObjectError("user", "Usuario já cadastrado.")));
		
	}
	
	private Usuario converterDtoParaUsuario(UsuarioDto usuarioDto, BindingResult result) {
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioDto.getNome());
		usuario.setIdade(usuarioDto.getIdade());
		usuario.setStatus(usuarioDto.getStatus()); 
		usuario.setDt_criacao(usuarioDto.getDt_criacao()); 
		usuario.setDt_modificação(usuarioDto.getDt_modificação()); 
		usuario.setDt_exclusao(usuarioDto.getDt_exclusao());
		
		return usuario;
	}
	
	private UsuarioDto converterUsuarioDto(Usuario usuario) {
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setId(usuario.getId());
		usuarioDto.setNome(usuario.getNome());
		usuarioDto.setIdade(usuario.getIdade());
		usuarioDto.setStatus(usuario.getStatus());
		usuarioDto.setDt_criacao(usuario.getDt_criacao()); 
		usuarioDto.setDt_modificação(usuario.getDt_modificação()); 
		usuarioDto.setDt_exclusao(usuario.getDt_exclusao());
		
		return usuarioDto;
	}
}
