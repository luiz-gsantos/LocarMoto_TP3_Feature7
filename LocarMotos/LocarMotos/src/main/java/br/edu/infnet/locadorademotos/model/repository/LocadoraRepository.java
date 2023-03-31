package br.edu.infnet.locadorademotos.model.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.edu.infnet.locadorademotos.model.domain.Locadora;

@Repository
public interface LocadoraRepository extends CrudRepository<Locadora, Integer> {

	@Query("from Locadora l where l.usuario.id = :userId")
	List<Locadora> obterLista(Integer userId);
}