package com.lacomer.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacomer.entity.Usuario;
import com.lacomer.repository.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements IUsuarioServicio{
	
	@Autowired
	UsuarioRepositorio clienterepositorio;

	@Override
	public List<Usuario> obtenerTodo() {
		return clienterepositorio.findAll();
	}

	@Override
	public Usuario guardar(Usuario cliente) {
		return clienterepositorio.save(cliente);
	}

	@Override
	public Usuario obtenerPorId(long id) {
		return clienterepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminar(long id) {
		clienterepositorio.deleteById(id);
		
	}

}
