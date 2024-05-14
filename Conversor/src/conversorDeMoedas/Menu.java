package conversorDeMoedas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);
    static List<conversorDeMoedas.Currency> history = new ArrayList<>();

    public void showMenu () throws IOException {

        Scanner scan = new Scanner(System.in);
        int choice;
        conversorDeMoedas.Currency currency;

        do {
            System.out.println(menu());
            choice = scan.nextInt();

            switch (choice) {

                case 1:
                    currency = conversorDeMoedas.ConvertCurrency.
                            checkConvertionRate("USD", "BRL", scan);
                    System.out.println(currency);
                    history.add(currency);
                    break;

                case 2:
                    currency = conversorDeMoedas.ConvertCurrency.
                            checkConvertionRate("BRL", "USD", scan);
                    System.out.println(currency);
                    history.add(currency);
                    break;

                case 3:
                    currency = conversorDeMoedas.ConvertCurrency.
                            checkConvertionRate("USD", "ARS", scan);
                    System.out.println(currency);
                    history.add(currency);
                    break;

                case 4:
                    currency = conversorDeMoedas.ConvertCurrency.
                            checkConvertionRate("ARS", "USD", scan);
                    System.out.println(currency);
                    history.add(currency);
                    break;

                case 5:
                    currency = conversorDeMoedas.ConvertCurrency.
                            checkConvertionRate("USD", "COP", scan);
                    System.out.println(currency);
                    history.add(currency);
                    break;

                case 6:
                    currency = conversorDeMoedas.ConvertCurrency.
                            checkConvertionRate("COP", "USD", scan);
                    System.out.println(currency);
                    history.add(currency);
                    break;

                case 7:
                    System.out.println("Digite o código da moeda de origem em letras maiúsculas");
                    String originCurrency = scan.next();

                    System.out.println("Digite o código da moeda de destino em letras maiúsculas");
                    String convertedCurrency = scan.next();

                    currency = conversorDeMoedas.ConvertCurrency.
                            checkConvertionRate(originCurrency, convertedCurrency, scan);
                    System.out.println(currency);
                    history.add(currency);
                    break;

                case 8:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println( """
                             - ERRO -
                   
                            "Pressione 'Enter' para voltar ao menu principal! """);
                    scan.nextLine();
                    scan.nextLine();
            }

            System.out.println("Deseja continuar convertendo?");
            System.out.println("       s - SIM   |   n - Não");
            char exit =  scan.next().toLowerCase().charAt(0);
            if (exit == 'n'){
                break;
            }

        } while ( choice != 8);
        scan.close();
        saveHistoryFile();
    }

    private String menu(){
        return """                
                1) Dólar para Real Brasileiro
                2) Real Brasileiro para Dólar
                3) Dólar para Peso Argentino
                4) Peso Argentino para Dólar
                5) Dólar para Peso Colombiano
                6) Peso Colombiano para Dólar
                7) Digitar moeda de origem e destino que não tenha na lista
                8) Sair

                Escolha uma opção válida:
                """;
    }

    public static void saveHistoryFile () throws IOException {
        var fileSaver = new SaveFiles();
        fileSaver.saveJson(history);
    }
}
