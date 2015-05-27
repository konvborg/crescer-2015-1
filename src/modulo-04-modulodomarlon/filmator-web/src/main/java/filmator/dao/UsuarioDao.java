package filmator.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import filmator.model.TipoUsuario;
import filmator.model.Usuario;

@Component
public class UsuarioDao {

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public void inserir(Usuario usuario){
		jdbcTemplate.update("INSERT INTO Usuario (nome, login, senha, tipo) VALUES (?,?,?,?)", usuario.getNome(),usuario.getLogin(), usuario.getSenha(), usuario.getTipo().name());
	}
	
	public Usuario validar(String login, String senha){
		List<Usuario> usuarios = this.jdbcTemplate.query(
		        "select * from usuario where login=?",
		        new RowMapper<Usuario>() {
		            public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		                Usuario usuario = new Usuario();
		                usuario.setNome(rs.getString("nome"));
		                usuario.setLogin(rs.getString("login"));
		                usuario.setSenha(rs.getString("senha"));
		                usuario.setTipo(TipoUsuario.valueOf(rs.getString("tipo")));
		                usuario.setId(rs.getInt("id"));
		                return usuario;
		            }
		        }, login);
		if(usuarios.get(0).getSenha().equals(senha)){
			return usuarios.get(0); 
		}
		return null;
	}
	
	public List<Usuario> lista(){
		List<Usuario> usuarios = this.jdbcTemplate.query(
		        "select nome,login,tipo from usuario",
		        new RowMapper<Usuario>() {
		            public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		                Usuario usuario = new Usuario();
		                usuario.setNome(rs.getString("nome"));
		                usuario.setLogin(rs.getString("login"));
		                usuario.setTipo(TipoUsuario.valueOf(rs.getString("tipo")));
		                return usuario;
		            }
		        });
			return usuarios;
	}
	
	
}