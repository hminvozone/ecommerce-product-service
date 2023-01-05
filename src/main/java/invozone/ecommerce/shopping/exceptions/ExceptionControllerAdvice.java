package invozone.ecommerce.shopping.exceptions;

import invozone.ecommerce.shopping.utils.Utility;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(RequestValidationException.class)
    public ResponseEntity<?> RequestValidationException(RequestValidationException requestValidationException){
        return ResponseEntity.badRequest().body(Utility.getResponseError("0017",requestValidationException.getMessage()));
    }

    @ExceptionHandler(CustomBadRequest.class)
    public ResponseEntity<?> CustomBadRequest(CustomBadRequest customBadRequest){
        GeneralResponse response = new GeneralResponse(customBadRequest.getCode(), customBadRequest.getDescription());
        return ResponseEntity.badRequest().body(Utility.getResponseError(response));
    }


}


