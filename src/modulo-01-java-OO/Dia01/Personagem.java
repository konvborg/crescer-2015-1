import java.util.*;

/**
 * Classe base para todos Personagem objetos do jogo.
 * 
 * @author CWI Software
 */
// C#:
// public sealed class Personagem
// Java:
// public final class Personagem
public abstract class Personagem
{
    protected Status status = Status.VIVO;
    protected double vida;
    protected String nome;
    protected int experiencia;
    protected ArrayList<ItemDoInventario> itens = new ArrayList<ItemDoInventario>();
    
    protected Personagem(String nome, int vida) {
        this.nome = nome;
        this.vida = vida;
    }
    
    protected Status getStatus() {
        return status;
    }
    
    protected double getVida() {
        return vida;
    }
    
    protected String getNome() {
        return nome;
    }
    
    protected int getExperiencia() {
        return experiencia;
    }
    
    protected ArrayList<ItemDoInventario> getItens() {
        return this.itens;
    }
    
    /**
     * Adiciona um item ao inventário.
     * 
     * @param item Item a ser adicionado.
     */
    protected void adicionarItem(ItemDoInventario item) {
        this.itens.add(item);
    }

    /**
     * Remove o item do inventário do orc.
     * 
     * @param item Item a ser perdido do inventário.
     */
    protected void perderItem(ItemDoInventario item) {
        this.itens.remove(item);
    }
    
    /**
     * Concatena as descrições dos itens, separados por vírgula.
     * 
     * SEM ESPAÇO ENTRE AS VÍRGULAS E SEM PONTO FINAL
     * 
     * @return Descrições. Ex:
     * 
     * "Adaga,Escudo,Bracelete”
     */
    protected String getDescricoesItens() {
        StringBuilder builder = new StringBuilder();
        
        /*
         * Utilizando for tradicional         
        int numeroDeItens = this.itens.size();
        
        for (int i = 0; i < numeroDeItens; i++) {
            ItemDoInventario itemAtual = this.itens.get(i);
            
            boolean éÚltimoÍndice = i == numeroDeItens - 1;
                        
            builder.append(
                éÚltimoÍndice ?
                itemAtual.getDescricao() :
                itemAtual.getDescricao() + ","
            );
        }
        */
        
        // C#
        //foreach (ItemDoInventario item in this.itens) { }
        
        /*
        * Utilizando FOREACH!!
        for (ItemDoInventario itemAtual : this.itens) {
           int i = this.itens.indexOf(itemAtual);
           int numeroDeItens = this.itens.size();
           boolean éÚltimoÍndice = i == numeroDeItens - 1;
           
           builder.append(
                éÚltimoÍndice ?
                itemAtual.getDescricao() :
                itemAtual.getDescricao() + ","
            );
        }
        */
        
        /*
        * JavaScript
        for (var i = 0, numeroDeItens = this.itens.size(); i < numeroDeItens; i++) {
        }
        */
        
        /*
        * WHILE (ENQUANTO)
        int i = 0;
        int numeroDeItens = this.itens.size();    
        
        while (i < numeroDeItens) {
          ItemDoInventario itemAtual = this.itens.get(i);
          boolean éÚltimoÍndice = i == numeroDeItens - 1;
           
          builder.append(
                éÚltimoÍndice ?
                itemAtual.getDescricao() :
                itemAtual.getDescricao() + ","
          );
          //
          i++;
        }
        */
     
         int i = 0;
         int numeroDeItens = this.itens.size();
         do {
             if (numeroDeItens > 0) {
                 ItemDoInventario itemAtual = this.itens.get(i);
                  boolean éÚltimoÍndice = i == numeroDeItens - 1;
                   
                  builder.append(
                        éÚltimoÍndice ?
                        itemAtual.getDescricao() :
                        itemAtual.getDescricao() + ","
                  );
             }
             i++;
         } while(i < numeroDeItens);
     
         return builder.toString();
    }
    
    protected ItemDoInventario getItemComMaiorQuantidade() {
        
        ItemDoInventario itemMaiorQuantidade = null;
        
        boolean temItens = !this.itens.isEmpty();       
        if (temItens) {
            itemMaiorQuantidade = this.itens.get(0);
            
            for (int i = 1; i < this.itens.size(); i++) {
                ItemDoInventario itemAtual = this.itens.get(i);
                boolean encontreiAMaiorQuantidade =
                    itemAtual.getQuantidade() > itemMaiorQuantidade.getQuantidade();
                
                if (encontreiAMaiorQuantidade) {
                    // atualizar a minha referência para o maior parcial
                    itemMaiorQuantidade = itemAtual;
                }
            }
        }
        
        return itemMaiorQuantidade;
        
        // C#
        // return this.itens.Max(x => x.Quantidade);
    }
    
    /**
     * Ordena itens do inventário por quantidade ascendente.
     * 
     * Algoritmo atual: Bubblesort
     */
    protected void ordenarItens() {

        // Versão mais estável do Bubblesort - Melhor caso O(n), Pior caso O(n^2)
        // iniciamos com true para forçar a entrada no laço.. poderia ter sido feito com do-while também
        boolean posicoesSendoTrocadas = true;
        
        while (posicoesSendoTrocadas) {
            posicoesSendoTrocadas = false;
            for (int j = 0; j < this.itens.size() - 1; j++) {
                ItemDoInventario itemAtual = this.itens.get(j);
                ItemDoInventario proximo = this.itens.get(j + 1);
                
                boolean precisaTrocar = 
                    itemAtual.getQuantidade() > proximo.getQuantidade();
                
                if (precisaTrocar) {
                    this.itens.set(j, proximo);
                    this.itens.set(j + 1, itemAtual);
                    posicoesSendoTrocadas = true;
                }
            }
        }
        
        /*
        
        // Versão mais simples porém mais instável do BubbleSort - sempre O(n^2)
        int numeroItens = this.itens.size();
        
        for (int i = 0; i < numeroItens; i++) {
            for (int j = 0; j < numeroItens - 1; j++) {
                ItemDoInventario itemAtual = this.itens.get(j);
                ItemDoInventario proximo = this.itens.get(j + 1);
                
                boolean precisaTrocar = 
                    itemAtual.getQuantidade() > proximo.getQuantidade();
                
                if (precisaTrocar) {
                    this.itens.set(j, proximo);
                    this.itens.set(j + 1, itemAtual);
                }
            }
        }*/
        
        // Java - MergeSort - O(n logn)
        /*Collections.sort(this.itens, new Comparator<ItemDoInventario>() {
            public int compare(ItemDoInventario item, ItemDoInventario outroItem) {
                return Integer.compare(item.getQuantidade(), outroItem.getQuantidade());
            }
        });*/
        
        
        // C# - MergeSort - O(n logn)
        // return this.itens.OrderBy(x => x.Quantidade);
        
        // Ruby - QuickSort - O (n logn) em média, porém pior caso O(n^2)
        // itens.sort_by { |x| x.quantidade }
        
    }
    
    abstract void imprimeNome();
}
