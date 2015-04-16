import java.util.*;

public class EstrategiaPriorizandoElfosVerdes implements EstrategiaDeAtaque
{
    private ArrayList<Elfo> ordemAtaque = new ArrayList<>();
    
    public void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs) {
        ordenaComBubbleSort(elfos, orcs);
        
        for (Elfo elfo : elfos) {
            ordemAtaque.add(elfo);
            for (Orc orc : orcs) {
                elfo.atirarFlecha(orc);
            }
        }
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return ordemAtaque;
    }
    
    private void ordenaComBubbleSort(ArrayList<Elfo> elfos, ArrayList<Orc> orcs) {
        
        boolean houverTroca = true;
        while (houverTroca) {
            houverTroca = false;
            for (int i = 0; i < elfos.size() - 1; i++) {
                
                Elfo elfoAtual = elfos.get(i);
                Elfo elfoProximo = elfos.get(i + 1);
                
                // só precisa trocar se um elfo noturno vier antes de um elfo verde
                boolean precisaTrocar = elfoAtual instanceof ElfoNoturno && elfoProximo instanceof ElfoVerde;
                
                if (precisaTrocar) {
                    elfos.set(i, elfoProximo);
                    elfos.set(i + 1, elfoAtual);
                    houverTroca = true;
                }
                
            }
            
        }
        
    }
}