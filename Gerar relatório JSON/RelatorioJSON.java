public class RelatorioJSON implements RelatorioStrategy {
    @Override
    public void gerarRelatorio() {
        static final String DB_URL = "jdbc:postgresql://bd.c90644aq4xwd.us-east-1.rds.amazonaws.com:5432/bd";
        static final String USER = "postgres";
        static final String PASS = "bancodedados";

        public static void main(String[] args) {
            Connection conn = null;
            Statement stmt = null;
            FileWriter jsonWriter = null;
            try {
                Class.forName("org.postgresql.Driver");

                System.out.println("Conectando ao banco de dados...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);

                jsonWriter = new FileWriter("relatorio.json");

                System.out.println("Criando declaração...");
                stmt = conn.createStatement();
                String sql;
                sql = "SELECT competencia_concessao, especie, cid, cid_especificacao, despacho, dt_nascimento, sexo, clientela, mun_resid, vinculo_dependentes, forma_filiacao, uf, qt_sm_rmi FROM beneficio";
                ResultSet rs = stmt.executeQuery(sql);

                JSONArray jsonArray = new JSONArray();
                while (rs.next()) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("Competência de Concessão", rs.getString("competencia_concessao"));
                    jsonObject.put("Espécie", rs.getString("especie"));
                    jsonObject.put("CID", rs.getString("cid"));
                    jsonObject.put("CID Especificação", rs.getString("cid_especificacao"));
                    jsonObject.put("Despacho", rs.getString("despacho"));
                    jsonObject.put("Data de Nascimento", rs.getString("dt_nascimento"));
                    jsonObject.put("Sexo", rs.getString("sexo"));
                    jsonObject.put("Clientela", rs.getString("clientela"));
                    jsonObject.put("Município de Residência", rs.getString("mun_resid"));
                    jsonObject.put("Vínculo Dependentes", rs.getString("vinculo_dependentes"));
                    jsonObject.put("Forma de Filiação", rs.getString("forma_filiacao"));
                    jsonObject.put("UF", rs.getString("uf"));
                    jsonObject.put("Quantidade de SM RMI", rs.getString("qt_sm_rmi"));
                    jsonArray.add(jsonObject);
                }
                jsonWriter.write(jsonArray.toJSONString());
                rs.close();
                stmt.close();
                conn.close();
                jsonWriter.close();
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
                    if (jsonWriter != null) jsonWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Fim do programa.");
        }
    }

}

