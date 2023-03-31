package br.edu.infnet.locadorademotos.model.tests;


import br.edu.infnet.locadorademotos.model.domain.Custom;
import br.edu.infnet.locadorademotos.model.domain.Street;
import br.edu.infnet.locadorademotos.model.domain.Trail;
import br.edu.infnet.locadorademotos.model.exceptions.CampoInvalidoException;
import br.edu.infnet.locadorademotos.model.exceptions.CilindradasInvalidaException;
import br.edu.infnet.locadorademotos.model.exceptions.MarcaInvalidaException;
import br.edu.infnet.locadorademotos.model.exceptions.ModeloInvalidoException;

public class MotocicletaTest {

    public static void main(String[] args) {

        try {
            Custom motoCustom1 = new Custom(1990, 20200, 30);
            motoCustom1.setMarca("bmw");
            motoCustom1.setModelo("Tourin");
            motoCustom1.setSeguro(true);
            motoCustom1.setCilindradas(350);
            motoCustom1.calcularDiaria();
            System.out.println(motoCustom1);
        } catch (ModeloInvalidoException | MarcaInvalidaException | CampoInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

        try {
            Street motoStret2 = new Street( 2010, 55200, 30);
            motoStret2.setParaTrabalho(true);
            motoStret2.setSeguro(false);
            motoStret2.setCilindradas(1000);
            motoStret2.calcularDiaria();
            System.out.println(motoStret2);
        } catch (CilindradasInvalidaException | CampoInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }
        try {
            Trail motoTrail1 = new Trail(2010, 30000, 30);
            motoTrail1.setPeso(70);
            motoTrail1.setSeguro(false);
            motoTrail1.setCilindradas(650);
            motoTrail1.calcularDiaria();
            System.out.println(motoTrail1);
        } catch (CilindradasInvalidaException | CampoInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

    }
}