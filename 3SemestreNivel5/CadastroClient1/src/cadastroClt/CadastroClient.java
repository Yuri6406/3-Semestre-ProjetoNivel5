package cadastroClt;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;

import model.Produto;


public class CadastroClient {

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

			// Enviar o comando L no canal de saída
			out.writeObject("L");

			// Receber a coleção de entidades no canal de entrada
			@SuppressWarnings("unchecked")
			ArrayList<Produto> produtos = (ArrayList<Produto>) in.readObject();

			// Apresentar o nome de cada entidade recebida
			System.out.println("Usuario conectado");
			for (Produto entidade : produtos) {
				System.out.println(entidade.getNome());
			}

			// Fechar a conexão
			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
