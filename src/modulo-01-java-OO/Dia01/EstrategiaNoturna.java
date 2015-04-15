import java.util.*;
public class EstrategiaNoturna implements EstrategiaDeAtaque
{
    public void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs) {
        System.out.println("Super estratégia noturna.. ATIVAR!!!");
        
        int qtdAtaques = elfos.size() * orcs.size();
        int limiteElfosNoturnos = (int)(qtdAtaques * 0.3);
        int qtdElfosNoturnosQueJáAtacaram = 0;
        
        for (Elfo elfoQueVaiAtacar : elfos) {
            boolean éElfoNoturno = elfoQueVaiAtacar instanceof ElfoNoturno;
            
            if (éElfoNoturno) {
                if (qtdElfosNoturnosQueJáAtacaram >= limiteElfosNoturnos)
                    continue;
                qtdElfosNoturnosQueJáAtacaram++;
            }
            
            for (Orc orc : orcs) {
                elfoQueVaiAtacar.atirarFlecha(orc);
            }
            
        }
    }
}
