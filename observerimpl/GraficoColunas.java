import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.util.List;

// Classe GráficoColunas que atua como Observador
class GraficoColunas implements Observador {

    private CategoryChart chart;

    public GraficoColunas() {
        // Inicializar o gráfico de colunas
        chart = new CategoryChartBuilder().width(800).height(600).title("Gráfico de Colunas").xAxisTitle("Espécie").yAxisTitle("Despacho").build();

        // Customizar o estilo do gráfico
        chart.getStyler().setLegendPosition(Styler.LegendPosition.OutsideE);
        chart.getStyler().setHasAnnotations(true);
    }

    @Override
    public void atualizar(List<String> dados) {
        // Limpar séries existentes
        chart.getSeriesMap().clear();

        // Adicionar os dados ao gráfico
        for (String dado : dados) {
            String[] partes = dado.split(":");
            String especie = partes[0].trim();
            String despacho = partes[1].trim();
            chart.addSeries(especie, List.of(especie), List.of(despacho));
        }

        // Exibir o gráfico
        new SwingWrapper<>(chart).displayChart();
    }
}
