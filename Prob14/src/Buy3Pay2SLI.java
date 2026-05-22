
// EJEMPLO DE UNA SUBCLASE -> SUBCLASE DE SLI -> extends SLI
public class Buy3Pay2SLI extends SLI{

    // Constructor con los param de SLI
    public Buy3Pay2SLI(ProductDescription desc,int quantity ){
        super(desc, quantity); // SUPER
    }

    @Override
    public int subTotal() { // subtotal personalizado
        int subtotal = quantity - (quantity/3);
        return subtotal * desc.getPrice();

    }
}
