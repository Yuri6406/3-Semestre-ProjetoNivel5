package cadastroClt;

import java.io.ObjectInputStream;
import java.util.List;

import javax.swing.JTextArea;

import model.Produto;

public class ThreadClient extends Thread {

	private ObjectInputStream entrada;
	private JTextArea textArea;

	public ThreadClient(ObjectInputStream entrada, JTextArea textArea) {
		this.entrada = entrada;
		this.textArea = textArea;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Object objeto = entrada.readObject();
				if (objeto instanceof String) {
					// Para objetos do tipo String, adicione ao JTextArea
					textArea.append((String) objeto + "\n");
				} else if (objeto instanceof List<?>) {
					// Para objetos do tipo List, acrescente nome e quantidade
					List<Produto> lista = (List<Produto>) objeto;
					for (Object item : lista) {
						if (item instanceof Produto) {
							Produto produto = (Produto) item;
							textArea.append(
									"Nome: " + produto.getNome() + ", Quantidade: " + produto.getQuantidade() + "\n");
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
