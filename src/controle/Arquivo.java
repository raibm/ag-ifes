package controle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {

	public static void gravar(String nome, String conteudo) {
		FileWriter fw;
		BufferedWriter bw;
		try {
			fw = new FileWriter(nome);
			bw = new BufferedWriter(fw);
			bw.write(conteudo);
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Erro ao salvar arquivo!");
		}
	}
}
