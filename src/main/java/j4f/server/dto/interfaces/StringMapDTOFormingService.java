package j4f.server.dto.interfaces;

import j4f.server.dto.interfaces.DTOFormingService;

import java.util.Map;

/**
 * Created by Itword on 21.04.2017.
 */
public interface StringMapDTOFormingService<O> extends DTOFormingService<Map<String,String>, O> {
    @Override
    Map<String, String> getDTO(O o);
}
