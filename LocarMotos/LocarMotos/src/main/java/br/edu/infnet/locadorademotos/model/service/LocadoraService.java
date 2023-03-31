package br.edu.infnet.locadorademotos.model.service;

import java.util.Collection;
import br.edu.infnet.locadorademotos.model.domain.Locadora;
import br.edu.infnet.locadorademotos.model.repository.LocadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.infnet.locadorademotos.model.domain.Usuario;

@Service
public class LocadoraService {
	
	@Autowired
	private LocadoraRepository locadoraRepository;
	public Locadora incluir(Locadora locadora) {
		return locadoraRepository.save(locadora);
	}
	public void excluir(Integer key) {
		locadoraRepository.deleteById(key);
	}
	public Collection<Locadora> obterLista(){
		return (Collection<Locadora>) locadoraRepository.findAll();
	}
	public Collection<Locadora> obterLista(Usuario usuario){
		return locadoraRepository.obterLista(usuario.getId());
	}
}