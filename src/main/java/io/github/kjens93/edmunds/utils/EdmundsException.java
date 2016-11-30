package io.github.kjens93.edmunds.utils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by kjensen on 11/20/16.
 */
public final class EdmundsException extends RuntimeException {


    @JsonCreator
    public EdmundsException(@JsonProperty("errorType") String errorType,
                            @JsonProperty("message") String message,
                            @JsonProperty("status") String status,
                            @JsonProperty("moreInfoUrl") String moreInfoUrl) {
        super(status + ": " + errorType + ": " + message + " " + moreInfoUrl);
    }

    public EdmundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public EdmundsException(Throwable cause) {
        super(cause);
    }

    public EdmundsException(String message) {
        super(message);
    }

    public EdmundsException() {
        super();
    }

}
