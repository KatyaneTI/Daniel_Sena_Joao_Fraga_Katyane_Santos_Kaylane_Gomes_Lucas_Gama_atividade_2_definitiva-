package facade;

import java.text.ParseException;
import java.util.Scanner;


public class Facade {
    private Beneficio beneficio;

    public Facade(String dbUrl, String user, String pass) {
        this.beneficio = new Beneficio(dbUrl, user, pass);
    }

    public void showMenu(Scanner scanner) throws ParseException {
        System.out.println("Escolha a operação que deseja realizar:");
        System.out.println("1 - Ler registros (select)");
        System.out.println("2 - Criar registro (insert)");
        System.out.println("3 - Atualizar registro (update)");
        System.out.println("4 - Excluir registro (delete)");
        System.out.println("5 - Encerrar programa");
        System.out.print("Digite o número da operação desejada: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                beneficio.readBeneficio();
                break;
            case 2:
                beneficio.createBeneficio(scanner);
                break;
            case 3:
                beneficio.updateBeneficio(scanner);
                break;
            case 4:
                beneficio.deleteBeneficio(scanner);
                break;
            case 5:
                System.out.println("Encerrando o programa...");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Opção inválida.");
        }
    }
}