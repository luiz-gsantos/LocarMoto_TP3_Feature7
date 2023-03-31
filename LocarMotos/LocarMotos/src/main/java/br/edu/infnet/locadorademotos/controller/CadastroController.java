package br.edu.infnet.locadorademotos.controller;

import br.edu.infnet.locadorademotos.model.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import br.edu.infnet.locadorademotos.model.domain.Cadastro;
import br.edu.infnet.locadorademotos.model.domain.Usuario;

@Controller
public class CadastroController {
	
	@Autowired
	private CadastroService cadastroService;
	private String msg;
	@GetMapping(value = "/cadastro")
	public String telaCadastro() {
		return "produtos/cadastro/cadastro";
	}
	@GetMapping(value = "/listacadastro")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		model.addAttribute("cadastros", cadastroService.obterLista(usuario));
		model.addAttribute("mensagem", msg);
		msg = null;
		return "produtos/lista/listacadastro";
	}
	@PostMapping(value = "/cadastro/incluir")
	public String incluir(Cadastro cadastro, @SessionAttribute("usuario") Usuario usuario) {
		cadastro.setUsuario(usuario);
		cadastroService.incluir(cadastro);
		msg = "A inclusão do cadastro foi realizada com sucesso!";
		return "redirect:/";
	}
		
	@GetMapping(value = "/cadastro/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		cadastroService.excluir(id);
		msg = "A exclusão do cadastro foi realizada com sucesso!";
		return "redirect:/listacadastro";
	}
}