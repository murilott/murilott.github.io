package entity;

public class Alocacao_Operario {
    private int id_projeto;
    private int id_operario;
    
    public Alocacao_Operario(int id_projeto, int id_operario) {
        this.id_projeto = id_projeto;
        this.id_operario = id_operario;
    }

    public int getId_projeto() {
        return id_projeto;
    }
    public void setId_projeto(int id_projeto) {
        this.id_projeto = id_projeto;
    }
    public int getId_operario() {
        return id_operario;
    }
    public void setId_operario(int id_operario) {
        this.id_operario = id_operario;
    }

    @Override
    public String toString() {
        return "Alocacao_Operario [id_projeto=" + id_projeto + ", id_operario=" + id_operario + "]";
    }
}
