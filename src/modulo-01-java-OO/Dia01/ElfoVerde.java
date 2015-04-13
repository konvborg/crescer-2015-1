
/**
 * Write a description of class ElfoVerde here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElfoVerde extends Elfo
{
public ElfoVerde(String nome){
    super(nome,42);
    }
/**
 * Chama o método atirar flecha, mas ganha dois de experiencia.
 * @param umOrc Orc que vai receber a flecha.
 */
protected void atirarFlecha(Orc umOrc) {
    //flechas = flechas - 1;
    super.atirarFlecha(umOrc);
    experiencia++;
    }
/**
 * Adiciona item no inventario desde que ele seja uma Espada de aço valiriano ou um Arco e Flecha de Vidro.
 * @param ItemDoInventario item a ser adicionado
 */
    protected void adicionarItem(ItemDoInventario item){
    if((item.getDescricao()=="Espada de aço valiriano")||(item.getDescricao()=="Arco e Flecha de Vidro")){
            this.itens.add(item);
    }else{
        return;
    }
    }
}
