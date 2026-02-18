package entity;

public class Operario {
    private int id_operario;
    private String nome_operario;
    private String funcao;
    
    public Operario(String nome_operario, String funcao) {
        this.nome_operario = nome_operario;
        this.funcao = funcao;
    }

    public int getId_operario() {
        return id_operario;
    }
    public void setId_operario(int id_operario) {
        this.id_operario = id_operario;
    }
    public String getNome_operario() {
        return nome_operario;
    }
    public void setNome_operario(String nome_operario) {
        this.nome_operario = nome_operario;
    }
    public String getfuncao() {
        return funcao;
    }
    public void setfuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return "Operario [id_operario=" + id_operario + ", nome_operario=" + nome_operario + ", funcao=" + funcao + "]";
    }

}
