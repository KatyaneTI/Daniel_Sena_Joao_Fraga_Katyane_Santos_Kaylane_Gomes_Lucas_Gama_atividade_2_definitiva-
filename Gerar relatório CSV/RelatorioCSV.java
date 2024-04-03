import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class RelatorioCSV implements RelatorioStrategy {
    @Override
    public void gerarRelatorio() {
    static final String DB_URL = "jdbc:postgresql://bd.c90644aq4xwd.us-east-1.rds.amazonaws.com:5432/bd";
    static final String USER = "postgres";
    static final String PASS = "bancodedados";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        FileWriter csvWriter = null;
        try {
            Class.forName("org.postgresql.Driver");

            System.out.println("Conectando ao banco de dados...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            csvWriter = new FileWriter("relatorio.csv");
            csvWriter.append("Competência de Concessao, Espécie, CID, CID Especificação, Despacho, Data de Nascimento, Sexo, Clientela, Município de Residência, Vínculo Dependentes, Forma de Filiação, UF, Quantidade de SM RMI\n");

            System.out.println("Criando declaração...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT competencia_concessao, especie, cid, cid_especificacao, despacho, dt_nascimento, sexo, clientela, mun_resid, vinculo_dependentes, forma_filiacao, uf, qt_sm_rmi FROM beneficio";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                csvWriter.append(rs.getString("competencia_concessao") + ",");
                csvWriter.append(rs.getString("especie") + ",");
                csvWriter.append(rs.getString("cid") + ",");
                csvWriter.append(rs.getString("cid_especificacao") + ",");
                csvWriter.append(rs.getString("despacho") + ",");
                csvWriter.append(rs.getString("dt_nascimento") + ",");
                csvWriter.append(rs.getString("sexo") + ",");
                csvWriter.append(rs.getString("clientela") + ",");
                csvWriter.append(rs.getString("mun_resid") + ",");
                csvWriter.append(rs.getString("vinculo_dependentes") + ",");
                csvWriter.append(rs.getString("forma_filiacao") + ",");
                csvWriter.append(rs.getString("uf") + ",");
                csvWriter.append(rs.getString("qt_sm_rmi") + "\n");
            }

            rs.close();
            stmt.close();
            conn.close();
            csvWriter.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (csvWriter != null) csvWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Fim do programa.");
    }
    }
}
