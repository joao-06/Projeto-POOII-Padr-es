package classes;

import java.util.ArrayList;
import java.util.List;

public class Nota implements Observer {

    private Double nota1;
    private Double nota2;
    private Double nota3;
    private Double notaRecuperacao;
    private boolean estadoNota;
    private final List<Observer> observers;

    public Nota() {
        this.nota1 = 0.0;
        this.nota2 = 0.0;
        this.nota3 = 0.0;
        this.notaRecuperacao = 0.0;
        this.estadoNota = true;
        this.observers = new ArrayList<>();
    }

    public Double getNota1() {
        return nota1;
    }

    public void setNota1(Double nota1) {
        if (estadoNota) {
            this.nota1 = nota1 != null ? nota1 : 0.0;
            notificarObservadores();
        }
    }

    public Double getNota2() {
        return nota2;
    }

    public void setNota2(Double nota2) {
        if (estadoNota) {
            this.nota2 = nota2 != null ? nota2 : 0.0;
            notificarObservadores();
        }
    }

    public Double getNota3() {
        return nota3;
    }

    public void setNota3(Double nota3) {
        if (estadoNota) {
            this.nota3 = nota3 != null ? nota3 : 0.0;
            notificarObservadores();
        }
    }

    public Double getNotaRecuperacao() {
        return notaRecuperacao;
    }

    public void setNotaRecuperacao(Double notaRecuperacao) {
        if (estadoNota) {
            this.notaRecuperacao = notaRecuperacao != null ? notaRecuperacao : 0.0;
            notificarObservadores();
        }
    }

    public boolean isEstadoNota() {
        return estadoNota;
    }

    public void setEstadoNota(boolean estadoNota) {
        if (this.estadoNota != estadoNota) { // Evita notificações desnecessárias
            this.estadoNota = estadoNota;
            notificarObservadores();
        }
    }

    public double calcularMedia() {
        double mediaInicial = (nota1 + nota2 + nota3) / 3;
        if (notaRecuperacao > 0) {
            return (mediaInicial + notaRecuperacao) / 2;
        }
        return mediaInicial;
    }

    public String verificarSituacao() {
        double media = calcularMedia();
        if (media < 2.5) {
            return "Reprovado"; 
        }else if (media < 7) {
            return "Em recuperação"; 
        }else {
            return "Aprovado";
        }
    }

    @Override
    public void update(boolean param) {
        this.estadoNota = param; // Atualiza sem notificar novamente
    }

    public void adicionarObservador(Observer observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    private void notificarObservadores() {
        for (Observer o : new ArrayList<>(observers)) {
            if (o != null && o != this) { // Evita notificar a si mesmo
                o.update(estadoNota);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Nota 1: %.2f, Nota 2: %.2f, Nota 3: %.2f, Recuperação: %.2f, Média: %.2f, Situação: %s",
                nota1, nota2, nota3, notaRecuperacao, calcularMedia(), verificarSituacao());
    }
}
