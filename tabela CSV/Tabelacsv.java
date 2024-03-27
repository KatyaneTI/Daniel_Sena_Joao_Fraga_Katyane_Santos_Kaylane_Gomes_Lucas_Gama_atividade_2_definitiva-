import java.sql.*;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Tabelacsv {
    private static final String url = "jdbc:postgresql://localhost/yourDatabaseName";
    private static final String user = "yourUsername";
    private static final String password = "yourPassword";

    public void readDatabase() {
        String query = "SELECT competencia_concessão, especie, cid, cid_especifação, despacho, dt_nascimento, sexo, clientela, mun_resid, vínculo_dependentes, forma_filiação, uf, qt_sm_rmi FROM beneficio";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            CSVWriter writer = new CSVWriter(new FileWriter("beneficio.csv"));

            while (rs.next()) {
                String[] data = new String[13];
                for (int i = 0; i < 13; i++) {
                    data[i] = rs.getString(i + 1);
                }
                writer.writeNext(data);
            }

            writer.close();

        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
