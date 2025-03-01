package classes;

public class Aluno extends Pessoa {

    private String matricula;
    private Double notaRecuperacao;

    public Aluno() {
        super();
        this.matricula = "";
        this.notaRecuperacao = 0.0;
    }

    public Aluno(String nome, String cpf, String telefone, String endereco, String matricula, Double notaRecuperacao) {
        super(nome, cpf, telefone, endereco);
        this.matricula = matricula != null ? matricula : "";
        this.notaRecuperacao = notaRecuperacao != null ? notaRecuperacao : 0.0;
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
    }

    @Override
    public void exibirDados() {
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Matrícula: " + matricula);
        System.out.println("Nota de Recuperação: " + notaRecuperacao);
    }

    public void exibirHistorico() {
        System.out.println("Histórico do aluno " + (getNome() != null ? getNome() : "Desconhecido") + ":");
        System.out.println("Nota de Recuperação: " + notaRecuperacao);
    }
}
