package src;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
    	String[] opcoes = {"Competência concessão", "Espécie", "CID", "CID", "Despacho", "Dt Nascimento", "Sexo.", "Clientela", "Mun Resid", "Vínculo dependentes", "Forma Filiação", "UF", "Qt SM RMI"};
        String Coluna = "UF";
        String valor = "Alagoas";
        Tabela requisicao = new Tabela(Coluna, valor);
        
        
    }
}