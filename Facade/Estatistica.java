package facade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Estatistica {
    private int especie;
    private int despacho;

    public int getEspecie() {
        return especie;
    }

    public void setId(int especie) {
        this.especie = especie;
    }

    public int getDespacho() {
        return despacho;
    }

    public void setDespacho(int despacho) {
        this.despacho = despacho;
    }

    public void gerarEstatistica() {
        System.out.println("Gerando estatística");

        List<String> dados = obterDadosDoBanco();
        
        GraficoColunas grafico = new GraficoColunas();
        grafico.atualizar(dados);
    }

    private List<String> obterDadosDoBanco() {
        List<String> dados = new ArrayList<>();
 
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/seu_banco_de_dados", "seu_usuario", "sua_senha")) {
            String sql = "SELECT especie, despacho FROM BENEFICIO";
            try (PreparedStatement x = conn.prepareStatement(sql)) {
                try (ResultSet y = x.executeQuery()) {
                    while (y.next()) {
                        String especie = y.getString("especie");
                        String despacho = y.getString("despacho");
                        dados.add(especie + ":" + despacho);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dados;
    }
}