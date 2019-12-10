package controle;

import java.util.ArrayList;

public class Populacao {

	/**
	 * Default serial UID
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Cromossomo> listaCromossomos;
	private Cromossomo top1; // Cromossomo co m melhor fitness.

	public Populacao() {
		this.listaCromossomos = new ArrayList<Cromossomo>();
		this.top1 = new Cromossomo();
	};

	public Populacao(ArrayList<Cromossomo> populacao) {
		super();
		this.listaCromossomos = populacao;
		encontrarTop1();
	}

	@Override
	public String toString() {
		String s = "Populacao\n";
		for (Cromossomo cromossomo : listaCromossomos) {
			s += cromossomo;
		}
		s += "\ntop1 " + this.getTop1();
		return s;
	}

	public void encontrarTop1() {
		double fitAux = Double.MIN_VALUE;
		for (Cromossomo cromossomo : listaCromossomos) {
			if (fitAux < cromossomo.getFitness()) {
				fitAux = cromossomo.getFitness();
				top1 = cromossomo;
			}
		}
	}

	public ArrayList<Cromossomo> getPopulacao() {
		return this.listaCromossomos;
	}

	public void setPopulacao(ArrayList<Cromossomo> populacao) {
		this.listaCromossomos = populacao;
	}

	public Cromossomo getTop1() {
		return top1;
	}

	public void setTop1(Cromossomo top1) {
		this.top1 = top1;
	}

	public boolean validarGene() {
		return false;
	}

	public void addCromo(Cromossomo cromossomo) {
		this.listaCromossomos.add(cromossomo);
	}

	public Cromossomo getCromo(int i) {
		return this.listaCromossomos.get(i);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}