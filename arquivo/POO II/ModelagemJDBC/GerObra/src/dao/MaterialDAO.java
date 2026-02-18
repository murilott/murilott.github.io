package dao;

import entity.Equipamento;
import entity.Material;
import entity.Material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MaterialDAO extends BaseDAO{

    public void inserir(Material p){
        String sql = """
            insert into material(nome_material, quantidade) values(?, ?);
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            pre.setString(1, p.getNome_material());
            pre.setInt(2, p.getQuantidade());
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizar(Material p){
        String sql = """
            update material set nome_material = ?, quantidade = ?
            where id_material = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            pre.setString(1,p.getNome_material());
            pre.setInt(2,p.getQuantidade());
            pre.setInt(3,p.getId_material());
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletar(Material p){
        String sql = """
            delete from material where id_material = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            pre.setInt(1,p.getId_material());
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Material> obterTodos(){
        List<Material> lista = new ArrayList<>();
        String sql = """
            select id_material, nome_material, quantidade from material
            order by nome_material asc;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Material p = new Material(rs.getString("nome_material"),
                    rs.getInt("quantidade")
                    );
                p.setId_material(rs.getInt("id_material"));
                lista.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

}
