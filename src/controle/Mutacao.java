package controle;

public class Mutacao {

	public static void aplicarMutacao(Cromossomo filho, int chanceDeMutacao, Analise analise) {
		int posMutacao = (int) (Math.random() * 20);
		int posMutacao2 = (int) (Math.random() * 20);
		int mutar = (int) Math.random() * 100;
		
		Gen trocarGen1 = new Gen(new Materia());

		Gen trocarGen2 = new Gen(new Materia());
		trocarGen1 = filho.getMatriz()[0][posMutacao];
		trocarGen2 = filho.getMatriz()[0][posMutacao2];
		
		if(mutar <= chanceDeMutacao){
			filho.setMutante(true);
			filho.getMatriz()[0][posMutacao] = trocarGen2;
			filho.getMatriz()[0][posMutacao2] = trocarGen1;
			analise.setContMutacao(analise.getContMutacao()+1);
		}
	}

}
