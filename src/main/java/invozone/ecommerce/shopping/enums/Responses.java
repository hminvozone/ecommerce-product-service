package invozone.ecommerce.shopping.enums;

import lombok.Getter;

public enum Responses {
    SUCCESS("0000", "Success")
    ;

    Responses(String status, String message) {
        // TODO Auto-generated constructor stub
        this.status = status;
        this.message = message;
    }
    @Getter
    private String status;
    @Getter
    private String message;
    public String getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }




}
