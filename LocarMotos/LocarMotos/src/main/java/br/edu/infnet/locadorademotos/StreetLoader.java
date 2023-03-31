package br.edu.infnet.locadorademotos;

import br.edu.infnet.locadorademotos.model.domain.Street;
import br.edu.infnet.locadorademotos.model.domain.Usuario;
import br.edu.infnet.locadorademotos.model.exceptions.CampoInvalidoException;
import br.edu.infnet.locadorademotos.model.exceptions.CilindradasInvalidaException;
import br.edu.infnet.locadorademotos.model.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Order(4)
@Component
public class StreetLoader implements ApplicationRunner {

    @Autowired
    private StreetService streetService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Usuario admin = new Usuario();
        admin.setId(1);
        try {
            Street street = new Street(2010, 30000, 30);
            street.setParaTrabalho(true);
            street.setSeguro(false);
            street.setCilindradas(650);
            street.setUsuario(admin);
            System.out.println("O custo da diaria da moto é  = R$" + street.calcularDiaria());
            streetService.incluir(street);
        } catch (CilindradasInvalidaException | CampoInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }
        try {
            Street street = new Street(2010, 15000, 30);
            street.setParaTrabalho(true);
            street.setSeguro(false);
            street.setCilindradas(1000);
            street.setUsuario(admin);
            System.out.println(street);
            System.out.println("O custo da diaria da moto  é  = R$" + street.calcularDiaria());
            streetService.incluir(street);
        } catch (CilindradasInvalidaException | CampoInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }
        try {
            Street street = new Street(2020, 20000, 30);
            street.setParaTrabalho(true);
            street.setSeguro(false);
            street.setCilindradas(250);
            System.out.println(street);
            street.setUsuario(admin);
            System.out.println("O custo da diaria da moto é  = R$" + street.calcularDiaria());
            streetService.incluir(street);
        } catch (CilindradasInvalidaException | CampoInvalidoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }
        System.out.println("Listagem de motos Street adicionadas:");
        for(Street street : streetService.obterLista()) {
            System.out.printf("%d - %s - %s\n",
                    street.getId(),
                    street.getCilindradas(),
                    street.isParaTrabalho(),
                    street.getAno()
                    );
        }
    }
}