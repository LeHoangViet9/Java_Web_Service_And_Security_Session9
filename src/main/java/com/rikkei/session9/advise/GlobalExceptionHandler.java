package com.rikkei.session9.advise;

import com.rikkei.session9.custom_validator.InvalidFileException;
import com.rikkei.session9.model.dto.response.ApiDataResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiDataResponse<Map<String, String>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String,String> errors=new TreeMap<>();
        for(int i=0;i<ex.getBindingResult().getFieldErrors().size();i++){
            ObjectError objectError=ex.getBindingResult().getFieldErrors().get(i);
            errors.put("Errors: "+(i+1),objectError.getDefaultMessage());
        }
        return new ResponseEntity<>(new ApiDataResponse<>(
               "Failure",
                "Lỗi dữ liệu",
                errors

        ),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidFileException.class)
    public ResponseEntity<?> handleInvalidFile(
            InvalidFileException ex
    ) {

        Map<String, String> error = new HashMap<>();

        error.put("message", ex.getMessage());

        return new ResponseEntity<>(
                error,
                HttpStatus.BAD_REQUEST
        );
    }
}
