package source.usecases.dto.output;

import lombok.Data;

@Data
public class OutputBase {

    @Data
    private class Error {
        private String message;
    }

    private Error error;

}
