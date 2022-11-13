package practica.s09.service;

import java.util.List;


import practica.s09.model.Colegio;

public interface ColegioService {
	
	void guardar(Colegio colegio);
	void actualizar(Colegio colegio);
	void eliminar(Integer id);
	List<Colegio> listar();
	Colegio obtener(Integer id);

}
