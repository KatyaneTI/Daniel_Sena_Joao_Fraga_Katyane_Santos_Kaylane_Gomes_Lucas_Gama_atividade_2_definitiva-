package ES2;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
    	String[] opcoes = {"Competência concessão", "Espécie", "CID", "CID", "Despacho", "Dt Nascimento", "Sexo.", "Clientela", "Mun Resid", "Vínculo dependentes", "Forma Filiação", "UF", "Qt SM RMI"};
        String Coluna = "UF";
        String valor = "Alagoas";
        Tabela requisicao = new Tabela(Coluna, valor);
        
    }
}



package ES2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class pesquisa {
    private String valor;

    public pesquisa(String valor) {
        this.valor = valor;
    }

    public List<Beneficio> buscarBeneficiosPorUF() {
        List<Beneficio> beneficios = new ArrayList<>();
        
        String url = "jdbc:postgresql://<bd.c90644aq4xwd.us-east-1.rds.amazonaws.com>:5432/<teste>";
        String usuario = "postgres";
        String senha = "bancodedados";
        
        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            String sql = "SELECT cid, sexo, dt_nascimento, clientela, uf FROM beneficio WHERE uf = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, valor);
            ResultSet resultado = statement.executeQuery();
            
            while (resultado.next()) {
                String cid = resultado.getString("cid");
                String sexo = resultado.getString("sexo");
                Date dataNascimento = resultado.getDate("dt_nascimento");
                String clientela = resultado.getString("clientela");
                String uf = resultado.getString("uf");
                
                // Construir um objeto Beneficio com os dados do banco de dados
                Beneficio beneficio = new Beneficio(cid, sexo, dataNascimento, clientela, uf);
                beneficios.add(beneficio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return beneficios;
    }

    public static void main(String[] args) {
        pesquisa pesquisar = new pesquisa("Alagoas");
        List<Beneficio> resultados = pesquisar.buscarBeneficiosPorUF();
        
        // Aqui você pode manipular os resultados conforme necessário
        for (Beneficio beneficio : resultados) {
            System.out.println(beneficio);
        }
    }
}

class Beneficio {
    private String cid;
    private String sexo;
    private Date dataNascimento;
    private String clientela;
    private String uf;

    public Beneficio(String cid, String sexo, Date dataNascimento, String clientela, String uf) {
        this.cid = cid;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.clientela = clientela;
        this.uf = uf;
    }

    // Getters e Setters
    // Métodos toString(), equals() e hashCode() podem ser implementados conforme necessário
}
