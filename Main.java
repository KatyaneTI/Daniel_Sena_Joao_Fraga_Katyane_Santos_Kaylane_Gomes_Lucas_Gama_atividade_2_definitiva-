public class Main {
    public static void main(String[] args) {
        // Criando uma instância da Tabela
        Tabela tabela = new Tabela();

        // Criando uma instância da FonteDeDados
        FonteDeDados fonteDeDados = new FonteDeDados();

        // Registrando a tabela como observador na fonte de dados
        fonteDeDados.adicionarObservador(tabela);

        // Buscar dados no banco de dados e notificar os observadores em intervalos de tempo
        fonteDeDados.buscarDadosPeriodicamente(10); // Atualiza a cada 10 segundos
    }
}
