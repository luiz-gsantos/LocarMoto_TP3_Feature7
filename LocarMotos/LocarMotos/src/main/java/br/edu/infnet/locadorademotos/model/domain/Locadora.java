package br.edu.infnet.locadorademotos.model.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import br.edu.infnet.locadorademotos.model.exceptions.CampoInvalidoException;

@Entity
@Table(name = "TLocadora")
public class Locadora {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne(cascade = CascadeType.DETACH) 
	@JoinColumn(name = "idCadastro")
	private Cadastro cadastro;
	@ManyToMany(cascade = CascadeType.DETACH)
	private List<Motocicleta> locados;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;


	public Locadora() {
	}

	public Locadora(Cadastro cadastro, List<Motocicleta> locados) throws CampoInvalidoException {
		if (cadastro == null) {
			throw new CampoInvalidoException("Não é possível fazer a requisição.");
		}
		if (locados == null) {
			throw new CampoInvalidoException("Não é possível completar a requisição.");
		}
		this.locados = locados;
		this.cadastro = cadastro;
	}
	public String imprimir() {
		String itensSelecionados = "";
		for (Motocicleta locado : locados) {
			itensSelecionados += locado;
		}
		return this + itensSelecionados;
	}
	public String obterLinha() {
		return this.getCadastro().getNome() + ";" + this.getLocados().size() + ";";
	}

	@Override
	public String toString() {
		return String.format("%s;%s", cadastro, locados);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public List<Motocicleta> getLocados() {
		return locados;
	}

	public void setLocados(List<Motocicleta> locados) {
		this.locados = locados;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}