package br.edu.infnet.locadorademotos.model.tests;


import br.edu.infnet.locadorademotos.model.domain.Trail;
import br.edu.infnet.locadorademotos.model.exceptions.CampoInvalidoException;
import br.edu.infnet.locadorademotos.model.exceptions.CilindradasInvalidaException;

public class TrailTest {

    public static void main(String[] args) {
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
        try {
            Trail motoTrail2 = new Trail(2010, 25000, 30);
            motoTrail2.setPeso(55);
            motoTrail2.setSeguro(false);
            motoTrail2.setCilindradas(0);
            motoTrail2.calcularDiaria();
            System.out.println(motoTrail2);
        } catch (CilindradasInvalidaException | CampoInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }
        try {
            Trail motoTrail3 = new Trail(2020, 20000, 30);
            motoTrail3.setPeso(0);
            motoTrail3.setSeguro(false);
            motoTrail3.setCilindradas(650);
            motoTrail3.calcularDiaria();
            System.out.println(motoTrail3);
        } catch (CilindradasInvalidaException | CampoInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

    }
}
