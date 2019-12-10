package controle;

public class Reinsercao {

	public static boolean verificarInsercao(Cromossomo cromossomo,
			Populacao populacao, Analise analise) {
		boolean reinserido = false;
		int pos = piorIndividuoDaPopulacao(populacao);
		if(populacao.getPopulacao().get(pos).getFitness() < cromossomo.getFitness()){
			populacao.getPopulacao().set(pos, cromossomo);
			analise.setContInsercao(analise.getContInsercao()+1);
			reinserido = true;
		}
		return reinserido;
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
