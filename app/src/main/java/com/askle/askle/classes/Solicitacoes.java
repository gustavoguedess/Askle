package com.askle.askle.classes;

/**
 * Created by ismae on 02/12/2017.
 */

public class Solicitacoes {


    private String nomePessoa;
    private String rgPessoa;
    private String dataConsulta;
    private String medicoConsulta;
    private String horarioConsulta;
    private String dataNascimento;
    private EstadoAtual estado;
        //métodos


}
enum EstadoAtual {

    PORCONSULTAR{
        @Override
        public String toString() {
            return "Fazendo";
        }
    }, CONSULTADO{
        @Override
        public String toString() {
            return "finalizado";
        }
    };
}