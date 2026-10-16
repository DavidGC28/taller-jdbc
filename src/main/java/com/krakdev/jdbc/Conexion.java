package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Conexion {

    
    private static final Logger LOGGER = LogManager.getLogger(Conexion.class);

    public static Connection conectar() throws Exception {
        String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/tallerjdbc2";
        String usuario = "postgres";
        String password = "12345"; 
        Connection connection = null;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, usuario, password);
            LOGGER.info("¡Conexión exitosa a la base de datos PostgreSQL (tallerjdbc2)!");
        } catch (ClassNotFoundException e) {
            LOGGER.error("Error: No se pudo encontrar el Driver de PostgreSQL: {}", e.getMessage());
            throw new Exception("No se pudo cargar el driver de PostgreSQL.");
        } catch (SQLException e) {
            LOGGER.error("Error de SQL al intentar conectar a la base de datos: {}", e.getMessage());
            throw new Exception("Error al conectar con la base de datos.");
        }

        return connection;
    }
}