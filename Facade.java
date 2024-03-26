import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Facade {

    public void iniciarProcesso() {
        gerarEstatisticas();
        gerarRelatorioJSON();
        gerarRelatorioCSV();
        visualizarBeneficios();
    }

    private void gerarEstatisticas() {
        Estatistica estatistica = new Estatistica();
        estatistica.gerarEstatistica();
    }

    private void gerarRelatorioJSON() {
        Relatorio relatorio = new Relatorio();
        relatorio.setTipo("json");
        relatorio.gerarRelatorio();
    }

    private void gerarRelatorioCSV() {
        Relatorio relatorio = new Relatorio();
        relatorio.setTipo("csv");
        relatorio.gerarRelatorio();
    }

    private void visualizarBeneficios() {
        Beneficio beneficio = new Beneficio();
        beneficio.visualizarBeneficios();
    }

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.iniciarProcesso();
    }
}