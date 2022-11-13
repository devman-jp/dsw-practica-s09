package practica.s09.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import practica.s09.model.Colegio;
import practica.s09.service.ColegioService;

@RestController
@RequestMapping("/colegio/v1")
public class ColegioController {
	
	@Autowired
	private ColegioService service;

	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Colegio>> listar(){
		return new ResponseEntity<List<Colegio>>(service.listar(), HttpStatus.OK) ;
	}
	
	@RequestMapping(path="/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Colegio colegio ){
		service.guardar(colegio);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Colegio> obtenerPorId(@PathVariable Integer id){
		
		Colegio colegio = service.obtener(id);
		
		if( colegio != null) {
			return new ResponseEntity<Colegio>(colegio, HttpStatus.OK);
		}else {
			return new ResponseEntity<Colegio>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Colegio colegio){
		
		Colegio c = service.obtener(colegio.getIdcolegio());
		
		if( c != null) {
			service.actualizar(colegio);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void>eliminar(@PathVariable Integer id){
		
		Colegio colegio = service.obtener(id);

		if(colegio != null) {
			service.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
}
