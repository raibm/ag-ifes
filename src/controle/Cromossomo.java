package controle;

import java.util.ArrayList;

public class Cromossomo {
	private Gen[][] matriz;
	private double fitness = Double.MIN_VALUE;

	public Cromossomo() {
		this.matriz = new Gen[1][20];
	}

	public Cromossomo(Gen[][] matriz) {
		this.matriz = matriz;
		calcularFitness();
	}

	public Gen[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(Gen[][] matriz) {
		this.matriz = matriz;
	}

	public double getFitness() {
		return fitness;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	public static Cromossomo popularCromossomo() {
		ArrayList<Gen> materias = Gen.materias(Util.materias_1);
		
		for(int i = 0; i < 6; i++){
			materias.get(i).getMateria().popularPreferencia();
		}
		
		materias.get(0).getMateria().popularPreferencia();
		Cromossomo cromossomo = new Cromossomo();
		Gen gen = null;

		for (int i = 0; i < 1; i++) {
			// System.out.println("populando cromossomo.");
			for (int j = 0; j < 20; j++) {
				// System.out.print("inserindo gen: " + j);
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
				} else {
					int pos;
					do {
						pos = (int) (Math.random() * materias.size());
						gen = materias.get(pos);
						// System.err.println("validando quinzenal "+gen);
					} while (validarMateriaNaoQuinzenal(cromossomo, gen, j) && gen.getMateria().getNumAulas() == 0);

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
				// System.out.println(" Gen: " + gen + "\n");
			}
			// System.out.println("Cromossomo populado.\n"+cromossomo);
		}
		cromossomo.calcularFitness();
		return cromossomo;
	}

	private static boolean validarMateriaNaoQuinzenal(Cromossomo cromossomo, Gen gen, int posJ) {
		for (int i = 0; i < 1; i++) {
			for (int j = (posJ - 2); j < posJ; j++) {
				if (cromossomo.matriz[i][j].getMateria().getNomeMateria().equals(gen.getMateria().getNomeMateria())) {
					return true;
				}					
			}
		}
		return false;
	}

	private static int acharPosMateria(ArrayList<Gen> materias, Gen gene) {
		for (int i = 0; i < materias.size(); i++) {
			if (materias.get(i).getMateria().getNomeMateria().equals(gene.getMateria().getNomeMateria())) {
				return i;
			}
		}
		return -1;
	}

	public void calcularFitness() {
		this.fitness = 0;
		for (int i = 0; i < getMatriz().length; i++) {
			for (int j = 0; j < getMatriz()[0].length; j++) {
				this.fitness += getMatriz()[i][j].getMateria().getMatPreferencia()[i][j];
			}
		}
	}

	public String toString_old() {
		String janela = "Cromossomo:\n";
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 20; j++) {
				janela += this.matriz[i][j].getMateria().getNomeMateria() + ", " + this.matriz[i][j].getMateria().getMatPreferencia()[i][j]
						+ "\n";
			}
			janela += "\n";
		}
		return janela;
	}

	@Override
	public String toString() {
		String janela = "Cromossomo:\n", linha1 = "", linha2 = "", linha3 = "", linha4 = "";
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 20; j++) {
				linha1 += "|" + this.matriz[i][j].getMateria().getNomeMateria() + ", "
						+ this.matriz[i][j].getMateria().getMatPreferencia()[i][j] + "|";
				j++;
				linha2 += "|" + this.matriz[i][j].getMateria().getNomeMateria() + ", "
						+ this.matriz[i][j].getMateria().getMatPreferencia()[i][j] + "|";
				j++;
				linha3 += "|" + this.matriz[i][j].getMateria().getNomeMateria() + ", "
						+ this.matriz[i][j].getMateria().getMatPreferencia()[i][j] + "|";
				j++;
				linha4 += "|" + this.matriz[i][j].getMateria().getNomeMateria() + ", "
						+ this.matriz[i][j].getMateria().getMatPreferencia()[i][j] + "|";
			}
			janela += linha1 + "\n" + linha2 + "\n" + linha3 + "\n" + linha4 + "\n";
			janela += "Fitness: " + getFitness()+"\n";
		}
		return janela;
	}

}