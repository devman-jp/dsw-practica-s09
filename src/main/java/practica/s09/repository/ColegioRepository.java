package practica.s09.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import practica.s09.model.Colegio;

@Repository
public interface ColegioRepository extends JpaRepository<Colegio, Integer>{

}
