import java.util.Observable;
import java.util.Observer;

public class FileWritterPull implements Observer {

    // implementar la logica de escribir en un fichero

    @Override
    public void update(Observable o, Object arg) {
        // ------------------- PULL (no argumentos) ------------------------
        Sale sale = (Sale) o;
        // Datos que necesitamos i no nos lo proveen: Nombre, precio unitario y el total
        SLI item = ((Sale) o).getLastItem();
        String name = item.getDesription().getDescription();
        int unitPrice = item.getDesription().getPrice();
        int totalPrice = sale.getTotalPrice();
    }

}
