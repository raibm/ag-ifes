package controle;

public class Cruzamento {

	public static Cromossomo[] cruzamentoPorPontoDeCorte(Cromossomo pai_1,
			Cromossomo pai_2) {
		
		int posCorte = (int) ((Math.random() * 18 ) + 1);

		Cromossomo filho_1 = new Cromossomo();
		Cromossomo filho_2 = new Cromossomo();

		Cromossomo filhos[] = new Cromossomo[2];
		
		Gen[][] matrizFilho_1 = new Gen[1][20];
		Gen[][] matrizFilho_2 = new Gen[1][20];

		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 20; j++) {
				if (j < posCorte) {
					matrizFilho_1[i][j] = pai_1.getMatriz()[i][j];
				} else {
					matrizFilho_1[i][j] = pai_2.getMatriz()[i][j];
				}
			}
		}
		
		filho_1.setMatriz(matrizFilho_1);
		
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 20; j++) {
				if (j > posCorte) {
					matrizFilho_2[i][j] = pai_1.getMatriz()[i][j];
				} else {
					matrizFilho_2[i][j] = pai_2.getMatriz()[i][j];
				}
			}
		}
		
		filho_2.setMatriz(matrizFilho_2);
		
		filhos[0] = filho_1;
		filhos[1] = filho_2;
		
		return filhos;
	}
	

	public static Cromossomo[] cruzamentoPorMascara(Cromossomo pai_1,
			Cromossomo pai_2) {
		
		int mascara[][] = new int[1][20];
	
		for(int i = 0; i < 1; i++){
			for(int j = 0; j < 20; j++){
				mascara[i][j] = (int) (Math.random() * 2 );
				System.out.println(mascara[i][j]);
			}
		}
		
		
		Cromossomo filho_1 = new Cromossomo();
		Cromossomo filho_2 = new Cromossomo();
		
		filho_1.setMatriz(pai_1.getMatriz().clone());
		filho_2.setMatriz(pai_2.getMatriz().clone());

		filho_1 = aplicarMascaraEmFilho(filho_1, pai_2, mascara);
		filho_2 = aplicarMascaraEmFilho(filho_2, pai_1, mascara);
		
		Cromossomo filhos[] = new Cromossomo[2];
		
		filhos[0] = filho_1;
		filhos[1] = filho_2;
		
		return filhos;
	}
	
	private static Cromossomo aplicarMascaraEmFilho(Cromossomo filho, Cromossomo pai, int mascara[][]){
		
		Cromossomo filhoFinal = new Cromossomo();
		
		filhoFinal.setMatriz(filho.getMatriz().clone());
		for(int i = 0; i < 1; i++){
			for(int j = 0; j < 20; j++){
				if(mascara[i][j] != 0){
					filhoFinal.getMatriz()[i][j] = pai.getMatriz()[i][j];
				}
			}
		}
		
		return filho;
	}
}
