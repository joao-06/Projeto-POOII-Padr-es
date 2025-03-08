package classes;

public class Recuperacao implements IEstadoAluno{
public void addNota(AlunoTurma alunoTurma, Nota nota){
    alunoTurma.setNotaRecuperacao(nota);
}
    
}