package com.devarchitect.persistence.repositorio;

import java.util.List;

import com.devarchitect.persistence.model.Usuario;

public interface UsuarioRepositorio {

	 public void addUsuario(Usuario person);
	 
     public void editUsuario(Usuario person, int personId);
 
     public void deleteUsuario(int personId);
 
     public Usuario find(int personId);
 
     public List <Usuario> findAll();
}
