package controle;

import java.util.ArrayList;

public class Materia {
	private String materia;
	private String professor;
	private int numAulas;

	public Materia(String valor) {
		String valores[] = valor.split("_");
		this.materia = valores[1];
		this.setProfessor(valores[0]);
		this.numAulas = Integer.parseInt(valores[2]);
	}

	public static ArrayList<Materia> materias(String[] materia) {
		ArrayList<Materia> materias = new ArrayList<Materia>();
		for (int i = 0; i < materia.length; i++) {
			String valor = materia[i];
			materias.add(new Materia(valor));
		}
		return materias;
	}

	public String getNomeMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public int getNumAulas() {
		return numAulas;
	}

	public void setNumAulas(int numAulas) {
		this.numAulas = numAulas;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	@Override
	public String toString() {
		return this.materia + "_" + this.numAulas + "\n";
	}
}