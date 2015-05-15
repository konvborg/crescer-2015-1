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
	public String gerarRelatorio(){
		StringBuilder aux = new StringBuilder();
		aux.append("Relatório " + this.nome + " :\n");
		aux.append(Genero.ACAO.desc +"\nExibido "+ this.vis.getOrDefault(Genero.ACAO,0));
		if(this.vis.getOrDefault(Genero.ACAO, 0)==1)
			aux.append(" vez.\n\n");
		else
			aux.append(" vezes.\n\n");
		
		aux.append(Genero.COMEDIA.desc +"\nExibido "+ this.vis.getOrDefault(Genero.COMEDIA,0));
		if(this.vis.getOrDefault(Genero.COMEDIA, 0)==1)
			aux.append(" vez.\n\n");
		else
			aux.append(" vezes.\n\n");
		
		aux.append(Genero.DRAMA.desc +"\nExibido "+ this.vis.getOrDefault(Genero.DRAMA,0));
		if(this.vis.getOrDefault(Genero.DRAMA, 0)==1)
			aux.append(" vez.\n\n");
		else
			aux.append(" vezes.\n\n");
		
		aux.append(Genero.EPICO.desc +"\nExibido "+ this.vis.getOrDefault(Genero.EPICO,0));
		if(this.vis.getOrDefault(Genero.EPICO, 0)==1)
			aux.append(" vez.");
		else
			aux.append(" vezes.");
		
		return aux.toString();
	}
	public ArrayList<Filme> getListaFilmes(){
		return this.listaFilmes;
	}
	public HashMap<Genero,Integer> getVis(){
		return this.vis;
	}
}
