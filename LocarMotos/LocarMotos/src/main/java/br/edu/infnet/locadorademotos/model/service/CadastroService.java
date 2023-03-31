package br.edu.infnet.locadorademotos.model.service;

import java.util.Collection;
import br.edu.infnet.locadorademotos.model.domain.Cadastro;
import br.edu.infnet.locadorademotos.model.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.infnet.locadorademotos.model.domain.Usuario;


@Service
public class CadastroService {

	@Autowired
	private CadastroRepository cadastroRepository;
	public Cadastro incluir(Cadastro cadastro) {
		return cadastroRepository.save(cadastro);
	}
	
	public void excluir(Integer id) {
		cadastroRepository.deleteById(id);
	}

	public Collection<Cadastro> obterLista(){
		return (Collection<Cadastro>) cadastroRepository.findAll();
	}

	public Collection<Cadastro> obterLista(Usuario usuario){
		return (Collection<Cadastro>) cadastroRepository.obterLista(usuario.getId());
	}
	public Cadastro obterPorId(Integer id) {
		return cadastroRepository.findById(id).orElse(null);
	}
}