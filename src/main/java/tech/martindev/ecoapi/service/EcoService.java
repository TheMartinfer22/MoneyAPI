package tech.martindev.ecoapi.service;

import lombok.SneakyThrows;
import tech.martindev.ecoapi.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class EcoService {
    @SneakyThrows
    public void criarConta(String player) {
        if (player == null) return;
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM ECO_SYSTEM WHERE player = '" + player + "'");
        if (!rs.next()){
            statement.execute("INSERT INTO ECO_SYSTEM (player, saldo) VALUES ('" + player + "', 0)");
        }
        connection.close();
        statement.close();
        rs.close();
    }

    @SneakyThrows
    public void deletarConta(String player) {
        if (player == null) return;
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM ECO_SYSTEM WHERE player = '" + player + "'");
        if (rs.next()){
            statement.execute("DELETE FROM ECO_SYSTEM WHERE player = '" + player + "'");
        }
        connection.close();
        statement.close();
        rs.close();
    }

    @SneakyThrows
    public Integer consultar(String player){
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM ECO_SYSTEM WHERE player = '" + player + "'");
        if(rs.next()){
            return rs.getInt("saldo");
        }
        connection.close();
        statement.close();
        rs.close();
        return 0;
    }

    @SneakyThrows
    public void adicionar(String player, Integer valor){
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM ECO_SYSTEM WHERE player = '" + player + "'");
        if(rs.next()){
            int saldo = rs.getInt("saldo");
            if (valor < 0){
                statement.execute("UPDATE ECO_SYSTEM SET saldo = " + 0 + " WHERE player = '" + player + "'");
                return;
            }
            statement.execute("UPDATE ECO_SYSTEM SET saldo = " + (saldo + valor) + " WHERE player = '" + player + "'");
        }
        connection.close();
        statement.close();
        rs.close();
    }

    @SneakyThrows
    public void diminuir(String player, Integer valor){
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM ECO_SYSTEM WHERE player = '" + player + "'");
        if(rs.next()){
            int saldo = rs.getInt("saldo");
            if (valor < 0){
                statement.execute("UPDATE ECO_SYSTEM SET saldo = " + 0 + " WHERE player = '" + player + "'");
                return;
            }
            statement.execute("UPDATE ECO_SYSTEM SET saldo = " + (saldo - valor) + " WHERE player = '" + player + "'");
        }
        connection.close();
        statement.close();
        rs.close();
    }
}
