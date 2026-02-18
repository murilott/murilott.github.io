package dao;

import entity.Engenheiro;
import entity.Equipamento;
import entity.Material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Uso_EquipamentoDAO extends BaseDAO{

    public void inserir(int id_projeto, int id_equipamento){
        String sql = """
            insert into alocacao_equipamento (id_projeto, id_equipamento) values(?, ?);
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            pre.setInt(1, id_projeto);
            pre.setInt(2, id_equipamento);
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletar(int id_projeto, int id_equipamento){
        String sql = """
            delete from alocacao_equipamento where id_projeto = ? and id_equipamento = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            pre.setInt(1, id_projeto);
            pre.setInt(1, id_equipamento);
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Equipamento> getEquipamentoProjeto(int id_projeto) throws SQLException {
        String sql = "SELECT e.* FROM material e JOIN alocacao_equipamento ae ON e.id_equipamento = ae.id_equipamento WHERE ae.id_projeto = ?";
        List<Equipamento> lista = new ArrayList<>();
        try (Connection con = con();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id_projeto);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Equipamento p = new Equipamento(rs.getString("nome_equipamento"),
                            rs.getString("tipo")
                    );
                    p.setId_equipamento(rs.getInt("id_equipamento"));
                    lista.add(p);
                }
            }
        }
        return lista;
    }

}
