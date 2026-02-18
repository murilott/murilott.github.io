package dao;

import entity.Engenheiro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EngenheiroDAO extends BaseDAO{

    public void inserir(Engenheiro p){
        String sql = """
            insert into engenheiro(nome_engenheiro, especialidade) values(?, ?);
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            pre.setString(1, p.getNome_engenheiro());
            pre.setString(2, p.getEspecialidade());
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizar(Engenheiro p){
        String sql = """
            update engenheiro set nome_engenheiro = ?, especialidade = ?
            where id_engenheiro = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            pre.setString(1,p.getNome_engenheiro());
            pre.setString(2,p.getEspecialidade());
            pre.setInt(3,p.getId_engenheiro());
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletar(Engenheiro p){
        String sql = """
            delete from engenheiro where id_engenheiro = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            pre.setInt(1,p.getId_engenheiro());
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

   public List<Engenheiro> obterTodos(){
        List<Engenheiro> lista = new ArrayList<>();
        String sql = """
            select id_engenheiro, nome_engenheiro, especialidade from engenheiro
            order by nome_engenheiro asc;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Engenheiro p = new Engenheiro(rs.getString("nome_engenheiro"),
                    rs.getString("especialidade")
                    );
                p.setId_engenheiro(rs.getInt("id_engenheiro"));
                lista.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

}
