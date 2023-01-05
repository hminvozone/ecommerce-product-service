package invozone.ecommerce.shopping.utils;

import invozone.ecommerce.shopping.enums.Responses;
import invozone.ecommerce.shopping.exceptions.GeneralResponse;
import org.modelmapper.Condition;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class Utility {

    public static ModelMapper getMapperObject(){
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull()).setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

    public static Map<String, Object> getResponseError(String code, String responses) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put(Constant.STATUS, code);
        response.put(Constant.MESSAGE, responses);
        return response;
    }

    public static Map<String, Object> getResponseError(GeneralResponse responses) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put(Constant.STATUS, responses.getStatus());
        response.put(Constant.MESSAGE, responses.getMessage());
        return response;
    }

    public static Map<String, Object> getResponse(Responses responses, String message, Object data) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put(Constant.STATUS, responses.getStatus());
        if(!message.trim().equalsIgnoreCase("")) {
            response.put(Constant.MESSAGE, message);
        }
        if(data != null) {
            response.put(Constant.RESULT, data);
        }
        return response;
    }
}
