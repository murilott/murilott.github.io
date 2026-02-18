package entity;

import java.sql.Date;

public class Projeto {
    private int id_projeto;
    private String nome_projeto;
    private String local;
    private Date data_inicio;
    private Date data_termino;

    public Projeto() {
    }

    public Projeto(String nome_projeto, String local, Date data_inicio, Date data_termino) {
        this.nome_projeto = nome_projeto;
        this.local = local;
        this.data_inicio = data_inicio;
        this.data_termino = data_termino;
    }
    
    public int getId_projeto() {
        return id_projeto;
    }
    public void setId_projeto(int id_projeto) {
        this.id_projeto = id_projeto;
    }
    public String getNome_projeto() {
        return nome_projeto;
    }
    public void setNome_projeto(String nome_projeto) {
        this.nome_projeto = nome_projeto;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public Date getData_inicio() {
        return data_inicio;
    }
    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }
    public Date getData_termino() {
        return data_termino;
    }
    public void setData_termino(Date data_termino) {
        this.data_termino = data_termino;
    }

    @Override
    public String toString() {
        return "Projeto [id_projeto=" + id_projeto + ", nome_projeto=" + nome_projeto + ", local=" + local
                + ", data_inicio=" + data_inicio + ", data_termino=" + data_termino + "]";
    }
}
