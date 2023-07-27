package com.sinfloo.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.sinfloo.demo.modelo.Persona;

public interface IPersonaService {
	
	public List<Persona> listar();
	public Optional<Persona> listarId(int id);
	public int save (Persona miPersona);
	public void delete (int id);
	
}
