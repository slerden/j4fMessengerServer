package j4f.server.services.classes;

import j4f.server.exceptions.UsernameIsAlreadyExistsException;
import j4f.server.services.interfaces.MessageService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Itword on 20.04.2017.
 */
@Service
public class ExceptionMessageServiceImpl implements MessageService<Exception> {

    private Map<Class, String> messageRepository = new HashMap<Class, String>();

    public ExceptionMessageServiceImpl(Map<Class, String> messageRepository) {
        this.messageRepository = messageRepository;
    }

    public ExceptionMessageServiceImpl(){
        messageRepository.put(UsernameIsAlreadyExistsException.class, "Это имя пользователя уже занято");
    }

    @Override
    public String getMessage(Exception mes) {
        return messageRepository.get(mes.getClass());
    }

    public Map<Class, String> getMessageRepository() {
        return messageRepository;
    }

    public void setMessageRepository(Map<Class, String> messageRepository) {
        this.messageRepository = messageRepository;
    }
}
