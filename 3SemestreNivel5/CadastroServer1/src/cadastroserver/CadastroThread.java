package cadastroserver;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import controller.ProdutoJpaController;
import controller.UsuarioJpaController;
import model.Produto;
import model.Usuario;

public class CadastroThread extends Thread {
	 public  ProdutoJpaController ctrl;
	 public final  UsuarioJpaController ctrlUsu;
	 public final  Socket s1;

	public CadastroThread(ProdutoJpaController ctrl, UsuarioJpaController ctrlUsu, Socket socket) {
		this.ctrl = ctrl;
		this.ctrlUsu = ctrlUsu;
		this.s1 = socket;
	}

	@Override
	public void run() {

		try {
			// Encapsule os canais de entrada e saída do Socket
			ObjectInputStream entrada = new ObjectInputStream(s1.getInputStream());
			ObjectOutputStream saida = new ObjectOutputStream(s1.getOutputStream());

			// Obtenha o login e a senha a partir da entrada
			String login = (String) entrada.readObject();
			String senha = (String) entrada.readObject();

			// Utilize ctrlUsu para verificar o login
			boolean usuarioValido = ctrlUsu.findUsuario(login, senha);

			// Loop de resposta
			while (usuarioValido) {
				// Obtenha o comando a partir da entrada
				String comando = (String) entrada.readObject();

				if (comando.equals("L")) {
					// Utilize ctrl para retornar o conjunto de produtos através da saída
					ctrl = new ProdutoJpaController();
					ArrayList<Produto> listaProduto = ctrl.getListaProduto();
					saida.writeObject(listaProduto);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
