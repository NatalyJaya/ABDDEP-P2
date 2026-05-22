public class NutritionFacts {

    // Todos los atributos son 'final' para garantizar la inmutabilidad del objeto creado
    private final int servingSize;   // (mL) required
    private final int servings;      // (units) required
    private final int calories;      // optional
    private final int fat;           // (g) optional
    private final int sodium;        // (mg) optional
    private final int carbohydrate;  // (g) optional

    /*
    Para evitar el anti-patrón de los constructores telescópicos (que genera ambigüedad al instanciar),
    usamos el patrón Builder.
    */

    // 1. EL CONSTRUCTOR AHORA ES PRIVADO Y RECIBE EL BUILDER
    // Es privado para prohibir el uso de "new NutritionFacts(...)" desde fuera.
    // Solo el Builder podrá llamar a este constructor.
    private NutritionFacts(Builder builder) {
        // Traspasamos la información acumulada en el Builder a los atributos finales del objeto
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
    }

    // ESTRUCTURA DE UN BUILDER
    public static class Builder {
        // --------- PARAM. OBLIGATORIOS (final, nos aseguramos de que no cambian) ------------
        private final int servingSize;   // (mL) required
        private final int servings;      // (units) required

        // --------- PARAM. NO OBLIGATORIOS (no final, para poder configurarlos) ------------
        // Inicializamos a 0 por defecto, como buena práctica
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        // Constructor del Builder - pide los parámetros obligatorios
        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        // Métodos de configuración - parámetros opcionales (UNO POR UNO)
        // Devuelven 'this' para permitir la "API fluida" (encadenamiento de llamadas)
        public Builder calories(int calories) {
            this.calories = calories;
            return this;
        }

        public Builder fat(int fat) {
            this.fat = fat;
            return this;
        }

        public Builder sodium(int sodium) {
            this.sodium = sodium;
            return this;
        }

        public Builder carbohydrate(int carbohydrate) {
            this.carbohydrate = carbohydrate;
            return this;
        }

        // Método final que construye y devuelve el objeto inmutable NutritionFacts
        public NutritionFacts build() {
            // Le pasamos 'this' (el propio Builder) al constructor privado de NutritionFacts
            return new NutritionFacts(this);
        }
    }

    // (Aquí van los getters de NutritionFacts si se necesitan, pero NUNCA setters para mantener inmutabilidad)
    public int getServingSize() { return servingSize; }
    public int getServings() { return servings; }
    public int getCalories() { return calories; }
    public int getFat() { return fat; }
    public int getSodium() { return sodium; }
    public int getCarbohydrate() { return carbohydrate; }
}