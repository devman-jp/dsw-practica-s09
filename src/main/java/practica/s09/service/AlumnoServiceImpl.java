package practica.s09.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practica.s09.model.Alumno;
import practica.s09.repository.AlumnoRepository;
@Service
public class AlumnoServiceImpl implements AlumnoService{
	@Autowired
	private AlumnoRepository alumnoRepository;
	@Override
	public void guardar(Alumno alumno) {
		// TODO Auto-generated method stub
		
		alumnoRepository.save(alumno);

	}

	@Override
	public void actualizar(Alumno alumno) {
		// TODO Auto-generated method stub
		alumnoRepository.saveAndFlush(alumno);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		alumnoRepository.deleteById(id);

	}

	@Override
	public List<Alumno> listar() {
		// TODO Auto-generated method stub
		return alumnoRepository.findAll();
	}

	@Override
	public Alumno obtener(Integer id) {
		// TODO Auto-generated method stub
		return alumnoRepository.findById(id).orElse(null);
	}
	
	
}
