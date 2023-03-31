package br.edu.infnet.locadorademotos.model.tests;



import br.edu.infnet.locadorademotos.model.domain.*;
import br.edu.infnet.locadorademotos.model.exceptions.*;
import java.util.ArrayList;
import java.util.List;

public class LocadoraTest {

    public static void main(String[] args) {
        List<Motocicleta> locados1 = new ArrayList<Motocicleta>();
        List<Motocicleta> locados2 = new ArrayList<Motocicleta>();
        List<Motocicleta> locados3 = new ArrayList<Motocicleta>();

        try {
            Custom motoCustom1 = new Custom( 1990, 20200, 30);
            motoCustom1.setMarca("bmw");
            motoCustom1.setModelo("Tourin");
            motoCustom1.setSeguro(true);
            motoCustom1.setCilindradas(350);
            motoCustom1.calcularDiaria();
            locados1.add(motoCustom1);
        } catch (ModeloInvalidoException | MarcaInvalidaException | CampoInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }
        try {
            Street motoStret1 = new Street( 2010, 30000, 30);
            motoStret1.setParaTrabalho(true);
            motoStret1.setSeguro(false);
            motoStret1.setCilindradas(650);
            motoStret1.calcularDiaria();
            locados2.add(motoStret1);
        } catch (CilindradasInvalidaException | CampoInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }
        try {
            Trail motoTrail1 = new Trail( 2010, 30000, 30);
            motoTrail1.setPeso(70);
            motoTrail1.setSeguro(false);
            motoTrail1.setCilindradas(650);
            motoTrail1.calcularDiaria();
            locados3.add(motoTrail1);
        } catch (CilindradasInvalidaException | CampoInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }
        try {
            Locadora cadastro1 = new Locadora(new Cadastro("Luiz", 156655860, "155.222.522-27"), locados1);
            System.out.println(cadastro1.imprimir());
        } catch (NomeInvalidoException | IdadeInvalidaException | CnhInvalidaException | CpfInvalidoException | CampoInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }
        try {
            Locadora cadastro2 = new Locadora(new Cadastro("Fernando", 454245454, "333.268.522-82"), locados2);
            cadastro2.setLocados(locados2);
            System.out.println(cadastro2.imprimir());
        } catch (NomeInvalidoException | IdadeInvalidaException | CnhInvalidaException | CpfInvalidoException | CampoInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }
        try {
            Locadora cadastro3 = new Locadora(new Cadastro("joao", 545245455, "144.642.552-98"), locados3);
            cadastro3.setLocados(locados3);
            System.out.println(cadastro3.imprimir());
        } catch (NomeInvalidoException | IdadeInvalidaException | CnhInvalidaException | CpfInvalidoException | CampoInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

    }
}
