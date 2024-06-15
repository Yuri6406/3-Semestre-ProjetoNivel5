package cadastroClt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;


public class CadastroClientV2 {

	public static void main(String[] args) throws ClassNotFoundException {

		try {
			// Instanciar um Socket apontando para localhost na porta 4321
			Socket socket = new Socket("localhost", 4321);
			// Encapsular os canais de entrada e saída do Socket
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

			// Escrever o login e a senha na saída
			String login = "op1";
			String senha = "op1";
			out.writeObject(login);
			out.writeObject(senha);

			//Encapsular a leitura do teclado
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			
			while (true) {
			    System.out.println("Opções: L - Listar, X - Finalizar, E - Entrada, S - Saída");
			    String comando = reader.readLine();

			    switch (comando.toUpperCase()) {
			        case "L":
			            // Enviar comando "L" para o servidor
			            out.writeObject("L");
			            break;
			        case "E":
			        	System.out.println("Entrada");
			        case "S":
			            // Enviar comando "E" ou "S" para o servidor
			            out.writeObject(comando);
			            // Obter Id da pessoa, Id do produto, quantidade e valor unitário via teclado
			            Scanner scanner = new Scanner(System.in);

			            // Obter o ID da pessoa
			            System.out.print("Digite o ID da pessoa: ");
			            int idPessoa = scanner.nextInt();

			            // Obter o ID do produto
			            System.out.print("Digite o ID do produto: ");
			            int idProduto = scanner.nextInt();

			            // Obter a quantidade
			            System.out.print("Digite a quantidade: ");
			            int quantidade = scanner.nextInt();

			            // Obter o valor unitário
			            System.out.print("Digite o valor unitário: ");
			            double valorUnitario = scanner.nextDouble();
			            
			            // Enviar esses dados para o servidor
			            out.writeInt(idPessoa);
			            out.writeInt(idProduto);
			            out.writeInt(quantidade);
			            out.writeDouble(valorUnitario);
			            out.flush();
			            // Repetir até que o comando "X" seja escolhido
			            break;
			        case "X":
			            // Enviar comando "X" para o servidor e finalizar
			            out.writeObject("X");
			            socket.close();
			            return;
			        default:
			            System.out.println("Comando inválido. Tente novamente.");
			    }
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
