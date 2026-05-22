import java.util.Observable;
import java.util.Observer;

public class FileWritterPush implements Observer {

    //---------------PUSH (nos pasan cositas) ---------------
    @Override
    public void update(Observable o, Object arg) {
        Sale sale = (Sale) o;
        SLI item = (SLI) arg;
        String name = item.getDesription().getDescription();
        int unitPrice = item.getDesription().getPrice();
        int totalPrice = sale.getTotalPrice();

    }

}
