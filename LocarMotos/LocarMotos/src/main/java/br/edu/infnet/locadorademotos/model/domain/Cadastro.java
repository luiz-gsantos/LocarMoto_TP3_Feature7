package br.edu.infnet.locadorademotos.model.domain;

import br.edu.infnet.locadorademotos.model.exceptions.CnhInvalidaException;
import br.edu.infnet.locadorademotos.model.exceptions.CpfInvalidoException;
import br.edu.infnet.locadorademotos.model.exceptions.IdadeInvalidaException;
import br.edu.infnet.locadorademotos.model.exceptions.NomeInvalidoException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "TCadastro")
public class Cadastro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	private int idade;
	private int cnh;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	public Cadastro() {
	}
	public Cadastro(String nome, int cnh, String cpf) throws NomeInvalidoException, IdadeInvalidaException, CnhInvalidaException, CpfInvalidoException {
		if (idade >= 18) {
			throw new IdadeInvalidaException("O cliente deve ser maior de idade(18).");
		}
		this.nome = nome;
		this.cnh = cnh;
		if (cnh <= 0) {
			throw new CnhInvalidaException("O cliente deve possuir uma CNH válida.");
		}
		this.cpf = cpf;
		if (cpf == null) {
			throw new CpfInvalidoException("O CPF deve ser preenchido!");
		}
	}

	@Override
	public String toString() {
		return "Cadastro{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", cpf='" + cpf + '\'' +
				", idade=" + idade +
				", cnh=" + cnh +
				", usuario=" + usuario +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getCnh() {
		return cnh;
	}

	public void setCnh(int cnh) {
		this.cnh = cnh;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}