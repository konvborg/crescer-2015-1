package filmator;

import java.util.ArrayList;

public class Netflox {
	private ArrayList<Filme> listaFilmes = new ArrayList<>();
	
	public void inserirFilme(Filme filme){
		this.listaFilmes.add(filme);
	}
	public void reproduzirFilme(Filme filme){
		if(listaFilmes.contains(filme)){
			System.out.println("Reproduzindo " + filme.getTitulo() + "!");
			filme.getGenero().adicionarNumero();
		}	else{
			System.out.println("Filme n�o dispon�vel.");
		}		
	}
	public void gerarRelatorio(){
		System.out.println("Relat�rio:");
		System.out.println(Genero.COMEDIA.desc +"\nExibido "+ Genero.COMEDIA.n+" vezes.\n\n");
		System.out.println(Genero.ACAO.desc +"\nExibido "+ Genero.ACAO.n+" vezes.\n\n");
		System.out.println(Genero.EPICO.desc +"\nExibido "+ Genero.EPICO.n+" vezes.\n\n");
		System.out.println(Genero.DRAMA.desc +"\nExibido "+ Genero.DRAMA.n+" vezes.\n\n");
	}
}
