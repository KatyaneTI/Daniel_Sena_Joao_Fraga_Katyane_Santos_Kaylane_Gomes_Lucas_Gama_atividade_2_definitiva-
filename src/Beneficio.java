package src;

import java.sql.*;
import java.sql.Date;

public class Beneficio {
    private int id;
    private String competenciaConcessao;
    private String especie;
    private String cid;
    private String cidEspecificacao;
    private String despacho;
    private Date dtNascimento;
    private String sexo;
    private String clientela;
    private String munResid;
    private String vinculoDependentes;
    private String formaFiliacao;
    private String uf;
    private double qtSmRmi;


    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompetenciaConcessao() {
        return competenciaConcessao;
    }

    public void setCompetenciaConcessao(String competenciaConcessao) {
        this.competenciaConcessao = competenciaConcessao;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCidEspecificacao() {
        return cidEspecificacao;
    }

    public void setCidEspecificacao(String cidEspecificacao) {
        this.cidEspecificacao = cidEspecificacao;
    }

    public String getDespacho() {
        return despacho;
    }

    public void setDespacho(String despacho) {
        this.despacho = despacho;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getClientela() {
        return clientela;
    }

    public void setClientela(String clientela) {
        this.clientela = clientela;
    }

    public String getMunResid() {
        return munResid;
    }

    public void setMunResid(String munResid) {
        this.munResid = munResid;
    }

    public String getVinculoDependentes() {
        return vinculoDependentes;
    }

    public void setVinculoDependentes(String vinculoDependentes) {
        this.vinculoDependentes = vinculoDependentes;
    }

    public String getFormaFiliacao() {
        return formaFiliacao;
    }

    public void setFormaFiliacao(String formaFiliacao) {
        this.formaFiliacao = formaFiliacao;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public double getQtSmRmi() {
        return qtSmRmi;
    }

    public void setQtSmRmi(double qtSmRmi) {
        this.qtSmRmi = qtSmRmi;
    }

private void visualizarBeneficios() {
    String url = "jdbc:postgresql://bd.c90644aq4xwd.us-east-1.rds.amazonaws.com:5432/bd";
    String user = "postgres";
    String password = "bancodedados";

    try (Connection conn = DriverManager.getConnection(url, user, password)) {
        String sql = "SELECT * FROM Beneficio";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String competenciaConcessao = rs.getString("competencia_concessao");
                    String especie = rs.getString("especie");
                    String cid = rs.getString("cid");
                    String cidEspecificacao = rs.getString("cid_especificacao");
                    String despacho = rs.getString("despacho");
                    Date dtNascimento = rs.getDate("dt_Nascimento");
                    String sexo = rs.getString("sexo");
                    String clientela = rs.getString("clientela");
                    String munResid = rs.getString("mun_Resid");
                    String vinculoDependentes = rs.getString("vinculo_dependentes");
                    String formaFiliacao = rs.getString("forma_filiacao");
                    String uf = rs.getString("uf");
                    double qtSmRmi = rs.getDouble("qt_sm_rmi");

                    System.out.println("Benefício " + id + ":");
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
                    System.out.println("Qt. SM RMI: " + qtSmRmi);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
 }
}