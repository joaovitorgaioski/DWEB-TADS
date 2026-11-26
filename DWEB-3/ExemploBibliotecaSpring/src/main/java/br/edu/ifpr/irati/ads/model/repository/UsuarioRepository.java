package br.edu.ifpr.irati.ads.model.repository;

import br.edu.ifpr.irati.ads.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UsuarioRepository {

    private String INSERT = "INSERT INTO tbusuario(nome) VALUES (?)";
    private String SELECT_ALL = "SELECT * FROM tbusuario";
    private String UPDATE = "UPDATE tbusuario SET nome = ? WHERE ID = ?";
    private String DELETE = "DELETE FROM tbusuario WHERE ID = ?";

    // Encapsula a conexão com o banco
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Usuario salvar(Usuario usuario) {
        jdbcTemplate.update(INSERT, new Object[]{usuario.getNome()});
        return usuario;
    }

    private RowMapper<Usuario> obterUsuarioMapper() {
        return new RowMapper<Usuario>() {
            @Override
            public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                return new Usuario(id, nome);
            }
        };
    }

    public List<Usuario> buscarPorNome(String nome) {
        return jdbcTemplate.query(SELECT_ALL.concat(" WHERE nome LIKE ?"), new Object[]{"%" + nome + "%"}, obterUsuarioMapper());
    }

    public List<Usuario> obterTodos() {
        return jdbcTemplate.query(SELECT_ALL, new RowMapper<Usuario>() {
            @Override
            public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Usuario(rs.getInt("id"), rs.getString("nome"));
            }
        });
    }

    public Usuario atualizar(Usuario usuario) {
        jdbcTemplate.update(UPDATE, usuario.getNome(), usuario.getId());
        return usuario;
    }

    public Usuario deletar(Usuario usuario) {
        jdbcTemplate.update(DELETE, usuario.getId());
        return usuario;
    }
}
