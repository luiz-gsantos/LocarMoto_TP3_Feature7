package br.edu.infnet.locadorademotos.model.tests;



import br.edu.infnet.locadorademotos.model.domain.*;
import br.edu.infnet.locadorademotos.model.exceptions.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoTest {

    public static void main(String[] args) {
        try {
            String arq = "locadoramoto.txt";
            try {
                FileReader fileR = new FileReader(arq);
                BufferedReader leitura = new BufferedReader(fileR);
                FileWriter fileW = new FileWriter("out_" + arq);
                BufferedWriter escrita = new BufferedWriter(fileW);
                String linha = leitura.readLine();
                String[] campos = null;
                List<Motocicleta> motos = new ArrayList<Motocicleta>();
                Locadora locado = null;

                while (linha != null) {
                    campos = linha.split(";");
                    switch (campos[0].toUpperCase()) {
                        case "A":
                            try {
                            locado = new Locadora(new Cadastro(campos[1], Integer.valueOf(campos[2]), campos[3]), motos);
                            System.out.println(locado);
                        } catch (NomeInvalidoException | IdadeInvalidaException | CnhInvalidaException |
                                 CpfInvalidoException | CampoInvalidoException e) {
                            System.out.println("[ERRO] " + e.getMessage());
                        }
                        break;
                        case "B":
                            try {
                            Custom motoCustom1 = new Custom(Integer.valueOf(campos[2]), Integer.valueOf(campos[3]), Integer.valueOf(campos[4]));
                            motoCustom1.setMarca(campos[6]);
                            motoCustom1.setModelo(campos[7]);
                            motoCustom1.setCilindradas(Integer.valueOf(campos[9]));
                            motoCustom1.setSeguro(Boolean.valueOf(campos[8]));
                            motoCustom1.calcularDiaria();
                            System.out.println(motoCustom1);
                            motos.add(motoCustom1);
                        } catch (ModeloInvalidoException | MarcaInvalidaException | CampoInvalidoException e) {
                            System.out.println("[ERRO] " + e.getMessage());
                        }
                        break;
                        case "C":
                            try {
                            Street motoStret1 = new Street( Integer.valueOf(campos[2]), Integer.valueOf(campos[3]), Integer.valueOf(campos[4]));
                            motoStret1.setParaTrabalho(Boolean.valueOf(campos[5]));
                            motoStret1.setCilindradas(Integer.valueOf(campos[7]));
                            motoStret1.setSeguro(Boolean.valueOf(campos[6]));
                            motoStret1.calcularDiaria();
                            System.out.println(motoStret1);
                            motos.add(motoStret1);
                        } catch (CilindradasInvalidaException | CampoInvalidoException e) {
                            System.out.println("[ERRO] " + e.getMessage());
                        }
                        break;
                        case "D":
                            try {
                            Trail motoTrail1 = new Trail(Integer.valueOf(campos[2]), Integer.valueOf(campos[3]), Integer.valueOf(campos[4]));
                            motoTrail1.setSeguro(Boolean.valueOf(campos[6]));
                            motoTrail1.setPeso(Integer.valueOf(campos[5]));
                            motoTrail1.setCilindradas(Integer.valueOf(campos[7]));
                            motoTrail1.calcularDiaria();
                            System.out.println(motoTrail1);
                            motos.add(motoTrail1);
                        } catch (CilindradasInvalidaException | CampoInvalidoException e) {
                            System.out.println("[ERRO] " + e.getMessage());
                        }
                        break;
                        default:
                            System.out.println("Registro inválido!!!");
                            break;
                    }
                    linha = leitura.readLine();
                }
                escrita.write(locado.obterLinha());
                escrita.close();
                leitura.close();
                fileR.close();
            } catch (IOException e) {
                System.out.println("[ERRO] " + e.getMessage());
            }
        } finally {
            System.out.println("Processamento realizado com sucesso!!!");
        }
    }
}
