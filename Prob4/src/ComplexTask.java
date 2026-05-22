import java.util.List;
import java.util.ArrayList;

public class ComplexTask implements Task {

    // 1. LA CLAVE: La lista es de 'Task' (la interfaz).
    // Así acepta tanto SimpleTask como ComplexTask.
    private List<Task> tasks = new ArrayList<>();

    // AÑADIMOS UNA SOLA tarea, que sea de tipo 'Task'
    public void addSubtask(Task t){
        tasks.add(t);
    }

    @Override
    public int costInEuros() {
        int cost = 0;
        for (Task t : tasks){
            cost += t.costInEuros();
        }

        return cost;
    }


    @Override
    public int durationInDays() {
        return 0;
    }
}
