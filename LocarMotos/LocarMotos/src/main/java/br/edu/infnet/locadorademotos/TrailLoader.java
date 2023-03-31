package br.edu.infnet.locadorademotos;

import br.edu.infnet.locadorademotos.model.domain.Trail;
import br.edu.infnet.locadorademotos.model.domain.Usuario;
import br.edu.infnet.locadorademotos.model.exceptions.CampoInvalidoException;
import br.edu.infnet.locadorademotos.model.exceptions.CilindradasInvalidaException;
import br.edu.infnet.locadorademotos.model.service.TrailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Order(5)
@Component
public class TrailLoader implements ApplicationRunner {

    @Autowired
    private TrailService trailService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Usuario admin = new Usuario();
        admin.setId(1);
        try {
            Trail trail = new Trail(2010, 30000, 30);
            trail.setPeso(70);
            trail.setSeguro(false);
            trail.setCilindradas(650);
            trail.setUsuario(admin);
            System.out.println("O custo da diaria da moto é  = R$" + trail.calcularDiaria());
            trailService.incluir(trail);
        } catch (CilindradasInvalidaException | CampoInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }
        try {
            Trail trail = new Trail(2010, 25000, 30);
            trail.setPeso(55);
            trail.setSeguro(false);
            trail.setCilindradas(250);
            trail.setUsuario(admin);
            System.out.println(trail);
            System.out.println("O custo da diaria da moto é  = R$" + trail.calcularDiaria());
            trailService.incluir(trail);
        } catch (CilindradasInvalidaException | CampoInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }
        try {
            Trail trail = new Trail(2020, 20000, 30);
            trail.setPeso(120);
            trail.setSeguro(false);
            trail.setCilindradas(650);
            System.out.println(trail);
            trail.setUsuario(admin);
            System.out.println("O custo da diaria da moto é  = R$" + trail.calcularDiaria());
            trailService.incluir(trail);
        } catch (CilindradasInvalidaException | CampoInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }
        System.out.println("Listagem de motos trail adicionadas:");
        for(Trail trail : trailService.obterLista()) {
            System.out.printf("%d - %s - %s\n",
                    trail.getId(),
                    trail.getPeso(),
                    trail.getValorVenal(),
                    trail.getCilindradas()
                    );
        }
    }
}