package org.serratec.backend.ProjetoFinal.handlers;

import org.serratec.backend.ProjetoFinal.domain.ErroResposta;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MethodArgumentNotValidExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErroResposta corpoDaRespostaDoErro = new ErroResposta();
        corpoDaRespostaDoErro.setStatus("" + status.value());
        corpoDaRespostaDoErro.setTitulo("Ocorreu um erro na validação do campos");

        List<String> listaErrosTemporaria = new ArrayList<>();
        for (FieldError erroAtual : ex.getBindingResult().getFieldErrors()) {
            listaErrosTemporaria.add(erroAtual.getDefaultMessage());
        }

        corpoDaRespostaDoErro.setTextosSobreOsErros(listaErrosTemporaria);

        return super.handleExceptionInternal(ex, corpoDaRespostaDoErro, headers, status, request);
    }
}