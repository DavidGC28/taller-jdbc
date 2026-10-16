package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertVehiculo {

    private static final Logger LOGGER = LogManager.getLogger(InsertVehiculo.class);

    public static void insertar(String placa, String marca, String modelo, int anio, double precio, String color, boolean disponible) {
        String sql = "INSERT INTO vehiculos (placa, marca, modelo, anio, precio, color, disponible) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, placa);
            ps.setString(2, marca);
            ps.setString(3, modelo);
            ps.setInt(4, anio);
            ps.setDouble(5, precio);
            ps.setString(6, color);
            ps.setBoolean(7, disponible);
            
            ps.executeUpdate();
            LOGGER.info("¡Vehículo con placa {} insertado exitosamente!", placa);
            
        } catch (SQLException e) {
            LOGGER.error("Error de SQL al insertar el vehículo: {}", e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Error general al insertar el vehículo: {}", e.getMessage());
        }
    }
}