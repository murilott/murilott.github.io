package dao;

import entity.Autor;
import entity.Livro;
import entity.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AutorDAO extends BaseDAO {

    public void inserir(Autor a){
        String sql = """
            insert into autor(nome, nacionalidade) values(?, ?);
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            pre.setString(1,a.getNome());
            pre.setString(2,a.getNacionalidade());
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizar(Autor a){
        String sql = """
            update autor set nome = ?, nacionalidade = ? where id_autor = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            pre.setString(1,a.getNome());
            pre.setString(2,a.getNacionalidade());
            pre.setInt(3,a.getId_autor());
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletar(Autor a){
        String sql = """
            delete from autor where id_autor = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            pre.setInt(1, a.getId_autor());
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Autor> obterTodos(){
        List<Autor> lista = new ArrayList<>();
        String sql = """
            select id_autor, nome, nacionalidade from autor
            order by nome asc;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Autor a = new Autor();
                // Selecionado um registro da consulta
                a.setId_autor(rs.getInt("id_autor"));
                a.setNome(rs.getString("nome"));
                a.setNacionalidade(rs.getString("nacionalidade"));
                lista.add(a);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

    public Autor getAutor(int id){
        String sql = """
            select id_autor, nome, nacionalidade from autor
            where id_autor = ?
            order by nome asc;
                """;
        Autor a = new Autor();
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setInt(1, id);

            // Recurso bem caro
            ResultSet rs = pre.executeQuery();
            if(rs.next()){

                // Selecionado um registro da consulta
                a.setId_autor(rs.getInt("id_autor"));
                a.setNome(rs.getString("nome"));
                a.setNacionalidade(rs.getString("nacionalidade"));
//                return Optional.of(a);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println(a.getNome());
        return a;
    }



    public List<Livro> listarLivros(Autor a){
        List<Livro> lista = new ArrayList<>();
        String sql = """
            select id_livro, titulo, ano_publicado from livro
            where livro.id_autor = ?
            """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setInt(1, a.getId_autor());

            // Recurso bem caro
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                System.out.println("dentro rs");
                Livro liv = new Livro();
                // Selecionado um registro da consulta
                liv.setId_livro(rs.getInt("id_livro"));
//                liv.setId_autor(rs.getInt("id_autor"));
                liv.setTitulo(rs.getString("titulo"));
                liv.setAno_publicado(rs.getInt("ano_publicado"));
                System.out.println(liv.getTitulo());
                lista.add(liv);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

}
