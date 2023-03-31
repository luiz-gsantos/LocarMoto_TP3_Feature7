package br.edu.infnet.locadorademotos;

import br.edu.infnet.locadorademotos.model.domain.Custom;
import br.edu.infnet.locadorademotos.model.domain.Usuario;
import br.edu.infnet.locadorademotos.model.exceptions.CampoInvalidoException;
import br.edu.infnet.locadorademotos.model.exceptions.MarcaInvalidaException;
import br.edu.infnet.locadorademotos.model.exceptions.ModeloInvalidoException;
import br.edu.infnet.locadorademotos.model.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Order(3)
@Component
public class CustomLoader implements ApplicationRunner {

    @Autowired
    private CustomService customService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Usuario admin = new Usuario();
        admin.setId(1);
        try {
            Custom custom = new Custom(1990, 20200, 30);
            custom.setMarca("bmw");
            custom.setModelo("Tourin");
            custom.setSeguro(true);
            custom.setCilindradas(350);
            custom.setUsuario(admin);
            System.out.println("O custo da diaria da moto "+custom.getModelo()+" é  = R$" + custom.calcularDiaria());
            customService.incluir(custom);
        } catch (ModeloInvalidoException | MarcaInvalidaException | CampoInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }
        try {
            Custom custom = new Custom( 2000, 45000, 30);
            custom.setMarca("HarleyDavidson");
            custom.setModelo("custom");
            custom.setSeguro(false);
            custom.setCilindradas(650);
            custom.setUsuario(admin);
            System.out.println(custom);
            System.out.println("O custo da diaria da moto "+custom.getModelo()+" é  = R$" + custom.calcularDiaria());
            customService.incluir(custom);
        } catch (ModeloInvalidoException | MarcaInvalidaException | CampoInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }
        try {
            Custom custom = new Custom( 2010, 30000, 30);
            custom.setMarca("yamaha");
            custom.setModelo("Bobber");
            custom.setSeguro(false);
            custom.setCilindradas(650);
            System.out.println(custom);
            custom.setUsuario(admin);
            System.out.println("O custo da diaria da moto "+custom.getModelo()+" é  = R$" + custom.calcularDiaria());

            customService.incluir(custom);
        } catch (ModeloInvalidoException | MarcaInvalidaException | CampoInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }
        System.out.println("Listagem de motos custom adicionadas:");
        for(Custom custom : customService.obterLista()) {
            System.out.printf("%d - %s - %s\n",
                    custom.getId(),
                    custom.getModelo(),
                    custom.getMarca(),
                    custom.getCilindradas()
                    );
        }
    }
}