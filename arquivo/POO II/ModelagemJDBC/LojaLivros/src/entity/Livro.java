package entity;

public class Livro {
    private int id_livro;
    private String titulo;
    private int ano_publicado;
    private int id_autor;

    public int getId_livro() {
        return id_livro;
    }
    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno_publicado() {
        return ano_publicado;
    }
    public void setAno_publicado(int ano_publicado) {
        this.ano_publicado = ano_publicado;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id_livro=" + id_livro +
                ", titulo='" + titulo + '\'' +
                ", ano_publicacao='" + ano_publicado + '\'' +
                "id_autor=" + id_autor +
                '}';
    }
}
