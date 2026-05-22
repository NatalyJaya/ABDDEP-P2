public class Register {
    private Store store;
    private Sale currentSale;

    public Register(Store store){
        this.store = store;
    }

    public void createNewSale() {
        currentSale = new Sale();

        //añadimos para que avise
        FileWritterPull pullObserver = new FileWritterPull();
        FileWritterPush pushObserver = new FileWritterPush();

        // 3. ¡Los conectamos! Los añadimos a la lista interna del Observable
        currentSale.addObserver(pullObserver);
        currentSale.addObserver(pushObserver);
    }

}