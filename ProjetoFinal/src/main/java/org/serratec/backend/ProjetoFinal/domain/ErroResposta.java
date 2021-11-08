package org.serratec.backend.ProjetoFinal.domain;

import java.util.List;

public class ErroResposta {

    private String status;
    private String titulo;
    private List<String> textosSobreOsErros;

    public ErroResposta() {
    }

    public ErroResposta(String status, String titulo, List<String> textosSobreOsErros) {
        this.status = status;
        this.titulo = titulo;
        this.textosSobreOsErros = textosSobreOsErros;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public List<String> getTextosSobreOsErros() {
        return textosSobreOsErros;
    }
    public void setTextosSobreOsErros(List<String> textosSobreOsErros) {
        this.textosSobreOsErros = textosSobreOsErros;
    }
}