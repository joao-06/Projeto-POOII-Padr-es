package classes;

public class Aluno extends Pessoa {

    private String matricula;
    private Double notaRecuperacao;
    private EstadoAluno estado;

    public Aluno() {
        super();
        this.matricula = "";
        this.notaRecuperacao = 0.0;
        this.estado = new Reprovado(); 
    }

    public Aluno(String nome, String cpf, String telefone, String endereco, String matricula, Double notaRecuperacao) {
        super(nome, cpf, telefone, endereco);
        this.matricula = matricula != null ? matricula : "";
        this.notaRecuperacao = notaRecuperacao != null ? notaRecuperacao : 0.0;
        this.estado = new Reprovado(); 
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula != null ? matricula : "";
    }

    public Double getNotaRecuperacao() {
        return notaRecuperacao;
    }

    public void setNotaRecuperacao(Double notaRecuperacao) {
        this.notaRecuperacao = notaRecuperacao != null ? notaRecuperacao : 0.0;
        estado.verificarEstado(this); // Verifica se o estado precisa mudar
    }

    public void setEstado(EstadoAluno estado) {
        this.estado = estado;
    }

    public void exibirSituacao() {
        estado.exibirSituacao();
    }

    @Override
    public void exibirDados() {
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Matrícula: " + matricula);
        System.out.println("Nota de Recuperação: " + notaRecuperacao);
        exibirSituacao(); // Exibe a situação atual do aluno
    }

    public void exibirHistorico() {
        System.out.println("Histórico do aluno " + (getNome() != null ? getNome() : "Desconhecido") + ":");
        System.out.println("Nota de Recuperação: " + notaRecuperacao);
        exibirSituacao(); // Exibe a situação atual do aluno
    }
}
