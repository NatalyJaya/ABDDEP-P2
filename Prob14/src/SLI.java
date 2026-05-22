
// SLI pasa a ser abstracta para que subTotal() pueda hacer cosas distintas acorde a la promo -> POLIMORFISMO
public abstract class SLI { // SLI = SalesLineItem

    //PROTECTED!: asi SLI puede verlas, y también todas sus clases hijas (subclases) como Buy3Pay2SLI o NormalSLI
    protected ProductDescription desc;
    protected int quantity;

    public SLI(ProductDescription desc, int quantity) {
        this.desc = desc;
        this.quantity = quantity;
    }

    // METODO ABSTRACTO i cada subclase ya decide como calcularlo
    public abstract int subTotal();
       // return desc.getPrice() * quantity; // LO QUITAMOS Y ES ABSTRACT


    public ProductDescription getDesription(){
        return this.desc;
    }


}