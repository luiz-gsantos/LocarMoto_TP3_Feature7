package br.edu.infnet.locadorademotos.model.tests;


import br.edu.infnet.locadorademotos.model.domain.Street;
import br.edu.infnet.locadorademotos.model.exceptions.CampoInvalidoException;
import br.edu.infnet.locadorademotos.model.exceptions.CilindradasInvalidaException;

public class StreetTest {

    public static void main(String[] args) {
        try {
            Street motoStret1 = new Street(2010, 30000, 30);
            motoStret1.setParaTrabalho(true);
            motoStret1.setSeguro(false);
            motoStret1.setCilindradas(650);
            motoStret1.calcularDiaria();
            System.out.println(motoStret1);
        } catch (CilindradasInvalidaException | CampoInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }
        try {
            Street motoStret2 = new Street(2010, 0, 30);
            motoStret2.setParaTrabalho(true);
            motoStret2.setSeguro(false);
            motoStret2.setCilindradas(1000);
            motoStret2.calcularDiaria();
            System.out.println(motoStret2);
        } catch (CilindradasInvalidaException | CampoInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }
        try {
            Street motoStret3 = new Street(2020, 20000, 30);
            motoStret3.setParaTrabalho(true);
            motoStret3.setSeguro(false);
            motoStret3.setCilindradas(0);
            motoStret3.calcularDiaria();
            System.out.println(motoStret3);
        } catch (CilindradasInvalidaException | CampoInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

    }
}
