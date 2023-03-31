package br.edu.infnet.locadorademotos.model.domain;


import br.edu.infnet.locadorademotos.model.exceptions.CampoInvalidoException;
import br.edu.infnet.locadorademotos.model.exceptions.CilindradasInvalidaException;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TTrail")
public class Trail extends Motocicleta {

	private int cilindradas;
	private int peso;
	private boolean seguro;


	public Trail(){

	}
	public Trail( int ano, float valorVenal, float precoDiaria) throws CampoInvalidoException {
		super(ano, valorVenal, precoDiaria);
	}

	@Override
	public float calcularDiaria() throws CilindradasInvalidaException, CampoInvalidoException {
		if (cilindradas <= 0) {
			throw new CilindradasInvalidaException("As Cilindradas devem ser informadas.");
		}
		if (peso <= 0) {
			throw new CampoInvalidoException("O peso deve ser informado.");
		}
		Float adicional = 0f;
		if (seguro == true) {
			adicional += 20;
		}
		Float valor = this.getValorVenal() / 250;
		Float valor_total = valor + adicional + (cilindradas / 15) + (peso * 0.9f);
		return setPrecoDiaria(valor_total);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(peso);
		sb.append(";");
		sb.append(cilindradas);
		sb.append(";");
		sb.append(seguro ? "Sim" : "Não");
		return sb.toString();
	}

	public int getCilindradas() {
		return cilindradas;
	}

	public void setCilindradas(int cilindradas) {
		this.cilindradas = cilindradas;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public boolean isSeguro() {
		return seguro;
	}

	public void setSeguro(boolean seguro) {
		this.seguro = seguro;
	}

}
