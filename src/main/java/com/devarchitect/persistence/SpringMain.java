package com.devarchitect.persistence;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.devarchitect.persistence.model.Usuario;
import com.devarchitect.persistence.repositorio.UsuarioRepositorio;

public class SpringMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringMain.class.getPackage().getName()
				);
		
		UsuarioRepositorio repo = applicationContext.getBean(UsuarioRepositorio.class);
		//repo.addUsuario(new Usuario(3,"Carmen","Quispe",35));
//		repo.editUsuario(new Usuario(3,"Carmen","Quisperson",35),3);
//		repo.deleteUsuario(3);
		repo.findAll().forEach( obj -> System.out.println("Metodo listar: " + obj));
		System.out.println("Buscar por codigo" + repo.find(1));
		
		applicationContext.close();
		
		System.out.println("Fin!");
		
	}

}
