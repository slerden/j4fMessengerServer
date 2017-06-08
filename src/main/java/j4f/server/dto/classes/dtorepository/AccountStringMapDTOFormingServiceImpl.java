package j4f.server.dto.classes.dtorepository;

import j4f.server.dto.interfaces.StringMapDTOFormingService;
import j4f.server.models.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Itword on 21.04.2017.
 */
@Service
public class AccountStringMapDTOFormingServiceImpl implements StringMapDTOFormingService<Account> {

    Logger logger = LogManager.getLogger(this);

    @Override
    public Map<String, String> getDTO(Account o) {
        logger.debug("getDTO for account: ", o.getUsername());
        Map<String, String> result = new HashMap<String, String>();
        result.put("username",o.getUsername());
        result.put("nickname", o.getNickname());
        result.put("id", String.valueOf(o.getId()));
        return result;
    }
}
