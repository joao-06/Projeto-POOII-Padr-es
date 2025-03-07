package classes;

public class Aprovado implements EstadoAluno {
    @Override
    public void exibirSituacao() {
        System.out.println("Aluno está Aprovado.");
    }

    @Override
    public void verificarEstado(Aluno aluno) {
        if (aluno.getNotaRecuperacao() < 7) {
            aluno.setEstado(new Recuperacao());
        }
    }
}

public class Recuperacao implements EstadoAluno {
    @Override
    public void exibirSituacao() {
        System.out.println("Aluno está em Recuperação.");
    }

    @Override
    public void verificarEstado(Aluno aluno) {
        if (aluno.getNotaRecuperacao() >= 7) {
            aluno.setEstado(new Aprovado());
        } else if (aluno.getNotaRecuperacao() < 2.5) {
            aluno.setEstado(new Reprovado());
        }
    }
}

public class Reprovado implements EstadoAluno {
    @Override
    public void exibirSituacao() {
        System.out.println("Aluno está Reprovado.");
    }

    @Override
    public void verificarEstado(Aluno aluno) {
        if (aluno.getNotaRecuperacao() >= 2.5) {
            aluno.setEstado(new Recuperacao());
        }
    }
}