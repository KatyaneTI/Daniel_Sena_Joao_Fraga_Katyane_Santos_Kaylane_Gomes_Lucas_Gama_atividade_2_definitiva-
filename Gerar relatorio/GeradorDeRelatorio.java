public class GeradorDeRelatorio {
    private RelatorioStrategy estrategia;

    public void setEstrategia(RelatorioStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public void gerarRelatorio() {
        if (estrategia != null) {
            estrategia.gerarRelatorio();
        } else {
        }
    }
}