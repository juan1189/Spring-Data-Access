package com.devarchitect.persistence.repositorioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.devarchitect.persistence.model.Usuario;
import com.devarchitect.persistence.repositorio.UsuarioRepositorio;

@Repository
@SuppressWarnings("unchecked")
public class UsuarioRepositorioImpl implements UsuarioRepositorio{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addUsuario(Usuario person) {
		 jdbcTemplate.update("INSERT INTO tbl_usuario (person_id, first_name, Last_name, age) VALUES (?, ?, ?, ?)",
            person.getPersonId(), person.getFirstName(), person.getLastName(), person.getAge());
        System.out.println("Usuario insertado!!");
	}

	public void editUsuario(Usuario person, int personId) {
	     jdbcTemplate.update("UPDATE tbl_usuario SET first_name = ? , last_name = ? , age = ? WHERE person_id = ? ",
	             person.getFirstName(), person.getLastName(), person.getAge(), personId);
	         System.out.println("Usuario actualizado!!");
		
	}

	public void deleteUsuario(int personId) {
		jdbcTemplate.update("DELETE from tbl_usuario WHERE person_id = ? ", personId);
		System.out.println("Usuario Eliminado!!");
	}

	public Usuario find(int personId) {			
//			Usuario person = (Usuario) jdbcTemplate.queryForObject("SELECT * FROM tbl_usuario where person_id = ? ",
//	            new Object[] { personId }, new BeanPropertyRowMapper<Usuario>(Usuario.class));
//			return person;
	 
			return jdbcTemplate.queryForObject("SELECT * FROM tbl_usuario where person_id = ? ",
		            new Object[] { personId }, 
		        	(rs,rowNum) -> new Usuario(rs.getInt("person_id"),
							rs.getString("first_name"),
							rs.getString("Last_name"),
							rs.getInt("age")));
			
	}

	public List<Usuario> findAll() {		
//		List <Usuario> persons = jdbcTemplate.query("SELECT * FROM tbl_usuario", new BeanPropertyRowMapper<Usuario>(Usuario.class));
//		return persons;
		
		return jdbcTemplate.query("select * from tbl_usuario", 
				(rs,rowNum) -> new Usuario(rs.getInt("person_id"),
											rs.getString("first_name"),
											rs.getString("Last_name"),
											rs.getInt("age")));
		
	}

	
}
