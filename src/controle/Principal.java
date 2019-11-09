package controle;

//import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		//ArrayList<Materia> materiasSemestre1 = Materia.materias(Util.materias_1);
	//	System.out.println(materiasSemestre1);
		Cromossomo cromossomo = Cromossomo.popularCromossomo();
		System.out.println(cromossomo.getMatriz()[0][0].getMateria().toString());
		System.out.println(cromossomo.getMatriz()[0][1].getMateria().toString());
	}

}