package controle;

import java.util.ArrayList;

public class Cromossomo {
	private Gen[][] matriz;

	public Cromossomo() {
		this.matriz = new Gen[1][2];
	}

	public Cromossomo(Gen[][] matriz) {
		this.matriz = matriz;
	}

	public Gen[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(Gen[][] matriz) {
		this.matriz = matriz;
	}

	public static Cromossomo popularCromossomo() {
		ArrayList<Gen> materias = Gen.materias(Util.materias_1);
		Cromossomo cromossomo = new Cromossomo();
		Gen gen = null;
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 20; j++) {
				if (i == 0 && j == 0) {
					int pos = (int) (Math.random() * materias.size());
					gen = materias.get(pos);
					if (gen.getMateria().getNumAulas() % 2 == 0 && gen.getMateria().getNumAulas() > 0) {
						materias.get(pos).getMateria().setNumAulas(gen.getMateria().getNumAulas() - 2);
						cromossomo.matriz[i][j] = gen;
						j++;
						cromossomo.matriz[i][j] = gen;
					} else {
						cromossomo.matriz[i][j] = gen;
						j++;
						materias.get(pos).getMateria().setNumAulas(gen.getMateria().getNumAulas() - 1);
						gen = Gen.outraQuinzenal(gen, materias);
						cromossomo.matriz[i][j] = gen;
						materias.get(acharPosMateria(materias, gen)).getMateria()
								.setNumAulas(gen.getMateria().getNumAulas() - 1);
					}
					
				}
			}
		}
		return cromossomo;
	}

	private static int acharPosMateria(ArrayList<Gen> materias, Gen gene) {
		for (int i = 0; i < materias.size(); i++) {
			if (materias.get(i).getMateria().getNomeMateria().equals(gene.getMateria().getNomeMateria())) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}