//metodo factory - swtch
public class SLIFactory {
    public static SLI createSLI(ProductDescription desc, int quantity){
        switch(desc.getSliType()){
            case BUY_3_PAY_2 :
                return new Buy3Pay2SLI(desc, quantity);
            case NORMAL:
                return ...;
            case SECOND_HALF_PRICE:
                return ...;
        }
    }
}

// hasta aqui nice pero tenemos que tener en cuenta que un defecto de este implementacion es que no esta abeirta a nuevas
//implementaciones