package br.edu.cesarschool.next.oo.entidade;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

public abstract class RegistroIdentificavel implements Serializable{
    public abstract String obterChave();
    private LocalDateTime dataHoraCriacao; 
    
    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

     public long obterTempoDeCriacao() {
        /*calcular, EM DIAS, a diferença entre a
        dataHoraCriacao (o atributo recém criado) e a data atual. Pesquisar como obter esta
        diferença e como obter a data atual. ATENÇÃO! A solução pode estar dentro do próprio tipo
        LocalDateTime, que já é o tipo do atributo dataHoraCriacao. */
        LocalDateTime dataAtual = LocalDateTime.now(); 
        Duration duracao = Duration.between( dataHoraCriacao, dataAtual);
        return duracao.toDays();
    }
}
