package com.krakdev.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeleteVehiculo {

    private static final Logger LOGGER = LogManager.getLogger(DeleteVehiculo.class);

    public static void eliminar(String placa) {
        String sql = "DELETE FROM vehiculos WHERE placa = ?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, placa);

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                LOGGER.info("¡Vehículo con placa {} eliminado exitosamente!", placa);
            } else {
                LOGGER.warn("No se encontró ningún vehículo registrado con la placa {}.", placa);
            }

        } catch (SQLException e) {
            LOGGER.error("Error de SQL al intentar eliminar el vehículo: {}", e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Error general al intentar eliminar el vehículo: {}", e.getMessage());
        }
    }
}
