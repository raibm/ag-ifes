package controle;

public class DetectorDeClones {

	public static boolean detectarClone(Cromossomo cromossomo, Populacao populacao, Analise analise) {
		for (int x = 0; x < populacao.getPopulacao().size(); x++) {
			int cont = 0;
			
			System.out.println("cromo | popul");
			
			for (int i = 0; i < 1; i++) {
				for (int j = 0; j < 20; j++) {
					
					
					System.out.println(cromossomo.getMatriz()[i][j].getMateria().getNomeMateria()
							+"|"+populacao.getPopulacao().get(x).getMatriz()[i][j].getMateria().getNomeMateria());
					
					
					if (cromossomo.getMatriz()[i][j].getMateria().getNomeMateria()
							.equals(populacao.getPopulacao().get(x).getMatriz()[i][j].getMateria().getNomeMateria())) {
						cont++;
					}else {
						return false;
					}
				}
			}
			if (cont == 20) {
//				System.out.println("achei um clone");
//				System.out.println("Cromossomo clone:\n" + cromossomo.toString()+ "\n");
//				System.out.println(populacao.getPopulacao().get(x).toString());
				analise.setClones("Cromossomo clone:\n" + cromossomo.toString()+ "\n");
				analise.setClones("Original " + populacao.getPopulacao().get(x).toString() + "\n");
				analise.setContClone(analise.getContClone()+1);
				return true;
			}
			System.out.println();
		}
		return false;
	}

}
