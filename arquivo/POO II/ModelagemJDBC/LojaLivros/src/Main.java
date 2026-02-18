import dao.AutorDAO;
import entity.Autor;
import dao.LivroDAO;
import entity.Livro;

import java.sql.*;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:sqlite:meu_banco.db";
        try{
            Connection con = DriverManager.getConnection(url);
            System.out.println("Conectou!");

//            String drop = """
//                    drop table autor;
//                    drop table livro;
//                    """;
//            Statement stat = con.createStatement();
//            stat.execute(drop);

            String create = """
                    create table if not exists autor(
                      id_autor integer primary key autoincrement,
                      nome varchar(250),
                      nacionalidade varchar(200)
                    );
                    """;
            Statement stat = con.createStatement();
            stat.execute(create);

            create = """
                    create table if not exists livro(
                        id_livro integer primary key autoincrement,
                        titulo varchar(250),
                        ano_publicado int,
                        id_autor int,
                        foreign key (id_autor) references autor(id_autor)
                       );
                    """;
            stat = con.createStatement();
            stat.execute(create);

            System.out.println("Fim");
        }catch (SQLException e){
            e.printStackTrace();
        }

//        Optional<Pessoa> opt = dao.obterPeloId(2);

        AutorDAO autDao = new AutorDAO();

        Autor autor = new Autor();
//        autor.setId_autor(1);
        autor.setNome("Autor 2");
        autor.setNacionalidade("Switzerland");

//        autDao.inserir(autor);

        LivroDAO livDao = new LivroDAO();

        Livro livro = new Livro();
//        livro.setId_livro(2);
        livro.setTitulo("Livro 4");
        livro.setAno_publicado(2003);
        livro.setId_autor(2);

//        livDao.inserir(livro);

        for(Livro li : autDao.listarLivros((autDao.getAutor(1)))) {
            System.out.println(li.getTitulo());
            System.out.println(li.getAno_publicado());
            System.out.println(li.getId_autor());
        }
    }
}