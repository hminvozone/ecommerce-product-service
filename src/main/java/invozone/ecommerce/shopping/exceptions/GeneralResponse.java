package invozone.ecommerce.shopping.exceptions;

import lombok.Getter;
import lombok.Setter;

public class GeneralResponse {

    public GeneralResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    @Getter
    @Setter
    private String status;
    @Getter
    @Setter
    private String message;

    public String getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void setMessage(String message) {
         this.message = message;
    }
}
