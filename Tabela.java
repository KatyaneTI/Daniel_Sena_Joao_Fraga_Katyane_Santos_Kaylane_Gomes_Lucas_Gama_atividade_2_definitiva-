import java.util.ArrayList;
import java.util.List;

// Classe Tabela que atua como Observador
class Tabela implements Observador {
    @Override
    public void atualizar(List<String> dados) {
        System.out.println("Tabela: Dados atualizados:");
        for (String dado : dados) {
            System.out.println(dado);
        }
    }
}
