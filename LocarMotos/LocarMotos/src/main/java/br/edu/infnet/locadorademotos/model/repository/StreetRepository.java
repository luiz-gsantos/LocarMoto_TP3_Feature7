package br.edu.infnet.locadorademotos.model.repository;

import br.edu.infnet.locadorademotos.model.domain.Street;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StreetRepository extends CrudRepository<Street, Integer> {

	@Query("from Street s where s.usuario.id = :userId")
	List<Street> obterLista(Integer userId);
}