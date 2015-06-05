package filmator.dao;

import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import filmator.model.Avaliacao;

@Component
public class AvaliacaoDao {

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public void inserir(Avaliacao avaliacao, int id){
		jdbcTemplate.update("DELETE FROM Avaliacao WHERE IDFILME=? AND IDUSUARIO=?", avaliacao.getIdfilme(),id);
		jdbcTemplate.update("INSERT INTO Avaliacao (idfilme, idusuario, nota) VALUES (?,?,?)", avaliacao.getIdfilme(),id,avaliacao.getNota());
	}
	
	
	
}