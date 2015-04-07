
/**
 * Item do inventario
 * 
 * @author Mauricio Borges
 */
public class ItemDoInventario
{
    // instance variables - replace the example below with your own
    private int quantidade;
    private String descricao;

    /**
     * Construtor default para ItemDoInventario
     */
    public ItemDoInventario()
    {
        // initialise instance variable
    }
        public ItemDoInventario(String desc, int quan)
    {
        this.quantidade = quan;
        this.descricao = desc;
    }
    
    public int getQuantidade()
    {
        return quantidade;
    }
    
    public String getDescricao()
    {
        return descricao;
    }
}
