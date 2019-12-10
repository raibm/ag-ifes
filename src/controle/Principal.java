package controle;

//import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {

		Analise analise = new Analise();
		int tamanhoPopulacao = 50;
		int totalCiclos = 500;
		// int fitnessAlvo = 37; // valor aleat�rio qq. PF atualizar ap�s testes.
		int cont = 0;
		int qtdParticipantesTorneio = 20;
		int chanceMutacao = 1;

		// ArrayList<Cromossomo> populacao = new ArrayList<Cromossomo>();
		Populacao populacao = new Populacao();

		// System.out.println("adcionando cromossomos a populacao");
		for (int i = 0; i < tamanhoPopulacao; i++) {
			populacao.addCromo(Cromossomo.popularCromossomo());
			// System.out.println("Adcionando "+populacao.getCromo(i)+"\n");
		}
		populacao.encontrarTop1();
		analise.setTop1(populacao.getTop1().toString() + "\n");

		// System.out.println("Popula��o: \n" + populacao);
		// System.out.println("Top 1 " + populacao.getTop1());

		// Fim da gera��o de popula��o.

		/*
		 * Quanto maior a popula��o, menor o fitnees do top 1. No entanto isso n�o � AG.
		 */

		// In�cio do AG

		do {
			Cromossomo pai1 = Selecao.torneio(populacao, qtdParticipantesTorneio);
			Cromossomo pai2 = Selecao.torneio(populacao, qtdParticipantesTorneio);
			Cromossomo filhos[] = Cruzamento.cruzamentoPorPontoDeCorte(pai1, pai2);
			
			for (int i = 0; i < filhos.length; i++) {
				filhos[i].calcularFitness();
				System.err.println("Cruzamento!\n"+filhos[i]);
			}
			analise.setFilhos("pai1  " + pai1.toString() + "\n");
			analise.setFilhos("pai2 " + pai2.toString() + "\n");
			analise.setFilhos("filho1 " + filhos[0].toString() + "\n");
			analise.setFilhos("filho2 " + filhos[1].toString() + "\n");

			Mutacao.aplicarMutacao(filhos[0], chanceMutacao, analise);
			if (filhos[0].isMutante()) {
				filhos[0].calcularFitness();
				analise.setMutacoes("Mutação filho1: " + filhos[0].toString() + "\n");
			}

			Mutacao.aplicarMutacao(filhos[1], chanceMutacao, analise);
			if (filhos[1].isMutante()) {
				filhos[1].calcularFitness();
				analise.setMutacoes("Mutação filho2: " + filhos[1].toString() + "\n");
			}

			// Cromossomo cromoPerfeito = criarCromoPerfeito();

			for (int i = 0; i < filhos.length; i++) {
				if (Avaliacao.validarFilho(filhos[i])) {
					if (!DetectorDeClones.detectarClone(filhos[i], populacao, analise)) {
						if (Reinsercao.verificarInsercao(filhos[i], populacao, analise)) {
							if (populacao.getTop1().getFitness() < filhos[i].getFitness()) {
								populacao.setTop1(filhos[i]);
								analise.setContTop1(analise.getContTop1() + 1);
								analise.setTop1("Novo top1:\n" + analise.getContTop1() + 1 + "\n");
							}
							if (filhos[i].isMutante())
								analise.setContMutInsert(analise.getContMutInsert() + 1);
						}
					}
				}
			}
			cont++;
			analise.setCiclo(cont + 1);
		//	System.out.println(cont);
		} while (cont < totalCiclos);

		// System.out.println(analise.getFilhos());

		controle.Arquivo.gravar("./analise/População.txt", "População:\n" + populacao.toString());

		controle.Arquivo.gravar("./analise/Clones.txt",
				"Clones:\n" + analise.getClones() + "\nTotal de clones: " + analise.getContClone());
	//	System.out.println("Clones:\n" + analise.getClones() + "\n" + analise.getContClone());

		controle.Arquivo.gravar("./analise/Mutações.txt", "Mutações:\n" + analise.getMutacoes() + "\n"
				+ analise.getContMutacao() + "|Mutações inseridas: " + analise.getContMutInsert());
	//	System.out.println("Mutações:\n" + analise.getMutacoes() + "\nTotal de mutações: " + analise.getContMutacao()
//				+ "|Mutações inseridas: " + analise.getContMutInsert());

		controle.Arquivo.gravar("./analise/Filhos.txt", "Filhos:\n" + analise.getFilhos());
//		System.out.println("Filhos:\n" + analise.getFilhos());

		controle.Arquivo.gravar("./analise/Top1.txt", "Top1:\n" + analise.getTop1());
//		System.out.println("Top1:\n" + analise.getTop1());

		// Fim do AG
		System.out.println("fim");

	}

	private static Cromossomo criarCromoPerfeito() {
		Materia m = new Materia();
		m.setMateria("MP");
		Materia m2 = new Materia();
		m2.setMateria("FTI");
		Materia m3 = new Materia();
		m3.setMateria("P1");
		Materia m4 = new Materia();
		m4.setMateria("FM");
		Materia m5 = new Materia();
		m5.setMateria("CE");
		Materia m6 = new Materia();
		m6.setMateria("OEC");

		Gen matGen[][] = new Gen[1][20];

		Gen g1 = new Gen(m);
		Gen g2 = new Gen(m2);
		Gen g3 = new Gen(m3);
		Gen g4 = new Gen(m4);
		Gen g5 = new Gen(m5);
		Gen g6 = new Gen(m6);
		matGen[0][0] = g1;
		matGen[0][1] = g1;
		matGen[0][2] = g2;
		matGen[0][3] = g2;
		matGen[0][4] = g2;
		matGen[0][5] = g2;
		matGen[0][6] = g3;
		matGen[0][7] = g3;
		matGen[0][8] = g4;
		matGen[0][9] = g4;
		matGen[0][10] = g5;
		matGen[0][11] = g6;
		matGen[0][12] = g3;
		matGen[0][13] = g3;
		matGen[0][14] = g5;
		matGen[0][15] = g5;
		matGen[0][16] = g6;
		matGen[0][17] = g6;
		matGen[0][18] = g4;
		matGen[0][19] = g4;

		Cromossomo perfeito = new Cromossomo();
		perfeito.setMatriz(matGen);
		perfeito.calcularFitness();
		return perfeito;
	}

}