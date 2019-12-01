package controle;

//import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {

		int tamanhoPopulacao = 5000;
		int totalCiclos = 200000;
		int fitnessAlvo = 37; // valor aleatório qq. PF atualizar após testes.
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
//		System.out.println("População: \n" + populacao);
//		System.out.println("Top 1 " + populacao.getTop1());

		// Fim da geração de população.

		/*
		 * Quanto maior a população, menor o fitnees do top 1. No entanto isso não é AG.
		 */

		// Início do AG
		
		do {
			Cromossomo pai1 = Selecao.torneio(populacao, qtdParticipantesTorneio);
			Cromossomo pai2 = Selecao.torneio(populacao, qtdParticipantesTorneio);
			Cromossomo filhos[] = Cruzamento.cruzamentoPorPontoDeCorte(pai1, pai2);
			
			for(int i = 0; i < filhos.length; i++){
				filhos[i].calcularFitness();
			}
			
			Mutacao.aplicarMutacao(filhos[0], chanceMutacao);
			Mutacao.aplicarMutacao(filhos[1], chanceMutacao);
			
//			Materia m = new Materia();
//			m.setMateria("MP");
//			Materia m2 = new Materia();
//			m2.setMateria("FTI");
//			Materia m3 = new Materia();
//			m3.setMateria("P1");
//			Materia m4 = new Materia();
//			m4.setMateria("FM");
//			Materia m5 = new Materia();
//			m5.setMateria("CE");
//			Materia m6 = new Materia();
//			m6.setMateria("OEC");	
//			
//			Gen matGen[][] = new Gen[1][20];
//			
//			Gen g1 = new Gen(m);
//			Gen g2 = new Gen(m2);
//			Gen g3 = new Gen(m3);
//			Gen g4 = new Gen(m4);
//			Gen g5 = new Gen(m5);
//			Gen g6 = new Gen(m6);
//			matGen[0][0] = g1;
//			matGen[0][1] = g1;
//			matGen[0][2] = g2;
//			matGen[0][3] = g2;
//			matGen[0][4] = g2;
//			matGen[0][5] = g2;
//			matGen[0][6] = g3;
//			matGen[0][7] = g3;
//			matGen[0][8] = g4;
//			matGen[0][9] = g4;
//			matGen[0][10] = g5;
//			matGen[0][11] = g6;
//			matGen[0][12] = g3;
//			matGen[0][13] = g3;
//			matGen[0][14] = g5;
//			matGen[0][15] = g5;
//			matGen[0][16] = g6;
//			matGen[0][17] = g6;
//			matGen[0][18] = g4;
//			matGen[0][19] = g4;
//
//			Cromossomo perfeito = new Cromossomo();
//			perfeito.setMatriz(matGen);
//			perfeito.calcularFitness();	
//			
			for(int i = 0; i < filhos.length; i++){
				filhos[i].calcularFitness();
			}
			
			for(int i = 0; i < filhos.length; i++){
				if(Avaliacao.validarFilho(filhos[i])){
					if(!DetectorDeClones.detectarClone(filhos[i], populacao)){
						Reinsercao.verificarInsercao(filhos[i], populacao);
						System.err.println("entrou");
						System.out.println(filhos[i]);
					}
				}
			}

			cont++;
		} while (cont < totalCiclos);
		
		// Fim do AG
		System.out.println("fim");
	}

}