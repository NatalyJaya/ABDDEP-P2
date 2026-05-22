public class SimpleTask implements Task{

    // Declaramos atributos necesarios que detectamos en el interface
    private Money euros;
    private int days;

    //Constructor
    private SimpleTask (Money euros, int days){
        this.euros = euros;
        this.days = days;
    }

    @Override
    public int costInEuros() {
        return this.euros;
    }

    @Override
    public int durationInDays() {
        return this.days;
    }
}
