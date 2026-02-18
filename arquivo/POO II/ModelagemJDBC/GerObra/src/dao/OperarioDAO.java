package dao;

import entity.Operario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OperarioDAO extends BaseDAO{

    public void inserir(Operario p){
        String sql = """
            insert into operario(nome_operario, funcao) values(?, ?);
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            pre.setString(1, p.getNome_operario());
            pre.setString(2, p.getfuncao());
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizar(Operario p){
        String sql = """
            update operario set nome_operario = ?, funcao = ?
            where id_operario = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            pre.setString(1,p.getNome_operario());
            pre.setString(2,p.getfuncao());
            pre.setInt(3,p.getId_operario());
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletar(Operario p){
        String sql = """
            delete from operario where id_operario = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            pre.setInt(1,p.getId_operario());
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Operario> obterTodos(){
        List<Operario> lista = new ArrayList<>();
        String sql = """
            select id_operario, nome_operario, funcao from operario
            order by nome_operario asc;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Operario p = new Operario(rs.getString("nome_operario"),
                    rs.getString("funcao")
                    );
                p.setId_operario(rs.getInt("id_operario"));
                lista.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

}
