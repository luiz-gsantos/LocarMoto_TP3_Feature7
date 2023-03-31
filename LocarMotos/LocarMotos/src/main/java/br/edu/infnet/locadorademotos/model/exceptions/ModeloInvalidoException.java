package br.edu.infnet.locadorademotos.model.exceptions;

public class ModeloInvalidoException extends Exception {

    private static final long serialVersionUID = 1L;

    public ModeloInvalidoException(String mensagem) {
        super(mensagem);
    }
}
//LGMS