package source;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllException(Exception e, WebRequest request) {
        return super.handleExceptionInternal(
                e,
                "API でエラーが発生しました。ログを確認してください。",
                null,
                HttpStatus.INTERNAL_SERVER_ERROR,
                request
        );
    }

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<Object> handleJsonProcessingException(JsonProcessingException jpe, WebRequest request) {
        return super.handleExceptionInternal(
                jpe,
                "JSON での変換処理でエラーが発生しました。リクエストパラメータを確認してください。",
                null,
                HttpStatus.BAD_REQUEST,
                request
        );
    }

}
