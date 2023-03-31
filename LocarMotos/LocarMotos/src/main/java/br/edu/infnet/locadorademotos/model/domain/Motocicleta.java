package br.edu.infnet.locadorademotos.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import br.edu.infnet.locadorademotos.model.exceptions.CampoInvalidoException;
import br.edu.infnet.locadorademotos.model.exceptions.CilindradasInvalidaException;
import br.edu.infnet.locadorademotos.model.exceptions.MarcaInvalidaException;
import br.edu.infnet.locadorademotos.model.exceptions.ModeloInvalidoException;


@Entity
@Table(name = "TMotocicleta")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Motocicleta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int ano;
	private float valorVenal;
	private float precoDiaria;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;

	public Motocicleta() {
	}
	public Motocicleta(int ano, float valorVenal, float precoDiaria) throws CampoInvalidoException {
		if (valorVenal <= 0) {
			throw new CampoInvalidoException("O valor do produto está zerado!");
		}
		if (precoDiaria <= 0) {
			throw new CampoInvalidoException("O valor do produto está negativo!");
		}
		this.ano = ano;
		this.valorVenal = valorVenal;
		this.precoDiaria = precoDiaria;
	}
	public abstract float calcularDiaria() throws CilindradasInvalidaException, ModeloInvalidoException, MarcaInvalidaException, CampoInvalidoException;


	@Override
	public String toString() {
		return "Motocicleta{" +
				", ano=" + ano +
				", valorVenal=" + valorVenal +
				", precoDiaria=" + precoDiaria +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public float getValorVenal() {
		return valorVenal;
	}

	public void setValorVenal(float valorVenal) {
		this.valorVenal = valorVenal;
	}

	public float getPrecoDiaria() {
		return precoDiaria;
	}

	public float setPrecoDiaria(float precoDiaria) {
		this.precoDiaria = precoDiaria;
		return precoDiaria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


}