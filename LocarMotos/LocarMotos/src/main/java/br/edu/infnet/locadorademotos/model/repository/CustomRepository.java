package br.edu.infnet.locadorademotos.model.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.edu.infnet.locadorademotos.model.domain.Custom;

@Repository
public interface CustomRepository extends CrudRepository<Custom, Integer> {

	@Query("from Custom c where c.usuario.id = :userId")
	List<Custom> obterLista(Integer userId);
}