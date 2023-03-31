package br.edu.infnet.locadorademotos.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import br.edu.infnet.locadorademotos.model.exceptions.CampoInvalidoException;
import br.edu.infnet.locadorademotos.model.exceptions.MarcaInvalidaException;
import br.edu.infnet.locadorademotos.model.exceptions.ModeloInvalidoException;


@Entity
@Table(name = "TCustom")
public class Custom extends Motocicleta {

	private String marca;
	private String modelo;
	private boolean seguro;
	private int cilindradas;
	public Custom() {
	}

	public Custom(int ano, float valorVenal, float precoDiaria) throws CampoInvalidoException {
		super(ano, valorVenal, precoDiaria);
		this.marca = marca;
	}
	@Override
	public float calcularDiaria() throws ModeloInvalidoException, MarcaInvalidaException {
		if (modelo == null) {
			throw new ModeloInvalidoException("O modelo deve ser informado.");
		}
		if (marca == null) {
			throw new MarcaInvalidaException("A marca deve ser informada.");
		}
		Float adicional = 0f;
		if (modelo.equalsIgnoreCase("Touring")) {
			adicional += 30;
		}
		if (modelo.equalsIgnoreCase("CafeRacer")) {
			adicional += 10;
		}
		if (modelo.equalsIgnoreCase("Brat")) {
			adicional += 20;
		}
		if (modelo.equalsIgnoreCase("Chopper")) {
			adicional += 10;
		}
		if (modelo.equalsIgnoreCase("Bobber")) {
			adicional += 40;
		}
		if (marca.equalsIgnoreCase("BMW")) {
			adicional += 50;
		}
		if (marca.equalsIgnoreCase("HarleyDavidson")) {
			adicional += 50;
		}
		if (marca.equalsIgnoreCase("Triumph ")) {
			adicional += 40;
		}
		Float valor = this.getValorVenal() / 250;
		Float valor_total = valor + adicional + (cilindradas / 15);
		return setPrecoDiaria(valor_total);
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(marca);
		sb.append(";");
		sb.append(modelo);
		sb.append(";");
		sb.append(cilindradas);
		sb.append(";");
		sb.append(seguro ? "Sim" : "Não");
		return sb.toString();
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public boolean isSeguro() {
		return seguro;
	}

	public void setSeguro(boolean seguro) {
		this.seguro = seguro;
	}

	public int getCilindradas() {
		return cilindradas;
	}

	public void setCilindradas(int cilindradas) {
		this.cilindradas = cilindradas;
	}
}