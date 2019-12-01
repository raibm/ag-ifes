package controle;

import java.util.ArrayList;

public class Avaliacao {

	public static boolean validarFilho(Cromossomo filho) {
		ArrayList<Gen> materias = Gen.materias(Util.materias_1);
		if(validarQtdAulas(filho, materias)){
			if(validarOrdemAulas(filho, materias)){
				return true;
			}
		}
		return false;
	}

	public static boolean validarQtdAulas(Cromossomo filho,
			ArrayList<Gen> materias) {

		for (int x = 0; x < materias.size(); x++) {
			int contadorAula = 0;
			for (int i = 0; i < 1; i++) {
				for (int j = 0; j < 20; j++) {
					
					String mat = filho.getMatriz()[i][j].getMateria().getNomeMateria();
					String mat2 = materias.get(x).getMateria().getNomeMateria();
					if (mat.equalsIgnoreCase(mat2)) {
						contadorAula++;
					}
				}
			}
			if (contadorAula > materias.get(x).getMateria().getTotalNumAulas()
					|| contadorAula < materias.get(x).getMateria()
							.getTotalNumAulas()) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean validarOrdemAulas(Cromossomo filho, ArrayList<Gen> materias ){
		for(int i = 0; i < 1; i++){
			boolean quinzenal = false;
			for(int j = 0; j < 20; j++){
				if(j == 0){
					if(filho.getMatriz()[i][j].getMateria().getNomeMateria() != filho.getMatriz()[i][j+1].getMateria().getNomeMateria()){
						 Materia materia = procurarMateriaPorNome(materias, filho.getMatriz()[i][j].getMateria().getNomeMateria());
						 Materia materia2 = procurarMateriaPorNome(materias, filho.getMatriz()[i][j+1].getMateria().getNomeMateria());
						 if(!(materia.getTotalNumAulas() % 2 != 0 && materia2.getTotalNumAulas() % 2 != 0)){
							 return false;
						 }
						 quinzenal = true;
					} else if (filho.getMatriz()[i][j].getMateria().getNomeMateria() == filho.getMatriz()[i][j+1].getMateria().getNomeMateria()){
						
					}else {
						return false;
					}
					j++;
				} else if ( j < 19){
					if( j == 2 || j == 6 || j == 10 || j == 14 || j == 18){
						if(filho.getMatriz()[i][j].getMateria().getNomeMateria() != filho.getMatriz()[i][j-1].getMateria().getNomeMateria()){
							if(filho.getMatriz()[i][j].getMateria().getNomeMateria() != filho.getMatriz()[i][j+1].getMateria().getNomeMateria()){
								Materia materia = procurarMateriaPorNome(materias, filho.getMatriz()[i][j].getMateria().getNomeMateria());
								 Materia materia2 = procurarMateriaPorNome(materias, filho.getMatriz()[i][j+1].getMateria().getNomeMateria());
								 if(!(materia.getTotalNumAulas() % 2 != 0 && materia2.getTotalNumAulas() % 2 != 0)){
									 return false;
								 }
								 if(quinzenal){
									 return false;
								 }
							}
						} else {
							return false;
						}
						j++;
					} else {
							if(filho.getMatriz()[i][j].getMateria().getNomeMateria() != filho.getMatriz()[i][j+1].getMateria().getNomeMateria()){
								Materia materia = procurarMateriaPorNome(materias, filho.getMatriz()[i][j].getMateria().getNomeMateria());
								 Materia materia2 = procurarMateriaPorNome(materias, filho.getMatriz()[i][j+1].getMateria().getNomeMateria());
								 if(!(materia.getTotalNumAulas() % 2 != 0 && materia2.getTotalNumAulas() % 2 != 0)){
									 return false;
								 }
								 if(quinzenal){
									 return false;
								 }
							}
						j++;
					}
				} 
			}
		}
		return true;
	}
	
	private static Materia procurarMateriaPorNome(ArrayList<Gen> materias, String nome){
		Materia materia = new Materia();
		for(int i = 0; i < materias.size(); i++){
			if(materias.get(i).getMateria().getNomeMateria().equals(nome)){
				materia = materias.get(i).getMateria();
			}
		}
		
		return materia;
	}
}
