package j4f.server.dao;

import j4f.server.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Itword on 20.04.2017.
 */
@Repository
public interface AccountDAO extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
    Account findByNickname(String nickname);
}
