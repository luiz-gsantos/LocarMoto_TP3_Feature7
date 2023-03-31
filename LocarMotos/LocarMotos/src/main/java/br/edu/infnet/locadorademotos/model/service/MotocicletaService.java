package br.edu.infnet.locadorademotos.model.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.infnet.locadorademotos.model.domain.Motocicleta;
import br.edu.infnet.locadorademotos.model.domain.Usuario;
import br.edu.infnet.locadorademotos.model.repository.MotocicletaRepository;

@Service
public class MotocicletaService {

	@Autowired
	private MotocicletaRepository motocicletaRepository;
	public void excluir(Integer id) {
		motocicletaRepository.deleteById(id);
	}
	public Collection<Motocicleta> obterLista(){
		return (Collection<Motocicleta>) motocicletaRepository.findAll();
	}
	public Collection<Motocicleta> obterLista(Usuario usuario){
		return (Collection<Motocicleta>) motocicletaRepository.obterLista(usuario.getId());
	}
	public Motocicleta obterPorId(Integer id) {
		return motocicletaRepository.findById(id).orElse(null);
	}
}