package principal;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import cadastroserver.CadastroThreadNova;
import controller.MovimentoJpaController;
import controller.PessoaJuridicaJpaController;
import controller.ProdutoJpaController;
import controller.UsuarioJpaController;

public class main {

	public static void main(String[] args) throws IOException {
		 int serverProt = 4321;
		
		ProdutoJpaController ctrl = new ProdutoJpaController();
		UsuarioJpaController ctrlUsu = new UsuarioJpaController();
		MovimentoJpaController ctrlMov = new MovimentoJpaController();
		 // Cria um socket de servidor que escuta na porta especificada por conexões recebidas
		PessoaJuridicaJpaController ctrlPessoa = new PessoaJuridicaJpaController();
		ServerSocket socket = new ServerSocket(serverProt);
		
		System.out.println("Servidor aguardando conexões...");


			// Loop infinito para aceitar conexões de clientes
			while (true) {
		         // Aguarda um cliente se conectar e aceita a conexão (chamada bloqueante)
	            Socket clienteSocket = socket.accept();
	            System.out.println("Cliente conectado: " + clienteSocket.getInetAddress());
				
				CadastroThreadNova cadThread = new CadastroThreadNova(ctrl, ctrlMov, socket.accept());
				cadThread.start();
				System.out.println("Aguardando nova conexão...");
			}
	}
}
