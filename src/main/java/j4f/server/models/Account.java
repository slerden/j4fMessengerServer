package j4f.server.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import j4f.server.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

/**
 * Created by Itword on 20.04.2017.
 */
@Entity
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Account() {
    }

    public Account(String username, String password, String nickname) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }

    @Size(message = "account.username.size", min = 3, max = 32)
    @NotNull(message = "account.username.notnull")
    @Column(unique = true)
    private String username;

    @Size(message = "account.password.size", min = 3, max = 32)
    @NotNull(message = "account.password.notnull")
    @Column
    private String password;

    @Size(message = "account.nickname.size", min = 3, max = 32)
    @NotNull(message = "account.nickname.notnull")
    @Column
    private String nickname;

    @ManyToMany
    @JoinTable(name = "account_friends",
            joinColumns = {@JoinColumn(name = "account_id")},
            inverseJoinColumns = {@JoinColumn(name = "friend_account_id")})
    private List<Account> friends;

    @ManyToMany(mappedBy = "friends")
    private List<Account> friendTo;



    public List<Account> getFriends() {
        return friends;
    }

    public void setFriends(List<Account> friends) {
        this.friends = friends;
    }

    public List<Account> getFriendTo() {
        return friendTo;
    }

    public void setFriendTo(List<Account> friendTo) {
        this.friendTo = friendTo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
