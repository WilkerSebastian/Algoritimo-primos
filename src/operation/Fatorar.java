package operation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import application.Timer;

public class Fatorar {
	
	public void fatorando() throws InterruptedException, NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("\nInsira o número a ser fatorado: ");
        int num = Integer.parseInt(in.readLine());
        
        Timer timer = new Timer();
        
        timer.start();

        ArrayList<Integer> primos = getPrimos(num);
        ArrayList<ArrayList<Integer>> fatorados = fatorar(num, primos);
        
        timer.setRunner(false);

        Thread.sleep(500);
        timer.join();
        
        System.out.print("\n" + num + " = ");

        for (int i = 0; i < fatorados.size(); i++) {
        	
            for (int j = 0; j < 2; j++) {
                System.out.print(fatorados.get(i).get(j) + (j != 1 ? "^" : ""));
            }
            System.out.print(i == fatorados.size() - 1? "" : " * ");
            
        }
		
	}
	
	public ArrayList<ArrayList<Integer>> fatorar(int num, ArrayList<Integer> primos) {
		
		ArrayList<Integer> divisores = new ArrayList<Integer>();
		ArrayList<Integer> expoentes = new ArrayList<Integer>();
		
		for (int i = 0; i < primos.size();i++) {
			
			i = i == 1 ? 2 : i;
			
			if (num % primos.get(i) == 0) {
		    	
		        num /= primos.get(i);
		        
		        int index = divisores.size() > 0 ? divisores.indexOf(primos.get(i)) : -1;
		        
		        if (index != -1) {
		        	
		            expoentes.set(index, expoentes.get(index) + 1);
		            
		        } else {
		        	
		            divisores.add(primos.get(i));
		            expoentes.add(1);
		            
		        }
		    }
		}
	        
		ArrayList<ArrayList<Integer>> fatorado = new ArrayList<ArrayList<Integer>>();
	    
	    for(int j = 0;j < divisores.size();j++) {
	    	
	    	ArrayList<Integer> temp = new ArrayList<Integer>();
	    	temp.add(divisores.get(j));
	    	temp.add(expoentes.get(j));
	    	
	    	fatorado.add(temp);
	    	
	    }
	    
	    return fatorado;
		
	}
	
	public ArrayList<Integer> getPrimos(int num) {
		
		Primo primo = new Primo();
		
		ArrayList<Integer> primos = new ArrayList<Integer>();
		
		for(int i = 2;i <= num;i++) {
			
			if(primo.verificar(i, primos)) {
				
				primos.add(i);
				
			}
			
		}
		
		return primos;
	}
	
}