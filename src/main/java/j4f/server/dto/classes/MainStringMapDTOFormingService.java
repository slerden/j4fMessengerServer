package j4f.server.dto.classes;

import j4f.server.dto.classes.dtorepository.AccountStringMapDTOFormingServiceImpl;
import j4f.server.dto.interfaces.StringMapDTOFormingService;
import j4f.server.models.Account;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Itword on 21.04.2017.
 */
@Service
public class MainStringMapDTOFormingService implements StringMapDTOFormingService<Object> {

    private Map<Class, StringMapDTOFormingService> serviceMap;

    public MainStringMapDTOFormingService() {
        serviceMap = new HashMap<Class, StringMapDTOFormingService>();
        serviceMap.put(Account.class, new AccountStringMapDTOFormingServiceImpl());
    }

    @Override
    public Map<String, String> getDTO(Object o) {
        if(o == null) return null;
        StringMapDTOFormingService dto = serviceMap.get(o.getClass());
        if(dto == null) throw new RuntimeException("DTO for this object was not found");
        return dto.getDTO(o);
    }




}
