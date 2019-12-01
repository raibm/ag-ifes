package controle;

public class Selecao {

	public static Cromossomo torneio(Populacao populacao, int qtdParticipantes) {

		int indice = 1;

		Cromossomo vencedor = new Cromossomo();

		Cromossomo participantes[] = new Cromossomo[qtdParticipantes];

		for (int i = 0; i < qtdParticipantes; i++) {
			int pos = (int) (Math.random() * qtdParticipantes);
			participantes[i] = populacao.getCromo(pos);
		}

		vencedor = participantes[0];

		do {
			if (vencedor.getFitness() < participantes[indice].getFitness()) {
				vencedor = participantes[indice];
			}
			indice++;
		} while (indice < 20);

		return vencedor;
	}

}
