package application;

import java.util.Date;

public class Timer extends Thread {

		private boolean runner;

		@Override
		public void start() {
			
			this.runner = true;
		
			super.start();
			
		}
		
		@Override
		public void run() {
			
			byte index = 0;
			
			long dataAtual = new Date().getTime();
		
			do {
	
				try {
					
					Thread.sleep(500);
					
					if (System.getProperty("os.name").contains("Windows")) {
		                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		            }
		            else {
		                Runtime.getRuntime().exec("clear");
		            }
				
				} catch(Exception e) {
					
					e.printStackTrace();
					
				}
				
				System.out.println("\nprocesso iniciado!");
				
				index = index >= 4 ? 0 : index; 
				

					switch (index) {
					case 0:
						
						System.out.print("carregando");
						
						break;
	
					case 1:
						
						System.out.print("carregando.");
						
						break;
					case 2:
						
						System.out.print("carregando..");
						
						break;
					case 3:
						
						System.out.print("carregando...");
						
						break;
					}
					
					index++;
				
				
			}while(this.runner);
			
			long dataFinal = (new Date().getTime() - dataAtual);
			
			System.out.println("\nprocesso finalizado em " + (dataFinal >= 1000 ? dataFinal / 1000 : dataFinal) + (dataFinal >= 1000 ? " segundos" : " milissegundos"));
			
		}
		
		public boolean isRunner() {
			return runner;
		}

		public void setRunner(boolean runner) {
			this.runner = runner;
		}
	
}