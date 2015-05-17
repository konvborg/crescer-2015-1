package filmator;

import java.util.ArrayList;
import java.util.List;


public class Filme {

	private String nome;
	private List<Ator> elenco = new ArrayList<Ator>();
	private Genero genero;

	public Filme(String nome, Genero genero){
		this.nome = nome;
		this.genero = genero;
	}
	
	public List<Ator> getElenco() {
		return elenco;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Genero getGenero() {
		return genero;
	}
	
	@Override
	public String toString() {
		return String.format("%s, %s", this.nome, this.genero);
	}
	
	public void adicionarAtor(Ator ator){
		this.elenco.add(ator);
	}
	
	public List<Ator> buscaAtoresPeloNome(String busca){
		List<Ator> resultado = new ArrayList<>();
		for(Ator ator : elenco){
			if(ator.getNome().contains(busca)){
				resultado.add(ator);
			}
		}
		return resultado;
	}
}
