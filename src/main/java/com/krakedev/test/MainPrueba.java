package com.krakedev.test;

import com.krakdev.jdbc.DeleteVehiculo;
import com.krakdev.jdbc.InsertVehiculo;
import com.krakdev.jdbc.SelectVehiculo;
import com.krakdev.jdbc.UpdateVehiculo;

public class MainPrueba {
    public static void main(String[] args) {
        
  
        InsertVehiculo.insertar("PBX-1234", "Toyota", "Hilux", 2023, 35000.00, "Blanco", true);

        
        SelectVehiculo.listarVehiculos();

       
        UpdateVehiculo.actualizarVehiculo("PBX-1234", 33500.00, false, 16200);

        
        SelectVehiculo.listarVehiculos();

       
        DeleteVehiculo.eliminar("PBX-1234");
    }
}