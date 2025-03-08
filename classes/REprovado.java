package classes;

public class Reprovado implements IEstadoAluno{

    public void addNota(AlunoTurma alunoTurma, Nota nota){
        @Override
    public void exibirSituacao() {
        System.out.println("Aluno está Reprovado.");
    }

    @Override
    public void verificarEstado(AlunoTurma nota) {
        if (aluno.getNotaRecuperacao() >= 2.5) {
            aluno.setEstado(new Recuperacao());
        }
    }
    }
    
}