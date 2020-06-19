package com.colegio.idao;

import com.colegio.model.Empleado;
import java.util.List;

public interface IEmpleadoDAO {
    
    public List<Empleado> ListarEmpleados();
    public boolean RegistrarEmpleado(Empleado objEmpleado);
    public boolean ActualizarEmpleado(Empleado objEmpleado);
    public boolean EliminarEmpleado(String id_empleado);
    public Empleado ObtenerEmpleado(String id_empleado);

}
