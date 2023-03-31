package br.edu.infnet.locadorademotos.model.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.edu.infnet.locadorademotos.model.domain.Cadastro;

@Repository
public interface CadastroRepository extends CrudRepository<Cadastro, Integer> {

	@Query("from Cadastro c where c.usuario.id = :userId")
	List<Cadastro> obterLista(Integer userId);
}