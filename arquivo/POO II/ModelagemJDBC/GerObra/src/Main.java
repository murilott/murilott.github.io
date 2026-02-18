import dao.*;
import entity.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:sqlite:meu_banco.db";
        try{
            Connection con = DriverManager.getConnection(url);
            System.out.println("Conectou!");

//            String drop = """
//                    drop table projeto;
//                    """;
            Statement stat = con.createStatement();
//            stat.executeUpdate(drop);

            String create = """
                    create table if not exists projeto(
                      id_projeto int primary key autoincrement,
                      nome_projeto varchar(100),
                      local varchar(100),
                      data_inicio date,
                      data_termino date
                    )

                    create table if not exists engenheiro(
                      id_engenheiro int primary key autoincrement,
                      nome_engenheiro varchar(100),
                      especialidade varchar(100)
                    )

                    create table if not exists operario(
                      id_operario int primary key autoincrement,
                      nome_operario varchar(100),
                      funcao varchar(100)
                    )

                    create table if not exists equipamento(
                      id_equipamento int primary key autoincrement,
                      nome_equipamento varchar(100),
                      tipo varchar(100)
                    )

                    create table if not exists material(
                      id_material int primary key autoincrement,
                      nome_material varchar(100),
                      quantidade int
                    )

                    create table if not exists alocacao_engenheiro(
                      id_projeto int,
                      id_engenheiro int,
                      foreign key (id_projeto) references projeto (id_projeto),
                      foreign key (id_engenheiro) references engenheiro (id_engenheiro)
                    )

                    create table if not exists alocacao_operario(
                      id_projeto int,
                      id_operario int,
                      foreign key (id_projeto) references projeto (id_projeto),
                      foreign key (id_operario) references operario (id_operario)
                    )

                    create table if not exists uso_equipamento(
                      id_projeto int,
                      id_equipamento int,
                      foreign key (id_projeto) references projeto (id_projeto),
                      foreign key (id_equipamento) references equipamento (id_equipamento)
                    )

                    create table if not exists consumo_material(
                      id_projeto int,
                      id_material int,
                      foreign key (id_projeto) references projeto (id_projeto),
                      foreign key (id_material) references material (id_material)
                    )

                    """;
            stat = con.createStatement();
            stat.execute(create);

            System.out.println("Fim");
        }catch (SQLException e){
            e.printStackTrace();
        }


        ProjetoDAO projDAO = new ProjetoDAO();
        Projeto projeto = new Projeto("Projeto 1", "Sul", new Date(2000, 01, 01), new Date(2001, 01, 01));
        projDAO.inserir(projeto);

        EngenheiroDAO engDAO = new EngenheiroDAO();
        Engenheiro engenheiro = new Engenheiro("Cleiton", "Elétrica");
        Engenheiro engenheiro2 = new Engenheiro("Tomás", "Civil");
        engDAO.inserir(engenheiro);
        engDAO.inserir(engenheiro2);

        OperarioDAO opeDAO = new OperarioDAO();
        Operario operario = new Operario("Zacarias", "Bater laje");
        opeDAO.inserir(operario);

        EquipamentoDAO equipDAO = new EquipamentoDAO();
        Equipamento equipamento = new Equipamento("Pé de cabra", "Combater aliens");
        equipDAO.inserir(equipamento);

        MaterialDAO matDAO = new MaterialDAO();
        Material material = new Material("Cimento", 5);
        matDAO.inserir(material);

        Alocacao_EngenheiroDAO alocaDAO = new Alocacao_EngenheiroDAO();
        alocaDAO.inserir(1, 1);
        alocaDAO.inserir(1, 2);


        for(Engenheiro en : alocaDAO.getEngenheirosProjeto(1)) {
            System.out.println(en.toString());
        }
    }
}