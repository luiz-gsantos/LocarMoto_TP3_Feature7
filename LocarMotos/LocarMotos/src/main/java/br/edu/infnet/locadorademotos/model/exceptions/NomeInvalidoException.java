package br.edu.infnet.locadorademotos.model.exceptions;

public class NomeInvalidoException extends Exception {

    private static final long serialVersionUID = 1L;

    public NomeInvalidoException(String mensagem) {
        super(mensagem);
    }
}
//LGMS