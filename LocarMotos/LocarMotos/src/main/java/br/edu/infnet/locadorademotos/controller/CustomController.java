package br.edu.infnet.locadorademotos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import br.edu.infnet.locadorademotos.model.domain.Custom;
import br.edu.infnet.locadorademotos.model.domain.Usuario;
import br.edu.infnet.locadorademotos.model.service.CustomService;

@Controller
public class CustomController {
	
	@Autowired
	private CustomService customService;
	private String msg;
	@GetMapping(value = "/custom")
	public String telaCadastro() {
		return "produtos/cadastro/custom";
	}
	@GetMapping(value = "listacustom")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		model.addAttribute("customs", customService.obterLista(usuario));
		model.addAttribute("mensagem", msg);
		msg = null;
		return "produtos/lista/listacustom";
	}
	@PostMapping(value = "/custom/incluir")
	public String incluir(Custom custom, @SessionAttribute("usuario") Usuario usuario) {
		custom.setUsuario(usuario);
		customService.incluir(custom);
		msg = "A inclusão da custom foi realizada com sucesso!";
		return "redirect:/";
	}
	@GetMapping(value = "/custom/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		Custom custom = customService.obterPorId(id);
		customService.excluir(id);
		msg = "A exclusão da custom foi realizada com sucesso!";
		return "redirect:/";
	}
}