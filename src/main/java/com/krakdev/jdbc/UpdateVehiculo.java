package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UpdateVehiculo {

    private static final Logger LOGGER = LogManager.getLogger(UpdateVehiculo.class);

    public static void actualizarVehiculo(String placa, double nuevoPrecio, boolean nuevaDisponibilidad, int nuevoKilometraje) {
        String sql = "UPDATE vehiculos SET precio = ?, disponible = ?, kilometraje = ? WHERE placa = ?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, nuevoPrecio);
            ps.setBoolean(2, nuevaDisponibilidad);
            ps.setInt(3, nuevoKilometraje);
            ps.setString(4, placa);

            int filasAfectadas = ps.executeUpdate();
            LOGGER.info("Se actualizaron {} fila(s) para el vehículo con placa {}.", filasAfectadas, placa);

        } catch (SQLException e) {
            LOGGER.error("Error de SQL al actualizar el vehículo: {}", e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Error general al actualizar el vehículo: {}", e.getMessage());
        }
    }
}