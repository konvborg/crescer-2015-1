package mestrecuca;

import java.util.ArrayList;
import java.util.List;

public class Receitator  implements LivroReceitas {
	private List<Receita> listaReceitas = new ArrayList<>();
	
	public void inserir(Receita receita){
		if(receita.nome.isEmpty()||receita.listaIngrediente.isEmpty()||receita.listaInstrucao.isEmpty()){
			Erros.nomeOuReceitaNuloException();
		} else{
				listaReceitas.add(receita);
		  }
	}
	
	public void atualizar(String nome, Receita receitaAtualizada){
		if(receitaAtualizada.nome.isEmpty()||receitaAtualizada.listaIngrediente.isEmpty()||receitaAtualizada.listaInstrucao.isEmpty()){
			Erros.nomeOuReceitaNuloException();
		} else{
				for(int i=0;i<listaReceitas.size();i++){
					if(listaReceitas.get(i).nome == nome){
						listaReceitas.set(i, receitaAtualizada);
						return;
					}
				}
		  }
		Erros.nomeInvalidoException();
	}
	
	public void excluir (String nome){
		for(int i=0;i<listaReceitas.size();i++){
			if(listaReceitas.get(i).nome == nome){
				listaReceitas.remove(i);
				return;
			}
		}
		Erros.nomeInvalidoException();
	}
	
	public List<Receita> getTodasReceitas(){
		return listaReceitas;
	}
	
	public Receita buscaReceitaPeloNome(String nome){
		for(int i=0;i<listaReceitas.size();i++){
			if(listaReceitas.get(i).nome == nome){
				return listaReceitas.get(i);
			}
		}
		Erros.nomeInvalidoException();
		return null;
	}
	
}
