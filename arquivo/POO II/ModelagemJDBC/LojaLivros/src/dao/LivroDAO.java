package dao;

import entity.Autor;
import entity.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LivroDAO extends BaseDAO{

    public void inserir(Livro li){
        String sql = """
            insert into livro(titulo, ano_publicado, id_autor) values(?, ?, ?);
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
//            pre.setInt(1,li.getId_livro());
            pre.setString(1,li.getTitulo());
            pre.setInt(2,li.getAno_publicado());
            pre.setInt(3,li.getId_autor());
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

   public void atualizar(Livro p){
       String sql = """
           update livro set titulo = ?, ano_publicado = ?, id_autor = ? where id_livro = ?;
               """;
       // try - with - resources
       try(Connection con = con();
           PreparedStatement pre = con.prepareStatement(sql)){
           // Recurso bem caro
           pre.setString(1,p.getTitulo());
           pre.setInt(2,p.getAno_publicado());
           pre.setInt(3,p.getId_autor());
           pre.setInt(4,p.getId_livro());
           pre.execute();
           con.close();
       }catch (SQLException e){
           e.printStackTrace();
       }
   }

   public void deletar(Livro p){
       String sql = """
           delete from livro where id_livro = ?;
               """;
       // try - with - resources
       try(Connection con = con();
           PreparedStatement pre = con.prepareStatement(sql)){
           // Recurso bem caro
           pre.setInt(1,p.getId_livro());
           pre.execute();
           con.close();
       }catch (SQLException e){
           e.printStackTrace();
       }
   }
    public List<Livro> obterTodos(){
        List<Livro> lista = new ArrayList<>();
        String sql = """
            select id_livro, titulo, ano_publicado, id_autor from livro
            order by titulo asc;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Livro a = new Livro();
                // Selecionado um registro da consulta
                a.setId_livro(rs.getInt("id_livro"));
                a.setTitulo(rs.getString("titulo"));
                a.setAno_publicado(rs.getInt("ano_publicado"));
                a.setId_autor(rs.getInt("id_autor"));
                lista.add(a);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

}
