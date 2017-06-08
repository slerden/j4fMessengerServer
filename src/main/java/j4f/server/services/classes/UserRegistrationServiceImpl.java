package j4f.server.services.classes;

import j4f.server.dao.AccountDAO;
import j4f.server.exceptions.UsernameIsAlreadyExistsException;
import j4f.server.models.Account;
import j4f.server.services.interfaces.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Itword on 20.04.2017.
 */
@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
    @Autowired
    AccountDAO accountDAO;

    @Override
    @Transactional
    public void registerUser(String username, String password, String nickname) throws UsernameIsAlreadyExistsException {
        if(accountDAO.findByUsername(username) != null) throw new UsernameIsAlreadyExistsException();
        Account account = new Account(username, password, nickname);
        accountDAO.save(account);
    }

}
