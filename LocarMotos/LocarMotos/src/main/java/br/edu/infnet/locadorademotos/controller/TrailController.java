package br.edu.infnet.locadorademotos.controller;

import br.edu.infnet.locadorademotos.model.domain.Trail;
import br.edu.infnet.locadorademotos.model.domain.Usuario;
import br.edu.infnet.locadorademotos.model.service.TrailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class TrailController {
	
	@Autowired
	private TrailService trailService;
	private String msg;
	@GetMapping(value = "/trail")
	public String telaCadastro() {
		return "produtos/cadastro/trail";
	}
	@GetMapping(value = "listatrail")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		model.addAttribute("trails", trailService.obterLista(usuario));
		model.addAttribute("mensagem", msg);
		msg = null;
		return "produtos/lista/listatrail";
	}
	@PostMapping(value = "/trail/incluir")
	public String incluir(Trail trail, @SessionAttribute("usuario") Usuario usuario) {
		trail.setUsuario(usuario);
		trailService.incluir(trail);
		msg = "A inclusão da trail foi realizada com sucesso!";
		return "redirect:/";
	}
	@GetMapping(value = "/trail/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		Trail trail = trailService.obterPorId(id);
		trailService.excluir(id);
		msg = "A exclusão da trial foi realizada com sucesso!";
		return "redirect:/";
	}
}