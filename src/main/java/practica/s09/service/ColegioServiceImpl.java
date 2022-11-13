package practica.s09.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practica.s09.model.Colegio;
import practica.s09.repository.ColegioRepository;


@Service
public class ColegioServiceImpl implements ColegioService{
	
	@Autowired
	private ColegioRepository repository;

	@Override
	public void guardar(Colegio colegio) {
		// TODO Auto-generated method stub
		repository.save(colegio);
		
	}

	@Override
	public void actualizar(Colegio colegio) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(colegio);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<Colegio> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Colegio obtener(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
