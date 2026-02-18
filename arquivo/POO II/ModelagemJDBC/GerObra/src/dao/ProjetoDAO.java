package dao;

import entity.Engenheiro;
import entity.Projeto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjetoDAO extends BaseDAO{

    public void inserir(Projeto p){
        String sql = """
            insert into projeto(nome_projeto, local, data_inicio, data_termino) values(?, ?, ?, ?);
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            pre.setString(1, p.getNome_projeto());
            pre.setString(2, p.getLocal());
            pre.setDate(3, p.getData_inicio());
            pre.setDate(4, p.getData_termino());
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizar(Projeto p){
        String sql = """
            update projeto set nome_projeto = ?, local = ?, data_inicio = ?, data_termino = ?
            where id_projeto = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            pre.setString(1,p.getNome_projeto());
            pre.setString(2,p.getLocal());
            pre.setDate(3,p.getData_inicio());
            pre.setDate(4,p.getData_termino());
            pre.setInt(5,p.getId_projeto());
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletar(Projeto p){
        String sql = """
            delete from projeto where id_projeto = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            pre.setInt(1,p.getId_projeto());
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Projeto> obterTodos(){
        List<Projeto> lista = new ArrayList<>();
        String sql = """
            select id_projeto, nome_projeto, local, data_inicio, data_termino from projeto
            order by nome asc;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Projeto p = new Projeto(rs.getString("nome_projeto"),
                    rs.getString("local"),
                    rs.getDate("data_inicio"),
                    rs.getDate("data_termino")
                    );
                p.setId_projeto(rs.getInt("id_projeto"));
                lista.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

    public Projeto getProjeto(int id){
        String sql = """
            select id_projeto, nome_projeto, local, data_inicio, data_termino from projeto
            where id_projeto = ?
            order by nome_projeto asc;
                """;
        Projeto p = new Projeto();
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setInt(1,id);
            // Recurso bem caro
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                p = new Projeto(rs.getString("nome_projeto"),
                    rs.getString("local"),
                    rs.getDate("data_inicio"),
                    rs.getDate("data_termino")
                    );
                // return Optional.of(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return p;
    }

    public List<Engenheiro> getEngenheiro(int id) {
        List<Engenheiro> lista = new ArrayList<>();
        String sql = """
            select id_engenheiro from alocacao_engenheiro
            where alocacao_engenheiro.id_projeto = projeto.?
            order by nome asc;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setInt(1, id);
            // Recurso bem caro
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                // Engenheiro p = new Engenheiro(,
                // rs.getString("nome"));
                // lista.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

}
