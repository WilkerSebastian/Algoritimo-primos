package operation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import application.Timer;

public class Fatorar {
	
	public void fatorando() throws InterruptedException, NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("\nInsira o número a ser fatorado: ");
        long num = Long.parseLong(in.readLine());
        
        Timer timer = new Timer();
        
        timer.start();
        
        HashMap<Integer, Integer> fatorados = fatorar(num);
        
        timer.setRunner(false);

        Thread.sleep(500);
        timer.join();
        
        System.out.print("\n" + num + " = ");

        int index = 0;
        
        for(int fator : fatorados.keySet()) {
        	
        	index++;
        	
        	System.out.print(fator + "^" + fatorados.get(fator) + (index < fatorados.size() ? " * ":""));
        	
        }
		
	}
	
	public HashMap<Integer, Integer> fatorar(long number) {
		
        HashMap<Integer, Integer> fatorados = new HashMap<Integer, Integer>();
        
        for (int i = 2; i <= number; i++) {
        	
            if (fatorados.containsKey(i)) {
            	
            	fatorados.put(i, fatorados.get(i) + 1);
                
            } else {
            	
                while (number % i == 0) {
                	
                    if (fatorados.containsKey(i)) {
                    	
                    	fatorados.put(i, fatorados.get(i) + 1);
                        
                    } else {
                    	
                    	fatorados.put(i, 1);
                        
                    }
                    
                    number = number / i;
                    
                }
            }
        }
        return fatorados;
    }
	
}