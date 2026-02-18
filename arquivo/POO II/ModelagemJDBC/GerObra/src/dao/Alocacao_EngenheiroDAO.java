package dao;

import entity.Engenheiro;
import entity.Operario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Alocacao_EngenheiroDAO extends BaseDAO{

    public void inserir(int id_projeto, int id_engenheiro){
        String sql = """
            insert into alocacao_engenheiro (id_projeto, id_engenheiro) values(?, ?);
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            pre.setInt(1, id_projeto);
            pre.setInt(2, id_engenheiro);
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletar(int id_projeto, int id_engenheiro){
        String sql = """
            delete from alocacao_engenheiro where id_projeto = ? and id_engenheiro = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            pre.setInt(1, id_projeto);
            pre.setInt(1, id_engenheiro);
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Engenheiro> getEngenheirosProjeto(int id_projeto) throws SQLException {
        String sql = "SELECT e.* FROM engenheiro e JOIN alocacao_engenheiro ae ON e.id_engenheiro = ae.id_engenheiro WHERE ae.id_projeto = ?";
        List<Engenheiro> lista = new ArrayList<>();
        try (Connection con = con();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id_projeto);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Engenheiro p = new Engenheiro(rs.getString("nome_engenheiro"),
                            rs.getString("especialidade")
                    );
                    p.setId_engenheiro(rs.getInt("id_engenheiro"));
                    lista.add(p);
                }
            }
        }
        return lista;
    }

}
