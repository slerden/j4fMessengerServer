package j4f.server.exceptions;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Itword on 20.04.2017.
 */
public class UsernameIsAlreadyExistsException extends Exception{
    private Logger logger = LogManager.getLogger(this);

    public UsernameIsAlreadyExistsException(){
        logger.debug("Exception occurs while user registrated");
    }
}
