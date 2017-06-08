package j4f.server.controllers;

import j4f.server.dao.AccountDAO;
import j4f.server.dto.interfaces.StringMapDTOFormingService;
import j4f.server.enums.MessageEnum;
import j4f.server.exceptions.UsernameIsAlreadyExistsException;
import j4f.server.models.Account;
import j4f.server.services.interfaces.MessageService;
import j4f.server.services.interfaces.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.SmartValidator;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.CustomValidatorBean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Itword on 20.04.2017.
 */

@RestController
public class HomeController {


    @Qualifier(value = "mainStringMapDTOFormingService")
    @Autowired
    StringMapDTOFormingService<Object> dtoFormingService;

    @Autowired
    AccountDAO accountDAO;

    @Autowired
    UserRegistrationService userRegistrationService;

    @Qualifier("configuredMessageService")
    @Autowired
    MessageService exceptionMessageService;

    @Qualifier("enumMessageServiceImpl")
    @Autowired
    MessageService enumMessageService;

    @Autowired
    LocalValidatorFactoryBean localValidatorFactoryBean;

    @GetMapping(value = "/")
    public String main(){
        return "We are home";
    }

    @GetMapping(value = "/nothome")
    @Transactional
    public String nothome(){

        return "Мы не дома, ага";
    }

    @PostMapping(value = "/registerUser", produces = "application/json")
    public Account registerUser(@RequestBody Account account){

        System.out.println("User registration!");

        localValidatorFactoryBean.getValidator().validate(account);
//        try {
//            userRegistrationService.registerUser(username, password, nickname);
//            return enumMessageService.getMessage(MessageEnum.SUCCCESS_ACCOUNT_REGISTRATION);
//        } catch (UsernameIsAlreadyExistsException e) {
//            return exceptionMessageService.getMessage(e);
//        }
        return accountDAO.saveAndFlush(account);

    }

    @GetMapping(value = "/getAccount/{id}", produces = "application/json")
    public Map<String,String> getAccount(@PathVariable Long id){
        Account one = accountDAO.findOne(id);
        System.out.println("Account found: " + one.getUsername());
        return dtoFormingService.getDTO(one);
    }

}
