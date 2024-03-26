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
}