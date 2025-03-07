package classes;

public class TurmaAberta implements EstadoTurma {
    @Override
    public void exibirEstadoTurma() {
        System.out.println("Turma está aberta e aceitando alunos.");
    }

    @Override
    public void adicionarAluno(Turma turma, AlunoTurma aluno) {
        if (turma.getAlunosTurma().size() < turma.getLimiteMaximo()) {
            turma.getAlunosTurma().add(aluno);
            System.out.println("Aluno adicionado com sucesso.");
            if (turma.getAlunosTurma().size() >= turma.getLimiteMaximo()) {
                turma.setEstado(new TurmaFechada()); // Muda para o estado "Fechada" se o limite for atingido
            }
        } else {
            System.out.println("Não é possível adicionar mais alunos. Turma está cheia.");
        }
    }
}

public class TurmaFechada implements EstadoTurma {
    @Override
    public void exibirEstadoTurma() {
        System.out.println("Turma está fechada. Limite máximo de alunos atingido.");
    }

    @Override
    public void adicionarAluno(Turma turma, AlunoTurma aluno) {
        System.out.println("Não é possível adicionar mais alunos. Turma está fechada.");
    }
}
