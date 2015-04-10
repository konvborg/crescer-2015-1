
/**
 * Write a description of class ElfoVerde here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElfoVerde extends Elfo
{
public ElfoVerde(String nome){
    super(nome,0);
    }
protected void atirarFlecha(Orc umOrc) {
    //flechas = flechas - 1;
    flechas--;
    experiencia++;
    experiencia++;
    umOrc.recebeAtaque();
    }
protected void adicionarItem(ItemDoInventario item){
    if((item.getDescricao()=="Espada de aço valiriano")||(item.getDescricao()=="Espada de aço valiriano")){
            this.itens.add(item);
    }else{
        return;
    }
    }
}
