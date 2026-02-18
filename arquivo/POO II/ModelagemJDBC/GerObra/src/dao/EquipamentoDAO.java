package dao;

import entity.Equipamento;
import entity.Operario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EquipamentoDAO extends BaseDAO{

    public void inserir(Equipamento p){
        String sql = """
            insert into equipamento(nome_equipamento, tipo) values(?, ?);
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            pre.setString(1, p.getNome_equipamento());
            pre.setString(2, p.getTipo());
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizar(Equipamento p){
        String sql = """
            update equipamento set nome_equipamento = ?, tipo = ?
            where id_equipamento = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            pre.setString(1,p.getNome_equipamento());
            pre.setString(2,p.getTipo());
            pre.setInt(3,p.getId_equipamento());
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletar(Equipamento p){
        String sql = """
            delete from equipamento where id_equipamento = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            pre.setInt(1,p.getId_equipamento());
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Equipamento> obterTodos(){
        List<Equipamento> lista = new ArrayList<>();
        String sql = """
            select id_equipamento, nome_equipamento, tipo from equipamento
            order by nome_equipamento asc;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Equipamento p = new Equipamento(rs.getString("nome_equipamento"),
                    rs.getString("funcao")
                    );
                p.setId_equipamento(rs.getInt("id_equipamento"));
                lista.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

}
