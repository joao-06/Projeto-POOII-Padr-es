package classes;

import java.util.ArrayList;
import java.util.List;

public class Semestre {

    private String nome;
    private boolean ativo;
    private final List<Observer> observers;

    public Semestre(String nome, boolean ativo) {
        this.nome = nome != null ? nome : "";
        this.ativo = ativo;
        this.observers = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome != null ? nome : "";
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
        notifyObservers();
    }

    public void addObserver(Observer observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removeObserver(Observer observer) {
        if (observer != null) {
            observers.remove(observer);
        }
    }

    private void notifyObservers() {
        for (Observer o : new ArrayList<>(observers)) {
            if (o != null) {
                o.update(ativo);
            }
        }
    }
}
