package controle;

public class Analise {
	private int ciclo = 0;
	private String top1 = "";
	private String clones = "";
	private String mutacoes = "";
	private String filhos = "";
	private int contInsercao = 0;
	private int contMutacao = 0;
	private int contTop1 = 0;
	private int contMutInsert = 0;
	private int contClone = 0;

	public Analise() {
		super();
	}

	public String getTop1() {
		return top1;
	}

	public void setTop1(String top1) {
		this.top1 += top1;
	}

	public String getClones() {
		return clones;
	}

	public void setClones(String clones) {
		this.clones += clones;
	}

	public String getMutacoes() {
		return mutacoes;
	}

	public void setMutacoes(String mutacoes) {
		this.mutacoes += mutacoes;
	}

	public String getFilhos() {
		return filhos;
	}

	public void setFilhos(String filhos) {
		this.filhos += filhos;
	}

	public int getContInsercao() {
		return contInsercao;
	}

	public void setContInsercao(int contInsercao) {
		this.contInsercao = contInsercao;
	}

	public int getContMutacao() {
		return contMutacao;
	}

	public void setContMutacao(int contMutacao) {
		this.contMutacao = contMutacao;
	}

	public int getContTop1() {
		return contTop1;
	}

	public void setContTop1(int contTop1) {
		this.contTop1 = contTop1;
	}

	public int getContMutInsert() {
		return contMutInsert;
	}

	public void setContMutInsert(int contMutInsert) {
		this.contMutInsert = contMutInsert;
	}

	public int getCiclo() {
		return ciclo;
	}

	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}

	public int getContClone() {
		return contClone;
	}

	public void setContClone(int contClone) {
		this.contClone = contClone;
	}

}
