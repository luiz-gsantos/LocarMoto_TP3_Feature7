package br.edu.infnet.locadorademotos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import br.edu.infnet.locadorademotos.model.domain.Cadastro;
import br.edu.infnet.locadorademotos.model.domain.Usuario;
import br.edu.infnet.locadorademotos.model.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class CadastroLoader implements ApplicationRunner {
    @Autowired
    private CadastroService cadastroService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            String arq = "cadastrostext.txt";
            try {
                FileReader fileR = new FileReader(arq);
                BufferedReader leitura = new BufferedReader(fileR);
                String linha = leitura.readLine();
                String[] campos = null;
                while(linha != null) {
                    campos = linha.split(";");
                    Usuario usuario = new Usuario();
                    usuario.setId(1);
                    Cadastro cadastro = new Cadastro(
                            campos[0],
                            Integer.valueOf(campos[1]),
                            campos[2]
                    );
                    cadastro.setUsuario(usuario);
                    cadastroService.incluir(cadastro);
                    System.out.println("A inclusão do "+cadastro.getNome()+" foi realizada com sucesso!!!");
                    linha = leitura.readLine();
                }
                leitura.close();
                fileR.close();
            } catch (IOException e) {
                System.out.println("[ERRO] " + e.getMessage());
            }
        } finally {
            System.out.println("Usuários do arquivo texto no banco de dados.");
        }
    }
}
