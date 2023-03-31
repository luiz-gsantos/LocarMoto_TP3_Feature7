package br.edu.infnet.locadorademotos.model.tests;


import br.edu.infnet.locadorademotos.model.domain.Custom;
import br.edu.infnet.locadorademotos.model.exceptions.CampoInvalidoException;
import br.edu.infnet.locadorademotos.model.exceptions.MarcaInvalidaException;
import br.edu.infnet.locadorademotos.model.exceptions.ModeloInvalidoException;

public class CustomTest {

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
            Custom motoCustom2 = new Custom( 2000, 45000, 30);
            motoCustom2.setMarca("HarleyDavidson");
            motoCustom2.setModelo(null);
            motoCustom2.setSeguro(false);
            motoCustom2.setCilindradas(650);
            motoCustom2.calcularDiaria();
            System.out.println(motoCustom2);
        } catch (ModeloInvalidoException | MarcaInvalidaException | CampoInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }
        try {
            Custom motoCustom3 = new Custom( 2010, 30000, 30);
            motoCustom3.setMarca(null);
            motoCustom3.setModelo("Bobber");
            motoCustom3.setSeguro(false);
            motoCustom3.setCilindradas(650);
            motoCustom3.calcularDiaria();
            System.out.println(motoCustom3);
        } catch (ModeloInvalidoException | MarcaInvalidaException | CampoInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

    }
}
