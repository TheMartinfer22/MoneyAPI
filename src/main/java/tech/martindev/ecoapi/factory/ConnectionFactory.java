package tech.martindev.ecoapi.factory;

import lombok.*;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {

    @SneakyThrows
    public Connection getConnection(){
        Properties properties = new Properties();
        properties.load(new FileReader("sql.properties"));
        return DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
    }
}
