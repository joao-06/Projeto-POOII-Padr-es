package classes;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    static int opcao;
    static Scanner entrada;

    public static void main(String[] args) {
        entrada = new Scanner(System.in);
        menu();
        entrada.close();
    }

    public static void menu() {
        do {
            System.out.println("╔═════════════════════════════════════════╗");
            System.out.println("║               O que você é?             ║");
            System.out.println("╠═════════════════════════════════════════╣");
            System.out.println("║     1 - Coordenador                     ║");
            System.out.println("║     2 - Professor                       ║");
            System.out.println("║     0 - Sair                            ║");
            System.out.println("╚═════════════════════════════════════════╝");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();
            entrada.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1 -> menuCoordenador();
                case 2 -> menuProfessor();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static void menuCoordenador() {
        do {
            System.out.println("╔═════════════════════════════════════════╗");
            System.out.println("║                MENU                     ║");
            System.out.println("╠═════════════════════════════════════════╣");
            System.out.println("║     1 - Cadastrar um professor          ║");
            System.out.println("║     2 - Vincular um prof. a turma       ║");
            System.out.println("║     3 - Cadastrar um estudante          ║");
            System.out.println("║     4 - Vincular estud. a turma         ║");
            System.out.println("║     5 - Cadastrar um curso              ║");
            System.out.println("║     6 - Cadastrar uma turma             ║");
            System.out.println("║     7 - Cadastrar um coordenador        ║");
            System.out.println("║     8 - Atribuir notas aos estudantes   ║");
            System.out.println("║     9 - Mostrar a estatística           ║");
            System.out.println("║    10 - Lista de recuperação            ║");
            System.out.println("║    11 - Lista geral                     ║");
            System.out.println("║    12 - Histórico                       ║");
            System.out.println("║     0 - Sair                            ║");
            System.out.println("╚═════════════════════════════════════════╝");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();
            entrada.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1 -> cadastrarProfessor();
                case 2 -> vincularProfessorTurma();
                case 3 -> cadastrarAluno();
                case 4 -> vincularEstudanteTurma();
                case 5 -> cadastrarCurso();
                case 6 -> cadastrarTurma();
                case 7 -> cadastrarCoordenador();
                case 8 -> cadastrarNotas();
                case 9 -> mostrarEstatistica();
                case 10 -> exibirListaRecuperacao();
                case 11 -> exibirListaGeral();
                case 12 -> exibirHistorico();
                case 13 -> importDadosEstudanteMEC();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static void menuProfessor() {
        do {
            System.out.println("╔═════════════════════════════════════════╗");
            System.out.println("║                MENU                     ║");
            System.out.println("╠═════════════════════════════════════════╣");
            System.out.println("║  1 - Atribuir notas aos estudantes      ║");
            System.out.println("║     2 - Mostrar a estatística           ║");
            System.out.println("║      3 - Lista de recuperação           ║");
            System.out.println("║           4 - Histórico                 ║");
            System.out.println("║    5 - Exportar dados dos alunos        ║");
            System.out.println("║             0 - Sair                    ║");
            System.out.println("╚═════════════════════════════════════════╝");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();
            entrada.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1 -> cadastrarNotas();
                case 2 -> mostrarEstatistica();
                case 3 -> exibirListaRecuperacao();
                case 4 -> exibirHistorico();
                case 5 -> importDadosEstudanteMEC();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static void cadastrarProfessor() {
        DataBase db = DataBase.getInstance();
        System.out.println(" ---- Cadastrar Professor ----");
        Professor professor = new Professor();
        System.out.print("Informe o nome: ");
        professor.setNome(entrada.nextLine());
        System.out.print("Informe o CPF: ");
        professor.setCpf(entrada.nextLine());
        System.out.print("Informe o telefone: ");
        professor.setTelefone(entrada.nextLine());
        System.out.print("Informe o endereço: ");
        professor.setEndereco(entrada.nextLine());
        System.out.print("Informe o SIAPE: ");
        professor.setSiape(entrada.nextLine());
        System.out.print("Informe a senha: ");
        professor.setSenha(entrada.nextLine());
        db.getProfessores().add(professor);
        System.out.println("Professor cadastrado com sucesso!");
    }

    public static void vincularProfessorTurma() {
        DataBase db = DataBase.getInstance();
        System.out.println(" ---- Vincular Professor a Turma ----");
        System.out.println("Escolha o professor para vincular:");
        for (int i = 0; i < db.getProfessores().size(); i++) {
            System.out.println(i + " - Prof.: " + db.getProfessores().get(i).getNome() + " (SIAPE: " + db.getProfessores().get(i).getSiape() + ")");
        }
        int profEscolhido = entrada.nextInt();
        entrada.nextLine();
        if (profEscolhido < 0 || profEscolhido >= db.getProfessores().size()) {
            System.out.println("Professor inválido!");
            return;
        }

        System.out.println("Escolha a turma para vincular o professor:");
        for (int i = 0; i < db.getTurmas().size(); i++) {
            System.out.println(i + " - Turma: " + db.getTurmas().get(i).getIdentificacao());
        }
        int turmaEscolhida = entrada.nextInt();
        entrada.nextLine();
        if (turmaEscolhida < 0 || turmaEscolhida >= db.getTurmas().size()) {
            System.out.println("Turma inválida!");
            return;
        }

        db.getTurmas().get(turmaEscolhida).adicionarProfessor(db.getProfessores().get(profEscolhido));
        System.out.println("Professor vinculado com sucesso!");
    }

    public static void cadastrarAluno() {
        DataBase db = DataBase.getInstance();
        System.out.println(" ---- Cadastrar Aluno ----");
        Aluno aluno = new Aluno();
        System.out.print("Informe o nome: ");
        aluno.setNome(entrada.nextLine());
        System.out.print("Informe o CPF: ");
        aluno.setCpf(entrada.nextLine());
        System.out.print("Informe o telefone: ");
        aluno.setTelefone(entrada.nextLine());
        System.out.print("Informe o endereço: ");
        aluno.setEndereco(entrada.nextLine());
        System.out.print("Informe a matrícula: ");
        aluno.setMatricula(entrada.nextLine());
        db.getAlunos().add(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public static void vincularEstudanteTurma() {
        DataBase db = DataBase.getInstance();
        System.out.println(" ---- Vincular Estudante a Turma ----");
        System.out.println("Escolha o estudante para vincular:");
        for (int i = 0; i < db.getAlunos().size(); i++) {
            System.out.println(i + " - " + db.getAlunos().get(i).getNome());
        }
        int alunoEscolhido = entrada.nextInt();
        entrada.nextLine();
        if (alunoEscolhido < 0 || alunoEscolhido >= db.getAlunos().size()) {
            System.out.println("Aluno inválido!");
            return;
        }

        System.out.println("Escolha a turma para vincular o aluno:");
        for (int i = 0; i < db.getTurmas().size(); i++) {
            System.out.println(i + " - Turma: " + db.getTurmas().get(i).getIdentificacao());
        }
        int turmaEscolhida = entrada.nextInt();
        entrada.nextLine();
        if (turmaEscolhida < 0 || turmaEscolhida >= db.getTurmas().size()) {
            System.out.println("Turma inválida!");
            return;
        }

        db.getTurmas().get(turmaEscolhida).adicionarAluno(new AlunoTurma(db.getAlunos().get(alunoEscolhido)));
        System.out.println("Aluno vinculado com sucesso!");
    }

    public static void cadastrarCurso() {
        DataBase db = DataBase.getInstance();
        System.out.println(" ---- Cadastrar Curso ----");
        Curso curso = new Curso();
        System.out.print("Informe o nome do curso: ");
        curso.setNomeCurso(entrada.nextLine());
        System.out.print("Informe a quantidade de semestres: ");
        curso.setQtdSemestre(entrada.nextLine());
        db.getCursos().add(curso);
        System.out.println("Curso cadastrado com sucesso!");
    }

    public static void cadastrarTurma() {
        DataBase db = DataBase.getInstance();
        System.out.println(" ---- Cadastrar Turma ----");
        System.out.print("Informe a identificação: ");
        String identificacao = entrada.nextLine();
        System.out.println("Escolha o curso:");
        for (int i = 0; i < db.getCursos().size(); i++) {
            System.out.println(i + " - " + db.getCursos().get(i).getNomeCurso());
        }
        int cursoEscolhido = entrada.nextInt();
        entrada.nextLine();
        if (cursoEscolhido < 0 || cursoEscolhido >= db.getCursos().size()) {
            System.out.println("Curso inválido!");
            return;
        }
        System.out.print("Informe o semestre (ex: 2024/1): ");
        String semestreNome = entrada.nextLine();
        System.out.print("Semestre ativo? (1 - Sim, 0 - Não): ");
        boolean ativo = entrada.nextInt() == 1;
        entrada.nextLine();
        Turma turma = new Turma(identificacao, db.getCursos().get(cursoEscolhido), new Semestre(semestreNome, ativo));
        db.getTurmas().add(turma);
        System.out.println("Turma cadastrada com sucesso!");
    }

    public static void cadastrarCoordenador() {
        DataBase db = DataBase.getInstance();
        System.out.println("Lista de professores:");
        for (int i = 0; i < db.getProfessores().size(); i++) {
            System.out.printf("%d - %s\n", i, db.getProfessores().get(i).getNome());
        }
        System.out.print("Escolha o professor coordenador: ");
        int escolhaProfessor = entrada.nextInt();
        entrada.nextLine();
        if (escolhaProfessor < 0 || escolhaProfessor >= db.getProfessores().size()) {
            System.out.println("Escolha inválida.");
            return;
        }

        System.out.print("Escolha o curso para vinculá-lo como coordenador: ");
        for (int i = 0; i < db.getCursos().size(); i++) {
            System.out.printf("%d - %s\n", i, db.getCursos().get(i).getNomeCurso());
        }
        int escolhaCurso = entrada.nextInt();
        entrada.nextLine();
        if (escolhaCurso < 0 || escolhaCurso >= db.getCursos().size()) {
            System.out.println("Escolha inválida.");
            return;
        }

        db.getCursos().get(escolhaCurso).vincularCoordenador(db.getProfessores().get(escolhaProfessor));
        db.getProfessores().get(escolhaProfessor).setCoordenador(true);
    }

    public static void cadastrarNotas() {
        DataBase db = DataBase.getInstance();
        System.out.println(" ---- Cadastrar Notas ----");
        System.out.println("Selecione a turma:");
        for (int i = 0; i < db.getTurmas().size(); i++) {
            System.out.println(i + " - " + db.getTurmas().get(i).getIdentificacao() + " Curso " + db.getTurmas().get(i).getCurso().getNomeCurso());
        }
        int escolhaTurma = entrada.nextInt();
        entrada.nextLine();
        if (escolhaTurma < 0 || escolhaTurma >= db.getTurmas().size()) {
            System.out.println("Escolha inválida.");
            return;
        }

        System.out.println("Turma " + db.getTurmas().get(escolhaTurma).getIdentificacao() + " selecionada, selecione o estudante:");
        for (int i = 0; i < db.getTurmas().get(escolhaTurma).getAlunosTurma().size(); i++) {
            System.out.println(i + " - " + db.getTurmas().get(escolhaTurma).getAlunosTurma().get(i).getAluno().getNome());
        }
        int escolhaEstudante = entrada.nextInt();
        entrada.nextLine();
        if (escolhaEstudante < 0 || escolhaEstudante >= db.getTurmas().get(escolhaTurma).getAlunosTurma().size()) {
            System.out.println("Escolha inválida.");
            return;
        }

        Aluno aluno = db.getTurmas().get(escolhaTurma).getAlunosTurma().get(escolhaEstudante).getAluno();
        Nota nota = db.getTurmas().get(escolhaTurma).getAlunosTurma().get(escolhaEstudante).getNota();
        System.out.printf("Notas do aluno(a): %s\n", aluno.getNome());
        System.out.print("Informe a nota 1: ");
        nota.setNota1(entrada.nextDouble());
        System.out.print("Informe a nota 2: ");
        nota.setNota2(entrada.nextDouble());
        System.out.print("Informe a nota 3: ");
        nota.setNota3(entrada.nextDouble());
        entrada.nextLine();
        System.out.printf("Média: %.2f\n", nota.calcularMedia());
        System.out.println("Situação: " + nota.verificarSituacao());
    }

    public static void mostrarEstatistica() {
        DataBase db = DataBase.getInstance();
        System.out.println("Estatísticas");
        for (int i = 0; i < db.getTurmas().size(); i++) {
            System.out.println("Dados da turma " + db.getTurmas().get(i).getIdentificacao());
            db.getTurmas().get(i).exibirEstatistica();
            System.out.println();
        }
    }

    public static void exibirListaRecuperacao() {
        DataBase db = DataBase.getInstance();
        System.out.println("Lista de recuperação");
        System.out.println("Escolha a turma para listar alunos em recuperação:");
        for (int i = 0; i < db.getTurmas().size(); i++) {
            System.out.println(i + " - Turma: " + db.getTurmas().get(i).getIdentificacao());
        }
        int turmaEscolhida = entrada.nextInt();
        entrada.nextLine();
        if (turmaEscolhida < 0 || turmaEscolhida >= db.getTurmas().size()) {
            System.out.println("Turma inválida!");
            return;
        }
        Turma turma = db.getTurmas().get(turmaEscolhida);
        int qtdAluno = 0;
        for (AlunoTurma aluno : turma.getAlunosTurma()) {
            if (aluno.getNota().calcularMedia() >= 2.5 && aluno.getNota().calcularMedia() < 7) {
                System.out.print("Insira uma nota de recuperação para " + aluno.getAluno().getNome() + ": ");
                double novaNota = entrada.nextDouble();
                aluno.getNota().setNotaRecuperacao(novaNota);
                aluno.getAluno().setNotaRecuperacao(novaNota); // Atualiza no aluno também
                System.out.println("Nota de recuperação registrada.");
                qtdAluno++;
            }
        }
        if (qtdAluno == 0) {
            System.out.println("Nenhum aluno atende ao critério de recuperação.");
        }
    }

    public static void exibirListaGeral() {
        DataBase db = DataBase.getInstance();
        for (Turma turma : db.getTurmas()) {
            turma.exibirDados();
            System.out.println();
        }
        System.out.println("Cursos:");
        for (Curso curso : db.getCursos()) {
            System.out.println("Nome do curso: " + curso.getNomeCurso() + ", Semestres: " + curso.getQtdSemestre());
        }
    }

    public static void exibirHistorico() {
        DataBase db = DataBase.getInstance();
        System.out.println("Histórico de alterações dos alunos:");
        for (Aluno aluno : db.getAlunos()) {
            aluno.exibirHistorico();
            System.out.println();
        }
    }

    public static String exportarDadosEstudante() {
        DataBase db = DataBase.getInstance();
        ArrayList<String[]> data = new ArrayList<>();
        ArrayList<Aluno> alunos = db.getAlunos();
        for (int i = 0; i < alunos.size(); i++) {
            data.add(new String[]{"matricula", alunos.get(i).getMatricula()});
            data.add(new String[]{"nome", alunos.get(i).getNome()});
            data.add(new String[]{"cpf", alunos.get(i).getCpf()});
            data.add(new String[]{"telefone", alunos.get(i).getTelefone()});
            data.add(new String[]{"endereco", alunos.get(i).getEndereco()});
        }
        ExportData exp = new ExportData();
        XMLToJSONAdapter adapter = new XMLToJSONAdapter(exp);
        return adapter.convertXMLToJSON(data, 5, "student");
    }

    public static void importDadosEstudanteMEC() {
        String data = exportarDadosEstudante();
        ImportDataMEC imec = new ImportDataMEC();
        imec.importData(data);
        System.out.println("Dados exportados para o MEC com sucesso!");
    }
}
