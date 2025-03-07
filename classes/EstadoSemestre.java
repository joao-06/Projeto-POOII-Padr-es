package classes;

public class SemestreAtivo implements EstadoSemestre {
    @Override
    public void exibirEstadoSemestre() {
        System.out.println("Semestre está em andamento.");
    }

    @Override
    public void verificarEstado(Semestre semestre) {
        // Lógica para verificar se o semestre deve mudar para finalizado
        // Por exemplo, se a data atual for posterior à data de término do semestre
        if (semestre.getDataTermino() != null && semestre.getDataTermino().isBefore(java.time.LocalDate.now())) {
            semestre.setEstado(new SemestreFinalizado());
        }
    }
}

public class SemestreFinalizado implements EstadoSemestre {
    @Override
    public void exibirEstadoSemestre() {
        System.out.println("Semestre já finalizou.");
    }

    @Override
    public void verificarEstadoSemestre(Semestre semestre) {
        // Lógica para verificar se o semestre deve mudar para ativo
        // Por exemplo, se a data atual for anterior à data de término do semestre
        if (semestre.getDataTermino() != null && semestre.getDataTermino().isAfter(java.time.LocalDate.now())) {
            semestre.setEstado(new SemestreAtivo());
        }
    }
}