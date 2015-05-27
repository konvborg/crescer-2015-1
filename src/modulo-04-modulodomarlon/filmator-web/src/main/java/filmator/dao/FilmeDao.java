package filmator.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import filmator.model.Filme;
import filmator.model.Genero;

@Component
public class FilmeDao {

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	
	public void inserir(Filme filme){
		jdbcTemplate.update("INSERT INTO Filme (nome, anolancamento, genero, sinopse) VALUES (?,?,?,?)", filme.getNome(), filme.getAnoLancamento(), filme.getGenero().name(), filme.getSinopse());
	}
	
	public List<Filme> lista(){
		List<Filme> filmes = this.jdbcTemplate.query(
		        "SELECT NOME, ANOLANCAMENTO, GENERO, SINOPSE FROM FILME",
		        new RowMapper<Filme>() {
		            public Filme mapRow(ResultSet rs, int rowNum) throws SQLException {
		                Filme filme = new Filme();
		                filme.setNome(rs.getString("NOME"));
		                filme.setAnoLancamento(rs.getInt("ANOLANCAMENTO"));
		                filme.setGenero(Genero.valueOf(rs.getString("GENERO")));
		                filme.setSinopse(rs.getString("SINOPSE"));
		                return filme;
		            }
		        });
		return filmes;
	}
	
}