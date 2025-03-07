package classes;

public class Ativo implements EstadoProfessor {
    @Override
    public void exibirEstadoProfessor() {
        System.out.println("Professor está Ativo.");
    }

    @Override
    public void verificarEstadoProfessor(Professor professor) {
        // Lógica para verificar se o estado deve mudar para inativo
        // Por exemplo, se o professor não estiver mais associado a nenhuma turma
        if (professor.getTurmas().isEmpty()) {
            professor.setverificarEstadoProfessor(new Inativo());
        }
    }
}

public class Inativo implements EstadoProfessor {
    @Override
    public void exibirEstado() {
        System.out.println("Professor está Inativo.");
    }

    @Override
    public void verificarEstado(Professor professor) {
        // Lógica para verificar se o estado deve mudar para ativo
        // Por exemplo, se o professor for associado a uma turma
        if (!professor.getTurmas().isEmpty()) {
            professor.setEstado(new Ativo());
        }
    }
}