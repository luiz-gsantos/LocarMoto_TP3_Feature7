package br.edu.infnet.locadorademotos.model.exceptions;

public class CampoInvalidoException extends Exception {

    private static final long serialVersionUID = 1L;

    public CampoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
//LGMS