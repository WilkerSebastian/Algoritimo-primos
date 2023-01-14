package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import operation.Fatorar;
import operation.Primo;

public class App {
    public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {

        Primo primo = new Primo();
        Fatorar fatorar = new Fatorar();
        
        byte opcao;

        while(true) {

            System.out.println("\n\n1) verificar primo");
            System.out.println("2) fatorar um número");
            System.out.println("3) SAIR");

            System.out.print("\nOpção: ");

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            opcao = Byte.parseByte(in.readLine());

            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                Runtime.getRuntime().exec("clear");
            }
        
            switch (opcao) {
                case 1:

                    primo.buscarPrimo();

                    break;
                case 2:
                	
                	fatorar.fatorando();

                    break;
                case 3:

                    return;
                default:

                    System.out.println("\nERRO INPUT!!!");

                    break;
            }
        }

    }

}
