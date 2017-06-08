package j4f.server.dto.interfaces;

/**
 * Created by Itword on 21.04.2017.
 */
public interface DTOFormingService<T,O> {
    T getDTO(O o);
}
