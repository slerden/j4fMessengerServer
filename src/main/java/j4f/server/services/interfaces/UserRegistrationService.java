package j4f.server.services.interfaces;

import j4f.server.exceptions.UsernameIsAlreadyExistsException;

/**
 * Created by Itword on 20.04.2017.
 */
public interface UserRegistrationService {
    public void registerUser(String username, String password, String nickname) throws UsernameIsAlreadyExistsException;
}
