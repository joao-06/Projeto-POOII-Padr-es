package classes;

public class CursoAtivo implements EstadoCurso {
    @Override
    public void exibirEstado() {
        System.out.println("Curso está em andamento.");
    }

    @Override
    public void verificarEstado(Curso curso) {
        // Lógica para verificar se o curso deve mudar para finalizado
        // Por exemplo, se o semestre atual não estiver mais ativo
        if (curso.getSemestreAtual() != null && !curso.getSemestreAtual().isAtivo()) {
            curso.setEstado(new CursoFinalizado());
        }
    }


public class CursoFinalizado implements EstadoCurso {
    @Override
    public void exibirEstado() {
        System.out.println("Curso já finalizou.");
    }

    @Override
    public void verificarEstadoCurso(Curso curso) {
        // Lógica para verificar se o curso deve mudar para ativo
        // Por exemplo, se um novo semestre for iniciado
        if (curso.getSemestreAtual() != null && curso.getSemestreAtual().isAtivo()) {
            curso.setEstado(new CursoAtivo());
        }
    }
} 
}
    

