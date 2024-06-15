package cadastroserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.MovimentoJpaController;
import controller.ProdutoJpaController;
import controller.UsuarioJpaController;
import model.Movimento;
import model.Produto;

public class CadastroThreadNova extends Thread {
	private ProdutoJpaController ctrlProd;
	private MovimentoJpaController ctrlMov;
	private UsuarioJpaController ctrlUsu;
	private Socket s1;

	public CadastroThreadNova(ProdutoJpaController ctrlProd, MovimentoJpaController ctrlMov, Socket s1) {
		super();
		this.ctrlProd = ctrlProd;
		this.ctrlMov = ctrlMov;
		this.s1 = s1;
	}

	public CadastroThreadNova(ProdutoJpaController ctrlProd, MovimentoJpaController ctrlMov,
			UsuarioJpaController ctrlUsu, Socket s1) {
		super();
		this.ctrlProd = ctrlProd;
		this.ctrlMov = ctrlMov;
		this.ctrlUsu = ctrlUsu;
		this.s1 = s1;
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

				// Receber o comando (E ou S) do cliente
				char opcao = (char) entrada.readObject();

				// Configurarando os valores
				int idMovimento = entrada.readInt();

				int quantidade = entrada.readInt();

				String tipo = entrada.readLine(); 

				float valorUnitario = entrada.readFloat();

				int idPessoaFisica = entrada.readInt();

				int idPessoaJuridica = entrada.readInt();
				
				int idProduto = entrada.readInt();

				int idUsuario = entrada.readInt();
				

				// Criar o objeto Movimento e configurá-lo
				Movimento movimento = new Movimento(idMovimento, quantidade, tipo, valorUnitario, idPessoaFisica, idPessoaJuridica, idProduto, idUsuario);
				movimento.setIdMovimento(idMovimento);
				movimento.setQuantidade(quantidade);
				movimento.setTipo(tipo);
				movimento.setValorUnitario(valorUnitario);
				movimento.setIdPessoaFisica(idPessoaFisica);
				movimento.setIdPessoaFisica(idPessoaJuridica);
				movimento.setIdProduto(idProduto);
				movimento.setIdUsuario(idUsuario);

				// Persistir o movimento
				ctrlMov.persist(movimento);// <<<-----

				// Atualizar a quantidade de produtos
				if (opcao == 'E') {
					ctrlProd.atualizarQuantidade(idProduto, quantidade);
				} else if (opcao == 'S') {
					ctrlProd.atualizarQuantidade(idProduto, quantidade);
				} else if (opcao == 'L') {
					// Utilize ctrl para retornar o conjunto de produtos através da saída
					ctrlProd = new ProdutoJpaController();
					ArrayList<Produto> listaProduto = ctrlProd.getListaProduto();
					saida.writeObject(listaProduto);
				}

				opcao = (char) entrada.readObject();
			}

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
