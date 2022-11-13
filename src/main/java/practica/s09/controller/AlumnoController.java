package practica.s09.controller;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import practica.s09.service.AlumnoService;
import practica.s09.model.Alumno;


@RestController
@RequestMapping("/estudiante/v1")
public class AlumnoController {
	
	@Autowired
	private AlumnoService alumnoService;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Alumno>> listar(){
		return new ResponseEntity<List<Alumno>>(alumnoService.listar(), HttpStatus.OK) ;
	}
	
	@RequestMapping(path="/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Alumno alumno ){
		alumnoService.guardar(alumno);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Alumno> obtenerPorId(@PathVariable Integer id){
		
		Alumno alumno = alumnoService.obtener(id);
		
		if( alumno != null) {
			return new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
		}else {
			return new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Alumno alumno){
		
		Alumno alumnoFounded  = alumnoService.obtener(alumno.getIdAlumno());
		
		if( alumnoFounded != null) {
			alumnoService.actualizar(alumno);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void>eliminar(@PathVariable Integer id){
		
		Alumno alumno  = alumnoService.obtener(id);

		if(alumno != null) {
			alumnoService.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	


}
