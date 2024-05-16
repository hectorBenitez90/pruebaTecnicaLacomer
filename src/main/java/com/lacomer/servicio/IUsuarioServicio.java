package com.lacomer.servicio;

import java.util.List;

import com.lacomer.entity.Usuario;

public interface IUsuarioServicio{

	public List<Usuario> obtenerTodo();
	
	public Usuario guardar(Usuario cliente);
	
	public Usuario obtenerPorId(long id);
	
	public void eliminar(long id);
}
