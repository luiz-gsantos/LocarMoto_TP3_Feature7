package br.edu.infnet.locadorademotos;

import br.edu.infnet.locadorademotos.model.domain.Usuario;
import br.edu.infnet.locadorademotos.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class UsuarioLoader implements ApplicationRunner {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Usuario userAdmin = new Usuario("Administrador ", "admin@admin.com", "admin@admin.com");
        userAdmin.setCpf(999888777);
        userAdmin.setCnh(1115552999);
        usuarioService.incluir(userAdmin);
        System.out.println("Inclusão do administrador "+userAdmin.getNome()+" realizada com sucesso!");
        for (int i = 0; i < 5; i++) {
            Usuario usuario = new Usuario("Administrador " + i, "admin"+i+"@admin.com", "0"+i);
            usuario.setCpf(i*344);
            usuario.setCnh(i*230);
            usuarioService.incluir(usuario);
            System.out.println("Inclusão do usuário "+usuario.getNome()+" realizada com sucesso!");
        }

    }
}
