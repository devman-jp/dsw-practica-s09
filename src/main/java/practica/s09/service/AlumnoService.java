package practica.s09.service;

import antlr.collections.List;
import practica.s09.model.Alumno;

public interface AlumnoService {
	void guardar(Alumno alumno);
	void actualizar(Alumno alumno);
	void eliminar(Integer id);
	List<Alumno> listar();
	Alumno obtener(Integer id);

}
