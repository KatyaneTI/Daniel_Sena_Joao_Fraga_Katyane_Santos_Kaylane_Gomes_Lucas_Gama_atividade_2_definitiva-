import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Classe FonteDeDados que é a Fonte de Eventos (Subject)
class FonteDeDados {
    private List<Observador> observadores = new ArrayList<>();
    private static final String URL = "jdbc:postgresql://localhost:5432/INSS";
    private static final String USER = "postgre";
    private static final String PASSWORD = "bancodedados";

    // Método para adicionar observadores
    public void adicionarObservador(Observador observador) {
        observadores.add(observador);
    }

    // Método para remover observadores
    public void removerObservador(Observador observador) {
        observadores.remove(observador);
    }

    // Método que busca os dados no banco de dados e notifica os observadores
    public void buscarDadosNoBanco() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM Beneficios";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                List<String> dados = new ArrayList<>();
                while (resultSet.next()) {
                    String dado = resultSet.getString("Especie") + ": " + resultSet.getString("Despacho");
                    dados.add(dado);
                }
                // Notificar todos os observadores
                for (Observador observador : observadores) {
                    observador.atualizar(dados);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar dados no banco em intervalos de tempo
    public void buscarDadosPeriodicamente(int intervaloSegundos) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            buscarDadosNoBanco();
        }, 0, intervaloSegundos, TimeUnit.SECONDS);
    }
}
