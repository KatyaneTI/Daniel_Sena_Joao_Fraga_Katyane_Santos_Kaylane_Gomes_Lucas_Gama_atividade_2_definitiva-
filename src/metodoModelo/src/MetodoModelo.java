import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.io.FileWriter;
import java.io.IOException;


abstract class RelatorioBeneficios {

    public final void gerarRelatorio(List<Beneficio> beneficios, String nomeArquivo) {
        List<String> dados = extrairDados(beneficios);
        String relatorioFormatado = formatarRelatorio(dados);
        gerarRelatorioFinal(relatorioFormatado, nomeArquivo);
    }

    protected abstract List<String> extrairDados(List<Beneficio> beneficios);

    protected String formatarRelatorio(List<String> dados) {
        
        StringBuilder relatorio = new StringBuilder();
        for (String dado : dados) {
            relatorio.append(dado).append("\n");
        }
        return relatorio.toString();
    }
    

    protected void gerarRelatorioFinal(String relatorioFormatado, String nomeArquivo) {
        //System.out.println(relatorioFormatado);
        //cria arquivo 
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            writer.write(relatorioFormatado);
            System.out.println("Relatório gerado com sucesso em: " + nomeArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class RelatorioJSONBeneficios extends RelatorioBeneficios {
  @Override
  protected List<String> extrairDados(List<Beneficio> beneficios) {
      List<String> dados = new ArrayList<>();
      for (Beneficio beneficio : beneficios) {
          String beneficioJSON = "{"
                  + "\"id_beneficio\": \"" + beneficio.getIdBeneficio() + "\", "
                  + "\"Ano\": \"" + beneficio.getAno() + "\", "
                  + "\"Data_nascimento\": \"" + beneficio.getDataNascimento() + "\", "
                  + "\"Sexo\": \"" + beneficio.getSexo() + "\", "
                  + "\"Municipio\": \"" + beneficio.getMunicipio() + "\", "
                  + "\"Estado\": \"" + beneficio.getEstado() + "\""
                  + "}";
          dados.add(beneficioJSON);
      }
      return dados;
  }
}

class RelatorioCSVBeneficios extends RelatorioBeneficios {
  @Override
  protected List<String> extrairDados(List<Beneficio> beneficios) {
      List<String> dados = new ArrayList<>();

      dados.add("id_beneficio, Ano, Data_nascimento, Sexo, Municipio, Estado"); //cabeçalho

      for (Beneficio beneficio : beneficios) {
          String linhaCSV = beneficio.getIdBeneficio() + ", "
                  + beneficio.getAno() + ", "
                  + beneficio.getDataNascimento() + ", "
                  + beneficio.getSexo() + ", "
                  + beneficio.getMunicipio() + ", "
                  + beneficio.getEstado();
          dados.add(linhaCSV);
      }
      return dados;
  }
}


class Beneficio {
  private int idBeneficio;
  private int ano;
  private Date dataNascimento;
  private String sexo;
  private String municipio;
  private String estado;

  
  public Beneficio(int idBeneficio, int ano, Date dataNascimento, String sexo, String municipio, String estado) {
      this.idBeneficio = idBeneficio;
      this.ano = ano;
      this.dataNascimento = dataNascimento;
      this.sexo = sexo;
      this.municipio = municipio;
      this.estado = estado;
  }

  public int getIdBeneficio() {
      return idBeneficio;
  }

  public void setIdBeneficio(int idBeneficio) {
      this.idBeneficio = idBeneficio;
  }

  public int getAno() {
      return ano;
  }

  public void setAno(int ano) {
      this.ano = ano;
  }

  public Date getDataNascimento() {
      return dataNascimento;
  }

  public void setDataNascimento(Date dataNascimento) {
      this.dataNascimento = dataNascimento;
  }

  public String getSexo() {
      return sexo;
  }

  public void setSexo(String sexo) {
      this.sexo = sexo;
  }

  public String getMunicipio() {
      return municipio;
  }

  public void setMunicipio(String municipio) {
      this.municipio = municipio;
  }

  public String getEstado() {
      return estado;
  }

  public void setEstado(String estado) {
      this.estado = estado;
  }
}


public class MetodoModelo {
    public static void main(String[] args) throws ClassNotFoundException {
        List<Beneficio> beneficios = obterBeneficiosDoBancoDeDados();

        RelatorioBeneficios relatorioJSON = new RelatorioJSONBeneficios();
        relatorioJSON.gerarRelatorio(beneficios, "relatorio.json"); // JSON

        RelatorioBeneficios relatorioCSV = new RelatorioCSVBeneficios();
        relatorioCSV.gerarRelatorio(beneficios, "relatorio.csv"); // CSV
    }

    private static List<Beneficio> obterBeneficiosDoBancoDeDados() throws ClassNotFoundException {
        List<Beneficio> beneficios = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            
            String url = "jdbc:postgresql://bd.c90644aq4xwd.us-east-1.rds.amazonaws.com:5432/";
            String usuario = "postgres";
            String senha = "bancodedados";

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, usuario, senha);

            String query = "SELECT * FROM beneficio.beneficio";
            statement = connection.prepareStatement(query);
            result = statement.executeQuery(); //execute

            while (result.next()) {
                
                int idBeneficio = result.getInt("id_beneficio");
                int ano = result.getInt("Ano");
                Date dataNascimento = result.getDate("Data_nascimento");
                String sexo = result.getString("Sexo");
                String municipio = result.getString("Municipio");
                String estado = result.getString("Estado");

                
                Beneficio beneficio = new Beneficio(idBeneficio, ano, dataNascimento, sexo, municipio, estado);
                beneficios.add(beneficio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) result.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return beneficios;
    }
}
