package controle;

public class DetectorDeClones {

	public static boolean detectarClone(Cromossomo cromossomo, Populacao populacao) {
		boolean clone = false;
		for(int x = 0; x < populacao.getPopulacao().size(); x++){
			int cont = 0;
			for(int i = 0; i < 1; i++){
				for(int j = 0; j < 20; j++){
					if(cromossomo.getMatriz()[i][j].getMateria().getNomeMateria().equals(populacao.getPopulacao().get(x).getMatriz()[i][j].getMateria().getNomeMateria())){
						cont++;
					}
				}
			}
			if(cont == 20){
				System.out.println("achei um clone");
				System.out.println(cromossomo.toString());
				System.out.println(populacao.getPopulacao().get(x).toString());
				return true;
			}
		}
		
		return clone;
	}

}
