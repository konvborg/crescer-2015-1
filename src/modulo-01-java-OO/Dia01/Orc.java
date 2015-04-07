/**
 * Define objetos do tipo Orc
 * 
 * @author CWI Software
 */
public class Orc
{
    private int vida = 110;
    private String nome;
    private int experiencia = 0;
    private Status status = Status.VIVO; 
    {
        //vida = 110;
    }
    /**
     * Construtor Orc definindo nome do Orc
     * 
     * @param nome Nome que o Orc receberá
     */
    public Orc(String nome) {
        this.nome = nome;
    }
    
    /**
     * Construtor Orc default
     */
    public Orc(){
    }
    
    /**
     * Chama o metodo gerarNumero() :
     * Se o numero gerado for negativo, o Orc não recebe o dano e ganha 2 de experiência.
     * Se o numero gerado for positivo e menor que 100, o Orc não recebe dano nem experiência.
     * Se o numero gerado for positivo e maior que 100, o Orc recebe o dano.
     * Atualmente 10 de dano será decrementado.
     */
    public void recebeAtaque() {
        double n = 0.0;
        n=gerarNumero();
        if(n<0){
            experiencia+=2;
        }
            else{
                if(n>100){
                    this.vida-=10;
                    }
                }
        if(this.vida<=0){
            status = Status.MORTO;
        }
        // this.vida = this.vida - 10;
    }
    public void setVida(int vida){
        this.vida=vida;
    }
    public void setStatus(Status status){
        this.status=status;
    }
    public int getVida() {
        return this.vida;
    }
    public void setExperiencia(int exp){
        this.experiencia=exp;
    }
    /**
     * Imprime a vida atual do Orc
     * 
     * @return String com a vida atual do Orc. Ex. Vida Atual: 110
     */
    public String toString(){
        return String.format("Vida Atual: %d.",
                    this.vida
                    );
    }
    
    /**
     * Gera um numero com base nas seguintes condições:
     * 
     * Se o orc possuir nome e o mesmo tiver mais de 5 letras, soma 65 ano número. Caso contrários, subrai 60.
     * Se o orc possuir vida entre 30 e 60, multiplica o numero por dois, senão, se a vida for menor que 20 multiplica por 3.
     * Se o Status do orc for fugindo, divide o numero por dois, senão, se o orc estiver caçando ou dormindo, incrementa em 1 o número.
     * Se a experiencia do orc for par, eleva ao cubo. Se for impar e maior que 2, eleva ao quadrado.
     */
    private double gerarNumero(){
        double num = 0.0;
        if((nome!=null)&&(nome.length()>5)){
            num=num+65;
        }
            else{
                num-=60;
            }
        if((vida>30)&&(vida<60)){
            num=num*2;
        }
            else{
                if(vida<20){
                    num=num*3;
                }
            }
        if(status==status.FUGINDO){
            num=num/2;
        }
            else{
                if((status==status.CACANDO)||(status==status.DORMINDO)){
                    num++;
                }
            }
        if((experiencia  % 2) == 0){
            num=Math.pow(num,3);
        }
            else{
                if(experiencia>2){
                    num=Math.pow(num,2);
                    }
                }
        return num;
    }
  
    //public String toString(){
    //    return "oi";
    //}
    
}