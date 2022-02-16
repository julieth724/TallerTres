package Sofka.com;
import java.util.Date;

/**
 *Clase de interfaz
 * @author Angela Julieth Ossa Cuellar
 */
public interface ILibraryForm {


    public void Id();
    public String nameSong(String nameSong);
    public Date CreationDate(int creationDate);
    public int Duration(int duration);
    public String Genre(String genre);
    public String CareName(String careName);
    public String Description(String description);

}
