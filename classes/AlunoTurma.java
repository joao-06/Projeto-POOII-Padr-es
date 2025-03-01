package classes;

public class AlunoTurma {

    private Aluno aluno;
    private Nota nota;

    public AlunoTurma() {
        this.nota = new Nota(); // Inicialização padrão
    }

    public AlunoTurma(Aluno aluno) {
        this.aluno = aluno;
        this.nota = new Nota();
    }

    public AlunoTurma(Aluno aluno, Nota nota) {
        this.aluno = aluno;
        this.nota = nota != null ? nota : new Nota();
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }
}
