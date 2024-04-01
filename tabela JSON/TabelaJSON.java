import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class TabelaJSON {

    private static final String URL = "jdbc:postgresql://localhost:5432/nomedobanco";
    private static final String USUARIO = "usuario";
    private static final String SENHA = "senha";

    private static final String SQL_QUERY = "SELECT competencia_concessão, especie, cid, cid_especifação, "
            + "despacho, dt_nascimento, sexo, clientela, mun_resid, vínculo_dependentes, forma_filiação, uf, qt_sm_rmi "
            + "FROM beneficio";

    private static final String ARQUIVO_JSON = "beneficios.json";

    public static void exportToJSON() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        FileWriter fileWriter = null;

        try {
            connection = DriverManager.getConnection(URL, USUARIO, SENHA);
            statement = connection.createStatement();

            resultSet = statement.executeQuery(SQL_QUERY);

            JSONArray jsonArray = new JSONArray();

            while (resultSet.next()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("competencia_concessão", resultSet.getString("competencia_concessão"));
                jsonObject.put("especie", resultSet.getString("especie"));
                jsonObject.put("cid", resultSet.getString("cid"));
                jsonObject.put("cid_especifação", resultSet.getString("cid_especifação"));
                jsonObject.put("despacho", resultSet.getString("despacho"));
                jsonObject.put("dt_nascimento", resultSet.getString("dt_nascimento"));
                jsonObject.put("sexo", resultSet.getString("sexo"));
                jsonObject.put("clientela", resultSet.getString("clientela"));
                jsonObject.put("mun_resid", resultSet.getString("mun_resid"));
                jsonObject.put("vínculo_dependentes", resultSet.getString("vínculo_dependentes"));
                jsonObject.put("forma_filiação", resultSet.getString("forma_filiação"));
                jsonObject.put("uf", resultSet.getString("uf"));
                jsonObject.put("qt_sm_rmi", resultSet.getString("qt_sm_rmi"));

                jsonArray.add(jsonObject);
            }

            fileWriter = new FileWriter(ARQUIVO_JSON);
            fileWriter.write(jsonArray.toJSONString());

            System.out.println("Dados exportados para " + ARQUIVO_JSON);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null)
                    fileWriter.close();
                if (resultSet != null)
                    resultSet.close();
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}