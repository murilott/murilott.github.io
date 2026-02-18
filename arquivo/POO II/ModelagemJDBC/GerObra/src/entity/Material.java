package entity;

public class Material {
    private int id_material;
    private String nome_material;
    private int quantidade;

    public Material(String nome_material, int quantidade) {
        this.nome_material = nome_material;
        this.quantidade = quantidade;
    }

    public int getId_material() {
        return id_material;
    }
    public void setId_material(int id_material) {
        this.id_material = id_material;
    }
    public String getNome_material() {
        return nome_material;
    }
    public void setNome_material(String nome_material) {
        this.nome_material = nome_material;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Material [id_material=" + id_material + ", nome_material=" + nome_material + ", quantidade="
                + quantidade + "]";
    }
}
