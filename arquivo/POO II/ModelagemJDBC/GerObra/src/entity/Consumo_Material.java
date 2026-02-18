package entity;

public class Consumo_Material {
    private int id_projeto;
    private int id_material;
    
    public Consumo_Material(int id_projeto, int id_material) {
        this.id_projeto = id_projeto;
        this.id_material = id_material;
    }

    public int getId_projeto() {
        return id_projeto;
    }
    public void setId_projeto(int id_projeto) {
        this.id_projeto = id_projeto;
    }
    public int getId_material() {
        return id_material;
    }
    public void setId_material(int id_material) {
        this.id_material = id_material;
    }

    @Override
    public String toString() {
        return "Consumo_Material [id_projeto=" + id_projeto + ", id_material=" + id_material + "]";
    }
}
