package facade;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Beneficio {
    private String dbUrl;
    private String user;
    private String pass;

    public Beneficio(String dbUrl, String user, String pass) {
        this.dbUrl = dbUrl;
        this.user = user;
        this.pass = pass;
    }

    public void readBeneficio() {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(dbUrl, user, pass);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM BENEFICIO";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String competenciaConcessao = rs.getString("competencia_concessao");
                String especie = rs.getString("especie");
                String cid = rs.getString("cid");
                String cidEspecificacao = rs.getString("cid_especificacao");
                String despacho = rs.getString("despacho");
                Date dtNascimento = rs.getDate("dt_nascimento");
                String sexo = rs.getString("sexo");
                String clientela = rs.getString("clientela");
                String munResid = rs.getString("mun_resid");
                String vinculoDependentes = rs.getString("vinculo_dependentes");
                String formaFiliacao = rs.getString("forma_filiacao");
                String uf = rs.getString("uf");
                String qtSmRmi = rs.getString("qt_sm_rmi");

                System.out.println("ID: " + id);
                System.out.println("Competência de Concessão: " + competenciaConcessao);
                System.out.println("Espécie: " + especie);
                System.out.println("CID: " + cid);
                System.out.println("CID Especificação: " + cidEspecificacao);
                System.out.println("Despacho: " + despacho);
                System.out.println("Data de Nascimento: " + dtNascimento);
                System.out.println("Sexo: " + sexo);
                System.out.println("Clientela: " + clientela);
                System.out.println("Município de Residência: " + munResid);
                System.out.println("Vínculo Dependentes: " + vinculoDependentes);
                System.out.println("Forma de Filiação: " + formaFiliacao);
                System.out.println("UF: " + uf);
                System.out.println("Quantidade de SM RMI: " + qtSmRmi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void createBeneficio(Scanner scanner) throws ParseException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DriverManager.getConnection(dbUrl, user, pass);
            String sql = "INSERT INTO BENEFICIO (competencia_concessao, especie, cid, cid_especificacao, despacho, dt_nascimento, sexo, clientela, mun_resid, vinculo_dependentes, forma_filiacao, uf, qt_sm_rmi) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            System.out.print("Competência de Concessão: ");
            pstmt.setString(1, scanner.nextLine());
            System.out.print("Espécie: ");
            pstmt.setString(2, scanner.nextLine());
            System.out.print("CID: ");
            pstmt.setString(3, scanner.nextLine());
            System.out.print("CID Especificação: ");
            pstmt.setString(4, scanner.nextLine());
            System.out.print("Despacho: ");
            pstmt.setString(5, scanner.nextLine());
            System.out.print("Data de Nascimento (AAAA-MM-DD): ");
            String dataNascimentoStr = scanner.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = sdf.parse(dataNascimentoStr);
            pstmt.setDate(6, new java.sql.Date(parsedDate.getTime()));
            System.out.print("Sexo: ");
            pstmt.setString(7, scanner.nextLine());
            System.out.print("Clientela: ");
            pstmt.setString(8, scanner.nextLine());
            System.out.print("Município de Residência: ");
            pstmt.setString(9, scanner.nextLine());
            System.out.print("Vínculo Dependentes: ");
            pstmt.setString(10, scanner.nextLine());
            System.out.print("Forma de Filiação: ");
            pstmt.setString(11, scanner.nextLine());
            System.out.print("UF: ");
            pstmt.setString(12, scanner.nextLine());
            System.out.print("Quantidade de SM RMI: ");
            pstmt.setBigDecimal(13, scanner.nextBigDecimal());
            scanner.nextLine();
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Novo registro inserido com sucesso.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateBeneficio(Scanner scanner) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DriverManager.getConnection(dbUrl, user, pass);
            String sql = "UPDATE BENEFICIO SET qt_sm_rmi = ? WHERE id = ?";
            pstmt = conn.prepareStatement(sql);

            System.out.print("Novo valor da qt_sm_rmi: ");
            pstmt.setString(1, scanner.nextLine());
            System.out.print("ID do registro a ser atualizado: ");
            pstmt.setInt(2, scanner.nextInt());
            scanner.nextLine();

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Registro atualizado com sucesso.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteBeneficio(Scanner scanner) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DriverManager.getConnection(dbUrl, user, pass);
            String sql = "DELETE FROM BENEFICIO WHERE id = ?";
            pstmt = conn.prepareStatement(sql);

            System.out.print("ID do registro a ser excluído: ");
            pstmt.setInt(1, scanner.nextInt());
            scanner.nextLine();
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Registro excluído com sucesso.");
            } else {
                System.out.println("Nenhum registro encontrado para excluir com o ID fornecido.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}