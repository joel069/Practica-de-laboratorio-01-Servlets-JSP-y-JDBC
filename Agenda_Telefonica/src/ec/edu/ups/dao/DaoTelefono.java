package ec.edu.ups.dao;


import java.util.List;

 

import ec.edu.ups.modelo.telefono;

 

public interface DaoTelefono extends GenericDAO<telefono, Integer> {

 

    public abstract List<telefono> findByPersonaId(String cedula);
    public abstract List<telefono> findBySearchTelf(String cedula, String numero);
    

	

 

}