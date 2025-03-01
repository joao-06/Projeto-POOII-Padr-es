package classes;

public class Professor extends Pessoa {

    private String siape;
    private boolean coordenador = false;
    private String senha;

    public Professor() {
        super();
    }

    public Professor(String nome, String cpf, String telefone, String endereco, String siape, String senha) {
        super(nome, cpf, telefone, endereco);
        this.siape = siape;
        this.senha = senha;
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

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("SIAPE: " + siape);
        System.out.println("Coordenador: " + (coordenador ? "Sim" : "Não"));
    }
}
