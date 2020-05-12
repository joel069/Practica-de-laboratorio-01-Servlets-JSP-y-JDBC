package datos;



import modelo.Telefono;
import java.util.Set;


public interface TelefonoDAO extends GenericDAO<Telefono , String> {

public abstract Set<Telefono> buscarCedula(String cedula);
	
	public abstract Telefono buscarCodigo(int codigo);
}
