package classes;

public class Log {

    private Nota notaAnterior;
    private Nota notaAtual;
    private final Professor responsavel;

    public Log(Professor responsavel, Nota notaAnterior, Nota notaAtual) {
        this.responsavel = responsavel;
        this.notaAnterior = notaAnterior;
        this.notaAtual = notaAtual;
    }

    public Nota getNotaAtual() {
        return notaAtual;
    }

    public void setNotaAtual(Nota notaAtual) {
        this.notaAtual = notaAtual;
    }

    public Nota getNotaAnterior() {
        return notaAnterior;
    }

    public void setNotaAnterior(Nota notaAnterior) {
        this.notaAnterior = notaAnterior;
    }

    public void printLog() {
        String respNome = (responsavel != null && responsavel.getNome() != null) ? responsavel.getNome() : "Desconhecido";
        String anterior = (notaAnterior != null) ? notaAnterior.toString() : "Nenhuma";
        String atual = (notaAtual != null) ? notaAtual.toString() : "Nenhuma";
        System.out.println("Responsável: " + respNome + " - Alteração de Nota: " + anterior + " para " + atual);
    }
}
