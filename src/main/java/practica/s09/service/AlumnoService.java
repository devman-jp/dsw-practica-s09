package practica.s09.service;


import java.util.List;

import practica.s09.model.Alumno;

public interface AlumnoService {
	void guardar(Alumno alumno);
	void actualizar(Alumno alumno);
	void eliminar(Integer id);
	java.util.List<Alumno> listar();
	Alumno obtener(Integer id);

}
