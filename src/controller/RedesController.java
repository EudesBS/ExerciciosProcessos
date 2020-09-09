package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	public RedesController(){
		super();
	}

	public String os() {

		String os = System.getProperty("os.name");
		return "Sistema operacional: " + os;
	}

	public void ip(String opSystem, String process) {

		if (opSystem.contains("Linux")) {
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();

				while (linha != null) {
					if(linha.contains("inet") != linha.contains("inet6")) {
						linha = linha.split("/")[0];
						System.out.print("Endereço IPv4: ");
						System.out.println(linha);
					}
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("O seus sitema Operacional não é um Linux, é um " + opSystem);
		}

	}
	
	public void ping (String opSystem, String process) {
		int contLinha = 0;
		double mediaMS = 0;
		
		if (opSystem.contains("Linux")) {
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				while (contLinha < 10) {
					
						if (linha.contains("time=")) {
							//System.out.print("Ping: ");
							linha = linha.substring(89, 94);
							linha = linha.replaceAll("=","");
							linha = linha.replaceAll(",", ".");
							mediaMS = mediaMS + Double.parseDouble(linha);
							//System.out.println(linha);
							contLinha++;
						
					}
					
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
				mediaMS = mediaMS / 10;
				System.out.println("Média dos pings em ms: " + mediaMS);
				
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		else {
			System.out.println("O seus sitema Operacional não é um Linux, é um " + opSystem);
		}
	}
}
