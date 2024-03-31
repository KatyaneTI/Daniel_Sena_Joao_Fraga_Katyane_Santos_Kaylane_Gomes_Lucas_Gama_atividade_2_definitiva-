package facade;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    static final String DB_URL = "jdbc:postgresql://bd.c90644aq4xwd.us-east-1.rds.amazonaws.com:5432/bd";
    static final String USER = "postgres";
    static final String PASS = "bancodedados";

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        Facade facade = new Facade(DB_URL, USER, PASS);

        while (true) {
            facade.showMenu(scanner);
        }
    }
}