package cadastroClt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import model.Produto;

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

			// Encapsular a leitura do teclado
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				System.out.println("Opções: L - Listar, X - Finalizar, E - Entrada, S - Saída");
				String comando = reader.readLine();

				switch (comando.toUpperCase()) {
				case "L":
					// Enviar comando "L" para o servidor
					out.writeObject('L');
					break;
				// Enviar comando "E" para o servidor
				case "E":
					// Enviar comando "E" para o servidor
					out.writeObject('E');

					// Obter o ID da pessoa
					String idPes = reader.readLine();
					int idPessoa = Integer.parseInt(idPes);

					// Obter o ID do produto
					String idProd = reader.readLine();
					int idProduto = Integer.parseInt(idProd);

					// Obter a quantidade
					String quant = reader.readLine();
					int quantidade = Integer.parseInt(quant);

					// Obter o valor unitário
					String valorUni = reader.readLine();
					double valorUnitario = Double.parseDouble(valorUni);

					// Enviar esses dados para o servidor
					out.writeInt(idPessoa);
					out.writeInt(idProduto);
					out.writeInt(quantidade);
					out.writeDouble(valorUnitario);
					out.flush();
				case "S":
					// Enviar comando "E" para o servidor
					out.writeObject('S');

					// Obter o ID da pessoa
					 idPes = reader.readLine();
					idPessoa = Integer.parseInt(idPes);

					// Obter o ID do produto
					idProd = reader.readLine();
					idProduto = Integer.parseInt(idProd);

					// Obter a quantidade
					quant = reader.readLine();
					quantidade = Integer.parseInt(quant);

					// Obter o valor unitário
					valorUni = reader.readLine();
					valorUnitario = Double.parseDouble(valorUni);

					// Enviar esses dados para o servidor
					out.writeInt(idPessoa);
					out.writeInt(idProduto);
					out.writeInt(quantidade);
					out.writeDouble(valorUnitario);
					out.flush();
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
