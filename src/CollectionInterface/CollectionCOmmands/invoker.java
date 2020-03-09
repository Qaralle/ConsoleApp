package CollectionInterface.CollectionCOmmands;

import java.io.FileNotFoundException;

/**
 * интерфейс, реализуемый классами Terminal, выступает посредником между пользователем и командами
 * @author Maxim Antonov and Andrey Lyubkin
 */
public interface invoker {
    void interactiveMod(String del) throws FileNotFoundException;
}
