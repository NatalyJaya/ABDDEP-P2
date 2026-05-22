import java.util.Enumeration;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * Solución A.1: Adapter por Composición (Tener un...)
 *
 * <p>
 * Esta es la forma más común y recomendada de aplicar el patrón Adapter.
 * El objetivo es permitir que una clase incompatible, como StringTokenizer
 * (que implementa Enumeration), pueda utilizarse en contextos donde se
 * requiere un Iterator.
 * </p>
 *
 * <p>
 * El funcionamiento es el siguiente:
 * </p>
 *
 * <ol>
 *   <li>
 *     Crear una clase adaptadora que implemente la interfaz requerida
 *     por el sistema, en este caso Iterator.
 *   </li>
 *
 *   <li>
 *     Guardar internamente una referencia al objeto incompatible
 *     (StringTokenizer o Enumeration), recibido normalmente mediante
 *     el constructor.
 *   </li>
 *
 *   <li>
 *     Traducir las llamadas de los métodos:
 *     <ul>
 *       <li>hasNext() → hasMoreElements()</li>
 *       <li>next() → nextElement()</li>
 *     </ul>
 *   </li>
 * </ol>
 *
 * <p>
 * De esta forma, el sistema puede trabajar con un Iterator sin necesidad
 * de modificar la implementación original de StringTokenizer.
 * </p>
 *
 * <p>
 * La operación remove() no puede implementarse directamente porque
 * Enumeration no dispone de un método equivalente. Por ello, es habitual
 * lanzar UnsupportedOperationException.
 * </p>
 */
public class StringTokenizerAdaptor implements Iterator<Object> {

    private StringTokenizer str;

    // Constructor privado
    private StringTokenizerAdaptor(StringTokenizer str) {
        this.str = str;
    }

    // Metodos de Iterator usando funciones de StringTokenizer
    @Override
    public boolean hasNext() {
        return str.hasMoreElements();
    }

    @Override
    public Object next() {
        return str.nextElement();
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }


}
