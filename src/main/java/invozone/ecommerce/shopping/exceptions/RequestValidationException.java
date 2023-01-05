package invozone.ecommerce.shopping.exceptions;

import lombok.ToString;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.stream.Collectors;

@ToString
public class RequestValidationException extends RuntimeException {

    private final BindingResult errors;

    public RequestValidationException(BindingResult errors) {
        this.errors = errors;
    }

    public List<String> getMessages() {
        return getValidationMessage(this.errors);
    }


    @Override
    public String getMessage() {
        //return this.getMessages().toString();
        return String.join(", ", this.getMessages());
    }


    private static List<String> getValidationMessage(BindingResult bindingResult) {
        return bindingResult.getAllErrors()
                .stream()
                .map(RequestValidationException::getValidationMessage)
                .collect(Collectors.toList());
    }

    private static String getValidationMessage(ObjectError error) {
        if (error instanceof FieldError) {
            FieldError fieldError = (FieldError) error;
            String className = fieldError.getObjectName();
            String property = fieldError.getField();
            Object invalidValue = fieldError.getRejectedValue();
            String message = fieldError.getDefaultMessage();
            //return String.format("%s.%s %s, but it was %s", className, property, message, invalidValue);
            //return String.format("%s %s, but it was %s", property, message, invalidValue);
            //return String.format("%s %s, but it was %s", property, message, invalidValue);
            return message;
        }
        return String.format("%s: %s", error.getObjectName(), error.getDefaultMessage());
    }
}