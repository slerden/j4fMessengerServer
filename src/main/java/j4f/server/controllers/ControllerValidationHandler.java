package j4f.server.controllers;

import j4f.server.dto.classes.dtorepository.MessageDTO;
import j4f.server.exceptions.UsernameIsAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * Created by Itword on 23.04.2017.
 */
@ControllerAdvice
public class ControllerValidationHandler {

    @Autowired
    MessageSource messageSource;

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public MessageDTO processValidatorError(MethodArgumentNotValidException ex){
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldError = result.getFieldErrors();

        return proccessFieldError(fieldError);
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public MessageDTO processConstaraintViolationException(ConstraintViolationException ex){
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        String result = "";
        Locale locale = LocaleContextHolder.getLocale();
        for (ConstraintViolation<?> constraintViolation : constraintViolations) {
            result += messageSource.getMessage(constraintViolation.getMessage(), null, locale)+" ";
        }

        return new MessageDTO(result, MessageDTO.Type.ERROR);
    }



    private MessageDTO proccessFieldError(List<FieldError> error){
        MessageDTO dto = null;
        if(error != null){
            Locale currentLocale = LocaleContextHolder.getLocale();
            String msg = "";
            for (FieldError fieldError : error) {
                msg +=messageSource.getMessage(fieldError.getDefaultMessage(), null, currentLocale) + "\n";
            }
            return new MessageDTO(msg, MessageDTO.Type.ERROR);
        }
        return null;
    }

}
