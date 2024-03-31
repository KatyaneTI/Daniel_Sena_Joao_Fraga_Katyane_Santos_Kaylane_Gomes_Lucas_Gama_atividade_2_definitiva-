package facade;

public class Relatorio {
    private int id;
    private String tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void gerarRelatorio() {
        if (tipo.equalsIgnoreCase("csv")) {
            gerarRelatorioCSV();
        } else if (tipo.equalsIgnoreCase("json")) {
            gerarRelatorioJSON();
        } else {
            System.out.println("Tipo de relatório não suportado");
        }
    }

    private void gerarRelatorioCSV() {
        Tabelacsv minhaTabelacsv = new Tabelacsv();
        System.out.println("Gerando relatório no formato CSV");
    }

    private void gerarRelatorioJSON() {
        TabelaJSON minhaTabelajson = new TabelaJSON();
        System.out.println("Gerando relatório no formato JSON");
    }
}
