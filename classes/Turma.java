package classes;

import java.util.ArrayList;
import java.util.List;

public class Turma {

    private String identificacao;
    private Curso curso;
    private Semestre semestre;
    private ArrayList<Professor> professores;
    private ArrayList<AlunoTurma> alunosTurma;
    private final List<Log> logs;

    public Turma() {
        this.professores = new ArrayList<>();
        this.alunosTurma = new ArrayList<>();
        this.logs = new ArrayList<>();
    }

    public Turma(String identificacao, Curso curso, Semestre semestre) {
        this.identificacao = identificacao != null ? identificacao : "";
        this.curso = curso;
        this.semestre = semestre;
        this.professores = new ArrayList<>();
        this.alunosTurma = new ArrayList<>();
        this.logs = new ArrayList<>();
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao != null ? identificacao : "";
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(ArrayList<Professor> professores) {
        this.professores = professores != null ? professores : new ArrayList<>();
    }

    public ArrayList<AlunoTurma> getAlunosTurma() {
        return alunosTurma;
    }

    public void setAlunosTurma(ArrayList<AlunoTurma> alunosTurma) {
        this.alunosTurma = alunosTurma != null ? alunosTurma : new ArrayList<>();
    }

    public void adicionarProfessor(Professor professor) {
        if (professor != null) {
            professores.add(professor);
        }
    }

    public void adicionarAluno(AlunoTurma aluno) {
        if (aluno != null) {
            alunosTurma.add(aluno);
        }
    }

    public void exibirEstatistica() {
        System.out.println("Estatísticas da Turma " + identificacao + ":");
        int aprovados = 0, reprovados = 0, recuperacao = 0;
        for (AlunoTurma at : alunosTurma) {
            if (at != null && at.getNota() != null) {
                double media = at.getNota().calcularMedia();
                System.out.printf("%s: %.2f\n", at.getAluno().getNome(), media);
                if (media < 2.5) {
                    reprovados++; 
                }else if (media < 7) {
                    recuperacao++; 
                }else {
                    aprovados++;
                }
            }
        }
        System.out.println("Aprovados: " + aprovados + ", Reprovados: " + reprovados + ", Recuperação: " + recuperacao);
    }

    public void alterarNotaEstudante(Professor coordenador, AlunoTurma alunoTurma, Nota novaNota) {
        if (coordenador != null && coordenador.isCoordenador() && alunoTurma != null && novaNota != null) {
            Nota antiga = alunoTurma.getNota();
            alunoTurma.setNota(novaNota);
            logs.add(new Log(coordenador, antiga, novaNota));
            System.out.println("Nota alterada com sucesso!");
        } else {
            System.out.println("Apenas coordenadores podem alterar notas ou parâmetros inválidos.");
        }
    }

    public void exibirDados() {
        System.out.println("Turma: " + identificacao);
        System.out.println("Curso: " + (curso != null ? curso.getNomeCurso() : "Nenhum"));
        System.out.println("Semestre: " + (semestre != null ? semestre.getNome() : "Nenhum"));
        System.out.println("Professores:");
        for (Professor p : professores) {
            if (p != null) {
                p.exibirDados();
            }
        }
        System.out.println("Alunos:");
        for (AlunoTurma at : alunosTurma) {
            if (at != null && at.getAluno() != null) {
                at.getAluno().exibirDados();
            }
        }
    }
}
