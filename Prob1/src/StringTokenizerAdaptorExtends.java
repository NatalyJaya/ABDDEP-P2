import java.util.Enumeration;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * Solución A.2: Adapter por Herencia (Ser un...)
 *
 * <p>
 * Esta alternativa aplica el patrón Adapter utilizando herencia en lugar
 * de composición. En este caso, la clase adaptadora hereda directamente
 * de StringTokenizer e implementa simultáneamente la interfaz Iterator.
 * </p>
 *
 * <p>
 * El funcionamiento es el siguiente:
 * </p>
 *
 * <ol>
 *   <li>
 *     Crear una clase que extienda StringTokenizer. -> exends StringTokenizer
 *   </li>
 *
 *   <li>
 *     Implementar la interfaz Iterator para que el sistema pueda
 *     tratar el objeto como un iterador válido. -> implements Iterator<Object>
 *   </li>
 *
 *   <li>
 *     Traducir las llamadas utilizando los métodos heredados:
 *     <ul>
 *       <li>hasNext() → super.hasMoreElements()</li>
 *       <li>next() → super.nextElement()</li>
 *     </ul>
 *   </li>
 * </ol>
 *
 * <p>
 * Gracias a la herencia, la clase adaptadora ya es un StringTokenizer,
 * por lo que puede reutilizar directamente su comportamiento original.
 * </p>
 *
 * <p>
 * Igual que en la solución por composición, el método remove() suele
 * lanzar UnsupportedOperationException debido a que StringTokenizer
 * y Enumeration no soportan eliminación de elementos.
 * </p>
 */

public class StringTokenizerAdaptorExtends extends StringTokenizer implements Iterator<Object> {


    public StringTokenizerAdaptorExtends(String str, String delim, boolean returnDelims) {
        super(str, delim, returnDelims);

    }

    public StringTokenizerAdaptorExtends(String str, String delim){
        super(str,delim);

    }

    public StringTokenizerAdaptorExtends(String str){
        super(str);

    }

    // Metodos de Iterator hederando funciones de StringTokenizer
    @Override
    public boolean hasNext() {
        return super.hasMoreElements();
    }

    @Override
    public Object next() {
        return super.nextElement();
    }
}
