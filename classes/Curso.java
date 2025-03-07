package classes;

public class Curso {

    private String nomeCurso;
    private String qtdSemestre;
    private Professor coordenador;
    private Semestre semestreAtual;
    private EstadoCurso estado;

    public Curso() {
        this.estado = new CursoFinalizado(); // Estado inicial
    }

    public Curso(String nomeCurso, String qtdSemestre) {
        this.nomeCurso = nomeCurso;
        this.qtdSemestre = qtdSemestre;
        this.estado = new CursoFinalizado(); // Estado inicial
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getQtdSemestre() {
        return qtdSemestre;
    }

    public void setQtdSemestre(String qtdSemestre) {
        this.qtdSemestre = qtdSemestre;
    }

    public void vincularCoordenador(Professor professor) {
        this.coordenador = professor;
        System.out.println("Coordenador vinculado com sucesso: " + professor.getNome());
    }

    public Professor getCoordenador() {
        return coordenador;
    }

    public Semestre getSemestreAtual() {
        return semestreAtual;
    }

    public void setSemestreAtual(Semestre semestreAtual) {
        this.semestreAtual = semestreAtual;
        estado.verificarEstado(this); // Verifica se o estado precisa mudar
    }

    public void setEstado(EstadoCurso estado) {
        this.estado = estado;
    }

    public void exibirEstado() {
        estado.exibirEstado();
    }

    public void verificarEstado() {
        estado.verificarEstado(this);
    }
}
