package j4f.server.dto.classes.dtorepository;

/**
 * Created by Itword on 23.04.2017.
 */
public class MessageDTO {

    public MessageDTO() {
    }

    public MessageDTO(String message, Type messageType) {
        this.message = message;
        this.messageType = messageType;
    }

    private String message;

    private MessageDTO.Type messageType;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Type getMessageType() {
        return messageType;
    }

    public void setMessageType(Type messageType) {
        this.messageType = messageType;
    }
    public enum Type{
        SUCCESS, ERROR
    }
}
