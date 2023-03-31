package br.edu.infnet.locadorademotos.model.service;

import br.edu.infnet.locadorademotos.model.domain.Trail;
import br.edu.infnet.locadorademotos.model.domain.Usuario;
import br.edu.infnet.locadorademotos.model.repository.TrailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class TrailService {

	@Autowired
	private TrailRepository trailRepository;

	public Trail incluir(Trail trail) {
		return trailRepository.save(trail);
	}
	public void excluir(Integer id) {
		trailRepository.deleteById(id);
	}
	public Collection<Trail> obterLista(){
		return (Collection<Trail>) trailRepository.findAll();
	}
	public Collection<Trail> obterLista(Usuario usuario){
		return (Collection<Trail>) trailRepository.obterLista(usuario.getId());
	}
	public Trail obterPorId(Integer id) {
		return trailRepository.findById(id).orElse(null);
	}
}