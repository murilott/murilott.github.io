package entity;

public class Equipamento {
    private int id_equipamento;
    private String nome_equipamento;
    private String tipo;
    
    public Equipamento(String nome_equipamento, String tipo) {
        this.nome_equipamento = nome_equipamento;
        this.tipo = tipo;
    }

    public int getId_equipamento() {
        return id_equipamento;
    }
    public void setId_equipamento(int id_equipamento) {
        this.id_equipamento = id_equipamento;
    }
    public String getNome_equipamento() {
        return nome_equipamento;
    }
    public void setNome_equipamento(String nome_equipamento) {
        this.nome_equipamento = nome_equipamento;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Equipamento [id_equipamento=" + id_equipamento + ", nome_equipamento=" + nome_equipamento + ", tipo="
                + tipo + "]";
    }
}
