package filmator;

import java.util.ArrayList;
import java.util.HashMap;

public class Empresa {
	private String nome;
	private ArrayList<Filme> listaFilmes = new ArrayList<>();
	private HashMap<Genero, Integer> vis = new HashMap<>();
	
	public Empresa(String nome){
		this.nome=nome;
	}
	public void inserirFilme(Filme filme){
		this.listaFilmes.add(filme);
	}
	public void reproduzirFilme(Filme filme){
		if(listaFilmes.contains(filme)){
			System.out.println("Reproduzindo " + filme.getTitulo() + "!");
			if(this.vis.containsKey(filme.getGenero())){
				this.vis.replace(filme.getGenero(), this.vis.get(filme.getGenero())+1);
			}	else{
				this.vis.put(filme.getGenero(),1);
			}
				
		}	else{
			System.out.println("Filme não disponível.");
		}		
	}
	public void gerarRelatorio(){
		System.out.println("Relatório " + this.nome + " :");
		System.out.println(Genero.COMEDIA.desc +"\nExibido "+ this.vis.getOrDefault(Genero.ACAO,0) +" vezes.\n\n");
		System.out.println(Genero.ACAO.desc +"\nExibido "+ this.vis.getOrDefault(Genero.COMEDIA,0) +" vezes.\n\n");
		System.out.println(Genero.EPICO.desc +"\nExibido "+ this.vis.getOrDefault(Genero.DRAMA,0)+" vezes.\n\n");
		System.out.println(Genero.DRAMA.desc +"\nExibido "+ this.vis.getOrDefault(Genero.EPICO,0)+" vezes.\n\n");
	}
}
