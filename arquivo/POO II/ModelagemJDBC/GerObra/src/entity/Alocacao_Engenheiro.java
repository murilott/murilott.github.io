package entity;

public class Alocacao_Engenheiro {
    private int id_projeto;
    private int id_engenheiro;

    public Alocacao_Engenheiro(int id_projeto, int id_engenheiro) {
        this.id_projeto = id_projeto;
        this.id_engenheiro = id_engenheiro;
    }

    public int getId_projeto() {
        return id_projeto;
    }
    public void setId_projeto(int id_projeto) {
        this.id_projeto = id_projeto;
    }
    public int getId_engenheiro() {
        return id_engenheiro;
    }
    public void setId_engenheiro(int id_engenheiro) {
        this.id_engenheiro = id_engenheiro;
    }

    @Override
    public String toString() {
        return "Alocacao_Engenheiro [id_projeto=" + id_projeto + ", id_engenheiro=" + id_engenheiro + "]";
    }
}
