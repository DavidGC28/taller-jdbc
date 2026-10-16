package com.krakdev.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SelectVehiculo {

    private static final Logger LOGGER = LogManager.getLogger(SelectVehiculo.class);

    public static void listarVehiculos() {
        String sql = "SELECT placa, marca, modelo, anio, precio, color, disponible FROM vehiculos";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            LOGGER.info("--- LISTADO DE VEHÍCULOS ---");
            while (rs.next()) {
                String placa = rs.getString("placa");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                int anio = rs.getInt("anio");
                double precio = rs.getDouble("precio");
                String color = rs.getString("color");
                boolean disponible = rs.getBoolean("disponible");

                System.out.println("Placa: " + placa + " | Marca: " + marca + " | Modelo: " + modelo + 
                                   " | Año: " + anio + " | Precio: $" + precio + " | Color: " + color + 
                                   " | Disponible: " + disponible);
            }

        } catch (SQLException e) {
            LOGGER.error("Error de SQL al consultar los vehículos: {}", e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Error general al consultar los vehículos: {}", e.getMessage());
        }
    }
}
