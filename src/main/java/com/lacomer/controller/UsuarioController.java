package com.lacomer.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lacomer.entity.Usuario;
import com.lacomer.servicio.UsuarioServicioImpl;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
	
	@Autowired
	UsuarioServicioImpl UsuarioServicio;
	
	
	@GetMapping("/usuarios")
	public List<Usuario> obtenerUsuarios(){
		return UsuarioServicio.obtenerTodo();
	}
	
	
	@PostMapping("/guardar")
	public ResponseEntity<Usuario> guardarCliente(@RequestBody Usuario usuario){
		Usuario nuevo_usuario = UsuarioServicio.guardar(usuario);
		return new ResponseEntity<>(nuevo_usuario, HttpStatus.CREATED);
	}
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> obtenerUsuarioId(@PathVariable long id){
		Usuario usuarioPorId = UsuarioServicio.obtenerPorId(id);
		return ResponseEntity.ok(usuarioPorId);
	}
	
	@PutMapping("/usuario/{id}")
	public ResponseEntity<Usuario> actualizarUsuario(@PathVariable long id, @RequestBody Usuario usuario){
		Usuario usuarioPorId = UsuarioServicio.obtenerPorId(id);
		usuarioPorId.setNombre(usuario.getNombre());
		usuarioPorId.setApellidoPaterno(usuario.getApellidoPaterno());
		usuarioPorId.setApellidoMaterno(usuario.getApellidoMaterno());
		usuarioPorId.setEmail(usuario.getEmail());
		
		Usuario cliente_actualizado = UsuarioServicio.guardar(usuarioPorId);
		return new ResponseEntity<>(cliente_actualizado, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<HashMap<String,Boolean>> eliminarCliente(@PathVariable long id){
		this.UsuarioServicio.eliminar(id);
		
		HashMap<String, Boolean> estadoUsuarioEliminado = new HashMap<>();
		estadoUsuarioEliminado.put("eliminado", true);
		return ResponseEntity.ok(estadoUsuarioEliminado);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
