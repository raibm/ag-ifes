package controle;

import java.util.ArrayList;

public class Materia {
	private String materia;
	private String professor;
	private int numAulas;
	private int totalNumAulas;
	private int matPreferencia[][] = new int [1][20];

	public Materia(String valor) {
		String valores[] = valor.split("_");
		this.materia = valores[1];
		this.setProfessor(valores[0]);
		this.numAulas = Integer.parseInt(valores[2]);
		this.totalNumAulas = Integer.parseInt(valores[2]);
	}

	public Materia() {
		
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
	
	public void popularPreferencia(){
		for(int i = 0; i < 1; i++){
			for(int j = 0; j < 20; j++){
				this.matPreferencia[i][j] = (int) (Math.random() * 10) + 1;
			}
		}
	}
	

	public int[][] getMatPreferencia() {
		return matPreferencia;
	}

	public void setMatPreferencia(int[][] matPreferencia) {
		this.matPreferencia = matPreferencia;
	}

	public String getMateria() {
		return materia;
	}

	public int getTotalNumAulas() {
		return totalNumAulas;
	}

	public void setTotalNumAulas(int totalNumAulas) {
		this.totalNumAulas = totalNumAulas;
	}

	@Override
	public String toString() {
		return this.materia + "_" + this.numAulas + "_";
	}
}