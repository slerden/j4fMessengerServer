package j4f.server.services.classes;

import j4f.server.enums.MessageEnum;
import j4f.server.services.interfaces.MessageService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Itword on 20.04.2017.
 */
@Service
public class EnumMessageServiceImpl implements MessageService<MessageEnum> {

    Map<MessageEnum, String> repositoryMap = new HashMap<MessageEnum, String>();

    public EnumMessageServiceImpl() {
        repositoryMap.put(MessageEnum.SUCCCESS_ACCOUNT_REGISTRATION, "Регистрация аккаунта выполнена успешно!");
    }



    @Override
    public String getMessage(MessageEnum mes) {
        return repositoryMap.get(mes);
    }
}
