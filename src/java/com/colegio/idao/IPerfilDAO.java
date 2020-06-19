package com.colegio.idao;

import com.colegio.model.Perfil;
import java.util.List;

public interface IPerfilDAO {
    
    public List<Perfil> ListarPerfiles();
    public boolean RegistrarPerfil(Perfil objPerfil);
    public boolean ActualizarPerfil(Perfil objPerfil);
    public boolean EliminarPerfil(int id_perfil);
    public Perfil ObtenerPerfil(int id_perfil);
    
}
