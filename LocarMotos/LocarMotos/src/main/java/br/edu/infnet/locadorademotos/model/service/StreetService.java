package br.edu.infnet.locadorademotos.model.service;

import br.edu.infnet.locadorademotos.model.domain.Street;
import br.edu.infnet.locadorademotos.model.domain.Usuario;
import br.edu.infnet.locadorademotos.model.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class StreetService {

	@Autowired
	private StreetRepository streetRepository;

	public Street incluir(Street street) {
		return streetRepository.save(street);
	}
	public void excluir(Integer id) {
		streetRepository.deleteById(id);
	}
	public Collection<Street> obterLista(){
		return (Collection<Street>) streetRepository.findAll();
	}
	public Collection<Street> obterLista(Usuario usuario){
		return (Collection<Street>) streetRepository.obterLista(usuario.getId());
	}
	public Street obterPorId(Integer id) {
		return streetRepository.findById(id).orElse(null);
	}
}