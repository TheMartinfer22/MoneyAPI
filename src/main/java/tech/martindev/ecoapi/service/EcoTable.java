package tech.martindev.ecoapi.service;

import lombok.SneakyThrows;
import tech.martindev.ecoapi.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.Statement;

public class EcoTable {
    @SneakyThrows
    public EcoTable() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS ECO_SYSTEM (id serial PRIMARY KEY, player varchar(255), saldo INTEGER)");
        statement.close();
        connection.close();
    }
}
