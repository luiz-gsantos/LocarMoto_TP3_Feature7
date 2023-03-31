package br.edu.infnet.locadorademotos.model.repository;

import br.edu.infnet.locadorademotos.model.domain.Trail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TrailRepository extends CrudRepository<Trail, Integer> {

	@Query("from Trail t where t.usuario.id = :userId")
	List<Trail> obterLista(Integer userId);
}