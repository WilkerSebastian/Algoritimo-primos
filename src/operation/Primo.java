package operation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Primo {

    public void buscarPrimo() throws NumberFormatException, IOException {

        ArrayList<Integer> primos = new ArrayList<Integer>();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Insira ultimo a ser procurado: ");
        int ultimo = Integer.parseInt(in.readLine());

        System.out.print("\n\n[");

        for (int i = 2; i <= ultimo; i++) {

            if (verificar(i, primos)) {

                primos.add(i);
                System.out.print(primos.get(primos.size() - 1) + ",");

            }

        }

        System.out.print("\b]");

    }

    public boolean verificar(int i, ArrayList<Integer> primos) {

        for (int j = 0; j < primos.size(); j++) {

            if (i % primos.get(j) == 0) {

                return false;

            }

        }

        return true;

    }

}
