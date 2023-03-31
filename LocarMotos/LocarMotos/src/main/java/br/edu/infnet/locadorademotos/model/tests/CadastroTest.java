package br.edu.infnet.locadorademotos.model.tests;


import br.edu.infnet.locadorademotos.model.domain.Cadastro;
import br.edu.infnet.locadorademotos.model.exceptions.CnhInvalidaException;
import br.edu.infnet.locadorademotos.model.exceptions.CpfInvalidoException;
import br.edu.infnet.locadorademotos.model.exceptions.IdadeInvalidaException;
import br.edu.infnet.locadorademotos.model.exceptions.NomeInvalidoException;

public class CadastroTest {

    public static void main(String args[]) {

        try {
            Cadastro cadastro1 = new Cadastro("Luiz", 156655860, "155.222.522-27");
            cadastro1.setIdade(29);
            System.out.println(cadastro1);
        } catch (NomeInvalidoException | IdadeInvalidaException | CnhInvalidaException | CpfInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }
        try {
            Cadastro cadastro2 = new Cadastro("Marcelo", 954566544, null);
            System.out.println(cadastro2);
        } catch (NomeInvalidoException | IdadeInvalidaException | CnhInvalidaException | CpfInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }
        try {
            Cadastro cadastro3 = new Cadastro("Maria", 0, "785.282.112-37");
            cadastro3.setIdade(45);
            System.out.println(cadastro3);
        } catch (NomeInvalidoException | IdadeInvalidaException | CnhInvalidaException | CpfInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

    }
}
