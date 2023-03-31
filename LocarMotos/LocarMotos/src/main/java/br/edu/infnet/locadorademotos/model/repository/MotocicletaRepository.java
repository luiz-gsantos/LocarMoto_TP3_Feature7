package br.edu.infnet.locadorademotos.model.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.edu.infnet.locadorademotos.model.domain.Motocicleta;

@Repository
public interface MotocicletaRepository extends CrudRepository<Motocicleta, Integer> {

	@Query("from Motocicleta m where m.usuario.id = :userId")
	List<Motocicleta> obterLista(Integer userId);
}