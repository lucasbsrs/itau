package spring.boot.desafio.itau.config;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import spring.boot.desafio.itau.exception.ValidacaoException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity<Map<String, Object>> handleValidacaoException(ValidacaoException ex) {
        Map<String, Object> erro = new HashMap<>();

        erro.put("status", 422);
        erro.put("mensagem", ex.getMessage());
        erro.put("timestamp", LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erro);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> handleBodyVazioOuMalformado(HttpMessageNotReadableException ex) {
        Map<String, Object> erro = new HashMap<>();
        erro.put("status", 400);
        erro.put("mensagem", "Corpo da requisição ausente, vazio ou malformado.");
        erro.put("timestamp", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

}
