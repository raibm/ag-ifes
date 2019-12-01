package controle;

public class Reinsercao {

	public static void verificarInsercao(Cromossomo cromossomo,
			Populacao populacao) {
		int pos = piorIndividuoDaPopulacao(populacao);
		if(populacao.getPopulacao().get(pos).getFitness() < cromossomo.getFitness()){
			populacao.getPopulacao().set(pos, cromossomo);
		}
	}
	
	private static int piorIndividuoDaPopulacao(Populacao populacao){
		Cromossomo piorIndividuo = populacao.getPopulacao().get(0);
		int pos = 0;
		for(int i = 1; i < populacao.getPopulacao().size(); i++){
			if(piorIndividuo.getFitness() > populacao.getPopulacao().get(i).getFitness()){
				piorIndividuo = populacao.getPopulacao().get(i);
				pos = i;
			}
		}
		return pos;
	}

}
