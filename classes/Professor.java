package classes;

public class Professor extends Pessoa {

    private String siape;
    private boolean coordenador = false;
    private String senha;
    private EstadoProfessor estado;

    public Professor() {
        super();
        this.estado = new Inativo(); 
    }

    public Professor(String nome, String cpf, String telefone, String endereco, String siape, String senha) {
        super(nome, cpf, telefone, endereco);
        this.siape = siape;
        this.senha = senha;
        this.estado = new Inativo(); 
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isCoordenador() {
        return coordenador;
    }

    public void setCoordenador(boolean coordenador) {
        this.coordenador = coordenador;
    }

    public void setEstado(EstadoProfessor estado) {
        this.estado = estado;
    }

    public void exibirEstado() {
        estado.exibirEstado();
    }

    public void verificarEstado() {
        estado.verificarEstado(this);
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("SIAPE: " + siape);
        System.out.println("Coordenador: " + (coordenador ? "Sim" : "Não"));
        exibirEstado(); // Exibe o estado atual do professor
    }
}
