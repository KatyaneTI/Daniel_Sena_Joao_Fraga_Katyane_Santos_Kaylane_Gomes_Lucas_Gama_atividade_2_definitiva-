import java.util.ArrayList;
import java.util.List;

// Classe Tabela que atua como Observador
class Tabela implements Observador {
    @Override
    public void atualizar(List<String> dados) {
        System.out.println("Tabela: Dados atualizados:");
        imprimirTabelaHTML(dados);
    }

    // Método para imprimir os dados como uma tabela HTML
    private void imprimirTabelaHTML(List<String> dados) {
        System.out.println("<html>");
        System.out.println("<head>");
        System.out.println("<title>Tabela de Benefícios do INSS</title>");
        System.out.println("</head>");
        System.out.println("<body>");
        System.out.println("<h1>Tabela de Benefícios do INSS</h1>");
        System.out.println("<table border=\"1\">");
        System.out.println("<tr>");
        System.out.println("<th>Espécie</th>");
        System.out.println("<th>Despacho</th>");
        System.out.println("</tr>");
        for (String dado : dados) {
            String[] partes = dado.split(":");
            String especie = partes[0].trim();
            String despacho = partes[1].trim();
            System.out.println("<tr>");
            System.out.println("<td>" + especie + "</td>");
            System.out.println("<td>" + despacho + "</td>");
            System.out.println("</tr>");
        }
        System.out.println("</table>");
        System.out.println("</body>");
        System.out.println("</html>");
    }
}
