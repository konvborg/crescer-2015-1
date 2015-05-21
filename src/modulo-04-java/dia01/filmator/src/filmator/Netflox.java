package filmator;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Netflox {

	private Map<Genero, Integer> estatisticasPorGenero = new HashMap<>();
	
	public void reproduzirFilme(Filme filme){
		Genero generoDoFilme = filme.getGenero();
		int estatistica = estatisticasPorGenero.getOrDefault(generoDoFilme, 0);
		System.out.println("Reproduzindo " + filme);
		
		// Incrementa e devolve o contador por genero no map de estatísticas
		estatisticasPorGenero.put(generoDoFilme, ++estatistica);
	}
	
	public String geraRelatorio(){
		StringBuilder relatorio = new StringBuilder();
		for(Entry<Genero, Integer> entrada : estatisticasPorGenero.entrySet()){
			relatorio.append(String.format("%s: %s", entrada.getKey(), entrada.getValue()));
			relatorio.append('\n');
		}
		return relatorio.toString();
	}
	
	public Map<Genero, Integer> getEstatisticasPorGenero() {
		return estatisticasPorGenero;
	}
}
