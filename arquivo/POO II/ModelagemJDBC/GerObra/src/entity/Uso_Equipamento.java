package entity;

public class Uso_Equipamento {
    private int id_projeto;
    private int id_equipamento;

    public Uso_Equipamento(int id_projeto, int id_equipamento) {
        this.id_projeto = id_projeto;
        this.id_equipamento = id_equipamento;
    }

    public int getId_projeto() {
        return id_projeto;
    }
    public void setId_projeto(int id_projeto) {
        this.id_projeto = id_projeto;
    }
    public int getId_equipamento() {
        return id_equipamento;
    }
    public void setId_equipamento(int id_equipamento) {
        this.id_equipamento = id_equipamento;
    }
    
    @Override
    public String toString() {
        return "Uso_Equipamento [id_projeto=" + id_projeto + ", id_equipamento=" + id_equipamento + "]";
    }
}
