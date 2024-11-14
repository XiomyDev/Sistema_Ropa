package pe.edu.utp.sistemaropa.dao;

/**
 *
 * @author Nayely
 *  * @param <T>
 */
import java.util.List;
import java.util.Map;

public interface Operaciones<T> {

    int create(T t);

    int update(T t);

    int delete(int index);

    T read(int index);

    T Buscador(int index);

    List<T> readAll();

    List<T> readAllDisponible();

    List<Map<String, Object>> readAll2();
}
