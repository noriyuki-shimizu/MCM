package source.usecases.dto.response;

import lombok.Data;

@Data
public class ResponseBase {

    @Data
    private class Error {
        private String message;
    }

    private Error error;

}
