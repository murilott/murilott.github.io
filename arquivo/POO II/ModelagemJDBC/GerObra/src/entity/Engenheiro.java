package entity;

public class Engenheiro {
    private int id_engenheiro;
    private String nome_engenheiro;
    private String especialidade;

    public Engenheiro(String nome_engenheiro, String especialidade) {
        this.nome_engenheiro = nome_engenheiro;
        this.especialidade = especialidade;
    }

    public int getId_engenheiro() {
        return id_engenheiro;
    }
    public void setId_engenheiro(int id_engenheiro) {
        this.id_engenheiro = id_engenheiro;
    }
    public String getNome_engenheiro() {
        return nome_engenheiro;
    }
    public void setNome_engenheiro(String nome_engenheiro) {
        this.nome_engenheiro = nome_engenheiro;
    }
    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Engenheiro [id_engenheiro=" + id_engenheiro + ", nome_engenheiro=" + nome_engenheiro
                + ", especialidade=" + especialidade + "]";
    }
}
