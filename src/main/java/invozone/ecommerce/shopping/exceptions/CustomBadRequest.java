package invozone.ecommerce.shopping.exceptions;

import org.springframework.stereotype.Component;

@Component
public class CustomBadRequest extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String code;
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CustomBadRequest(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public CustomBadRequest() {
    }
}