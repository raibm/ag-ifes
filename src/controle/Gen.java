package controle;

import java.util.ArrayList;

public class Gen {
	private Materia materia;

	public Gen(Materia materia) {
		this.materia = materia;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public static ArrayList<Gen> materias(String[] materia) {
		ArrayList<Gen> genes = new ArrayList<Gen>();
		for (int i = 0; i < materia.length; i++) {
			String valor = materia[i];
			Gen gene = new Gen(new Materia(valor));
			genes.add(gene);
		}
		return genes;
	}

	public static Gen criarPrimeiroGenAleatorioPrimeiroPeriodo(ArrayList<Gen> materias) {
		System.out.println((int) (Math.random() * materias.size()));
		return materias.get((int) (Math.random() * materias.size()));
	}

	public static Gen outraQuinzenal(Gen gene, ArrayList<Gen> materias) {
		int i = 0;
		Gen gen = null;
		do {
			gen = materias.get(i);
			if (gen.getMateria().getNumAulas() % 2 == 1
					&& !gen.getMateria().getNomeMateria().equals(gene.getMateria().getNomeMateria())) {
				return gen;
			}
			i++;
		} while (i < materias.size());
		return gen;
	}

	public static boolean verificarDuplicidade(ArrayList<Gen> genes, Gen gen) {
		for (int i = 0; i < genes.size(); i++) {
			if (genes.get(i).getMateria().equals(gen.getMateria())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return materia + "";
	}
}