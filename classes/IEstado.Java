package classes;

public interface EstadoAluno {
    void exibirSituacao();
    void verificarEstado(Aluno aluno);
}

public interface EstadoProfessor {
    void exibirEstadoProfessor();
    void verificarEstadoProfessor(Professor professor);
}

public interface EstadoCurso{
    void exibirEstadoCurso();
    void verificarEstadoCurso(Curso curso);
}

public interface EstadoSemestre {
    void exibirEstadoSemestre();
    void verificarEstadoSemestre(Semestre semestre);
}

public interface EstadoTurma {
    void exibirEstadoTurma();
    void adicionarAlunoTurma(Turma turma, AlunoTurma aluno);
}
