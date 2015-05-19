package mestrecuca;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	
	public double calcularValorReceitas(List<Receita> lista){
		double valor = 0;
		for(Receita receita: lista){
			valor += receita.calcularValor();
		}
		return valor;
	}
	
	public List<Receita> protegerAlergicos(List<Ingrediente> listaAlergicos){
		List<Receita> protegidos = new ArrayList<>();
		for(Ingrediente ingrediente: listaAlergicos){
			for(Receita receita: listaReceitas){
				if(receita.listaIngrediente.indexOf(ingrediente)==-1){
					protegidos.add(receita);
				}
			}
		}
		return protegidos;
	}
	
	public List<Ingrediente> gerarListaDeCompras(List<Receita> lista){
		List<Ingrediente> aux = new ArrayList<>();
		
		for(Receita receita: lista){
			for(Ingrediente ingrediente: receita.listaIngrediente){
				if(!aux.isEmpty()){
					for(int i = 0 ; i < aux.size() ; i++){
						if (ingrediente.nome == aux.get(i).nome && ingrediente.unidade == aux.get(i).unidade) {
							double novaQuantidade = ingrediente.quantidade + aux.get(i).quantidade;
							double novoValor = ingrediente.valor + aux.get(i).valor;
							Ingrediente novoAuxiliar = new Ingrediente(ingrediente.nome,novaQuantidade,ingrediente.unidade, novoValor);
							aux.set(i, novoAuxiliar);
						}else{
							aux.add(ingrediente);
						}
					}
				}else{
					aux.add(ingrediente);
				}
			}
		}
		return aux;
	}
}
