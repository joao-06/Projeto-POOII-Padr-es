/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade.pkg2.de.lp2.padrões;

import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public abstract class Semestre implements Evenlist{
    private String nome;
    private boolean ativo;
    private ArrayList<Observer> observadores;
    
    public Semestre (String nome, boolean ativo){
        this.nome = nome;
        this.ativo = ativo;
    } 

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    void add(Semestre semestre) {
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
        notifyObservers();
    }
    
    public void exibirDados(){
        System.out.print(+"Semestre: " +nome+ ", Ativo: " +(ativo ? "Sim" " Não"));
    }
    
   
public void addObserver (Observer observer){
    observadores.add(observer);
}
  
public void removeObserver (Observer observer){
    observadores.remove(observer);
}

public void notifyObservers(){
    for(int i = 0 ; i< observadores.size(); i++){
        observadores.get(i).update(ativo);
    }
}
}
