import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
// Quitamos la responsabilidad a la clase Sale i le ponemos un "especializta de fabricación"

// Sale (Cliente) ----> Pide un objeto ----> Factory (Fábrica) ----> Crea y devuelve ----> SLI (Subclase específica)


public class Sale extends Observable {
    private List<SLI> lines = new ArrayList<>();
    private int result;
    public void createSalesLineItem(ProductDescription desc, int quantity) {
        SLI sli = new SLI(desc, quantity);

        lines.add(sli);
        // Estructura del Observable
        setChanged();
        //notifyObservers(); // PULL: no pasamos argumentos, ya que no especifica que paso
        notifyObservers(sli); // PUSH: pasamos argumentos, ya que especificamos que paso (arg)
    }

    // Metodos de Observable - Getters and Setters
    public List<SLI> getSaleLineItem(){
        return this.lines;
    }

    // NOS PIDE "se añade un producto a la venta
    //actual se muestre por pantalla su nombre, precio unitario y el TOTAL ACUMULADO

    public int totalPrice(List<SLI> lines, int price) {

        for ( SLI i : lines ){
            result += i.subTotal();
        }
        return result;
    }

    // como agarramos el nuevo producto añadido, este es el ultimo
    public SLI getLastItem(){
        return lines.get(lines.size()-1);
    }
    public int getTotalPrice(){
        return this.result;
    }
    // ...
}