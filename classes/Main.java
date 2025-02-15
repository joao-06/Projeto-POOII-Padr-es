package classes;

import java.net.ProtocolFamily;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  
  
  //APLIQUE SINGLETON, REMOVA ESSA DECLARACAO E USO GetInstance nos métodos que chamam db
  static int opcao;
  static Scanner entrada;
  //static Nota nota;


  public static void main(String[] args) {
    //REMOVA 
    
    DataBase.getInstace();
    entrada = new Scanner(System.in);
    
    //FACA UM MENU PARA SELECIONAR A OPCAO (1 - Prof/ 2- Coord) USANDO A SENHA EM PROFESSOR
    //MENU

    public static void menu(){
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

    switch (opcao) {
      
      case 1:
        menuCoordenador();
        break;
      case 2:
        menuProfessor();
        break;
      case 0:
          System.out.println("Saindo...");
          break;
        default:
          System.out.println("Opção inválida!");
      }
    } while (opcao != 0);

}

    
    menuCoordenador();
    menuProfessor();
   
    entrada.close();
  }
  

public static void menuCoordenador(){
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
    System.out.println("║  8 - Atribuir notas aos estudantes      ║");
    System.out.println("║     9 - Mostrar a estatística           ║");
    System.out.println("║      10 - Lista de recuperação          ║");
    System.out.println("║          11 - Lista geral               ║");
    System.out.println("║           12 - Histórico                ║");
    System.out.println("║             0 - Sair                    ║");
    System.out.println("╚═════════════════════════════════════════╝");
    System.out.print("Opção: ");
    opcao = entrada.nextInt(); 

    switch (opcao) {
      case 1:
        cadastrarProfessor();
        break;
      case 2:
        vincularProfessorTurma();
        break;
      case 3:
        cadastrarAluno();
        break;
      case 4:
        vincularEstudanteTurma();
        break;
      case 5:
        cadastrarCurso();
        break;
      case 6:
        cadastrarTurma();
        break;
      case 7:
        cadastarCoordenador();
        break;
      case 8:
        cadastrarNotas();
        break;
      case 9:
        mostrarEstatistica();
        break;
      case 10:
        exibirListaRecuperacao();
        break;
      case 11:
        exibirListaGeral();
        break;
      case 12:
        exibirHistorico();
        break;
      case 0:
          System.out.println("Saindo...");
          break;
        default:
          System.out.println("Opção inválida!");
      }
    } while (opcao != 0);

}


public static void menuProfessor(){
  do { 
    System.out.println("╔═════════════════════════════════════════╗");
    System.out.println("║                MENU                     ║");
    System.out.println("╠═════════════════════════════════════════╣");
    System.out.println("║  1 - Atribuir notas aos estudantes      ║");
    System.out.println("║     2 - Mostrar a estatística           ║");
    System.out.println("║      3 - Lista de recuperação           ║");
    System.out.println("║           4 - Histórico                 ║");
    System.out.println("║             0 - Sair                    ║");
    System.out.println("╚═════════════════════════════════════════╝");
    System.out.print("Opção: ");
    opcao = entrada.nextInt(); 

    switch (opcao) {
      
      case 1:
        cadastrarNotas();
        break;
      case 2:
        mostrarEstatistica();
        break;
      case 3:
        exibirListaRecuperacao();
        break;
      case 4:
        exibirHistorico();
        break;
      case 0:
          System.out.println("Saindo...");
          break;
        default:
          System.out.println("Opção inválida!");
      }
    } while (opcao != 0);

}


public static void cadastarCoordenador(){
  DataBase db = DataBase.getInstance();
  System.out.println("Lista de professores:");
    for (int i = 0; i < db.getProfessores().size(); i++) {
        System.out.printf("%d - %s\n", i + 1, db.getProfessores().get(i).getNome());
    }

    System.out.print("Escolha o professor coordenador: ");
    int escolhaProfessor = entrada.nextInt();

    if (escolhaProfessor < 0 || escolhaProfessor > db.getProfessores().size()-1) {
        System.out.println("Escolha inválida.");
        return;
    }

    System.out.print("Escolha o curso para vinculá-lo como coordenador: ");
    for (int i = 0; i < db.getCursos().size(); i++) {
      System.out.printf("%d - %s\n", i + 1, db.getCursos().get(i).getNomeCurso());
    }
    int escolhaCurso = entrada.nextInt();

    if (escolhaCurso < 0 || escolhaCurso > db.getCursos().size()-1) {
        System.out.println("Escolha inválida.");
        return;
    }

    db.getCursos().get(escolhaCurso).vincularCoordenador( db.getProfessores().get(escolhaProfessor));
    System.out.println(db.getProfessores().get(escolhaProfessor).getNome() + " agora é o coordenador.");
}


public static void cadastrarNotas(){

   DataBase db = DataBase.getInstance();
   System.out.println(" ---- Cadastrar Notas ----");
   
   System.out.println("Selecione a turma");
    
    for (int i = 0, totalTurmas = db.getTurmas().size(); i < totalTurmas; i++) {
      System.out.println(i + " - " +db.getTurmas().get(i).getIdentificacao() + " Curso "+ db.getTurmas().get(i).getCurso().getNomeCurso());
    } 
   
    int escolhaTurma = entrada.nextInt();

    if (escolhaTurma < 0 || escolhaTurma > db.getTurmas().size()-1) {
        System.out.println("Escolha inválida.");
        return;
    }


    System.out.println("Turma "+db.getTurmas().get(escolhaTurma).getIdentificacao()+" selecionada, selecione o estudante");

    for (int i = 0, totalAlunos = db.getTurmas().get(escolhaTurma).getAlunosTurma().size(); i < totalAlunos; i++) {
      System.out.println(i + " - " +db.getTurmas().get(escolhaTurma).getAlunosTurma().get(i).getAluno().getNome());
    } 
    
    int escolhaEstudante = entrada.nextInt();

    if (escolhaEstudante < 0 || escolhaEstudante > db.getTurmas().get(escolhaTurma).getAlunosTurma().size()-1) {
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

    System.out.printf("Média: %.2f\n", nota.calcularMedia());
    System.out.print("Situação: ");
    db.getTurmas().get(escolhaTurma).getAlunosTurma().get(escolhaEstudante).setNota(nota);
    nota.verificarSituacao();

}


public static void mostrarEstatistica(){
    System.out.println("Estatisticas");
    for( int i = 0; i < db.getTurmas().size(); i++){
      System.out.println("Dados da turma " + db.getTurmas().get(i).getIdentificacao());
      db.getTurmas().get(i).setEstatica();
      System.out.println();
    }
}


public static void exibirListaRecuperacao(){
  System.out.println("Lista de recuperação");
          System.out.println("Escolha a turma para listar alunos em recuperação:");
          for (int i = 0; i < db.getTurmas().size(); i++) {
              System.out.println(i + " - Turma: " + db.getTurmas().get(i).getIdentificacao());
          }
          int turmaEscolhida = entrada.nextInt();
          if (turmaEscolhida < 0 || turmaEscolhida > db.getTurmas().size()-1) {
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
                  System.out.println("Nota de recuperação registrada.");
                  qtdAluno++;
                }
          }

          if(qtdAluno == 0){
            System.out.println("Nenhum aluno atende ao critério de recuperação.");
          }
}


public static void exibirListaGeral(){
  db.getTurmas().get(0).exibirDados();
  System.out.println();

  System.out.println("Cursos:");
  for (Curso curso : db.getCursos()) {
    System.out.println("Nome do curso: " + curso.getNomeCurso() + ", Semestres: " + curso.getQtdSemestre());
  }

  db.getTurmas().get(1).exibirDados();
  System.out.println("Cursos:");
  for (Curso curso : db.getCursos()) {
    System.out.println("Nome do curso: " + curso.getNomeCurso() + ", Semestres: " + curso.getQtdSemestre());
  }
}

public static void exibirHistorico(){

    System.out.println("Histórico de alterações dos alunos:");
    for (Aluno aluno : db.getAlunos()) {
        aluno.exibirHistorico();
        System.out.println();
    }
}


public static void cadastrarProfessor(){
  //ADICIONE EM TODOS OS MÉTODOS QUE USAM db
  DataBase db = DataBase.getInstace();

  System.out.println(" ---- Cadastrar Professor ----");
  Professor professor = new Professor();
  entrada.nextLine();
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

  db.getProfessores().add(professor);
  System.out.println("Professor cadastrado com sucesso!");

}

public static void vincularProfessorTurma(){

  System.out.println(" ---- Vincular Professor a Turma ----");
  System.out.println("Escolha o professor para vincular:");
  for (int i = 0; i < db.getProfessores().size(); i++) {
      System.out.println(i + " - Prof.: " + db.getProfessores().get(i).getNome() + "(SIAPE: "+ db.getProfessores().get(i).getSiape()+")" );
  }
  int profEscolhido = entrada.nextInt();
  if (profEscolhido < 0 || profEscolhido > db.getProfessores().size()-1) {
      System.out.println("Professor inválida!");
      return;
  }

  System.out.println("Escolha a truma para vincular o professor");
  for (int i = 0; i < db.getTurmas().size(); i++) {
      System.out.println(i + " - Turma: " + db.getTurmas().get(i).getIdentificacao());
  }
  int turmaEscolhida = entrada.nextInt();
  if (turmaEscolhida < 0 || turmaEscolhida > db.getTurmas().size()-1) {
      System.out.println("Turma inválida!");
      return;
  }

  System.out.println("Vincular Professor "+ db.getProfessores().get(profEscolhido).getNome()+ " a Turma " + db.getTurmas().get(turmaEscolhida).getIdentificacao() );
  System.out.println("1 - Sim \n2 - Não");
  int opcEscolhida = entrada.nextInt();
  if(opcEscolhida == 1){
    System.out.println("Professor Vinculado com Sucesso");
    db.getTurmas().get(turmaEscolhida).adicionarProfessor( db.getProfessores().get(profEscolhido));
  }else if(opcEscolhida == 2){
    System.out.println("Operação Cancelada");
  }else{
    System.out.println("Opção Inválida - Operação Cancelada");
  }

}


public static void cadastrarCurso() {

   DataBase db = DataBase.getInstance();
  System.out.println(" ---- Cadastrar Curso ----");
  Curso curso = new Curso();

  System.out.print("Informe o nome do curso: ");
  curso.setNomeCurso(entrada.nextLine());

  System.out.print("Informe a quantidade de semestres: ");
  curso.setQtdSemestre(entrada.nextLine());

  System.out.println("Curso cadastrado com sucesso!");
}

public static void cadastrarAluno() {

   DataBase db = DataBase.getInstance();
  System.out.println(" ---- Cadastrar Aluno ----");
  Aluno aluno = new Aluno();
  entrada.nextLine();
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

public static void vincularEstudanteTurma(){

  System.out.println(" ---- Vincular Estudante a Turma ----");
  System.out.println("Escolha o estudante para vincular:");
  for (int i = 0; i < db.getAlunos().size(); i++) {
      System.out.println(i + " - Prof.: " + db.getAlunos().get(i).getNome() );
  }
  int alunoEscolhido = entrada.nextInt();
  if (alunoEscolhido < 0 || alunoEscolhido > db.getAlunos().size()-1) {
      System.out.println("Professor inválida!");
      return;
  }

  System.out.println("Escolha a truma para vincular o professor");
  for (int i = 0; i < db.getTurmas().size(); i++) {
      System.out.println(i + " - Turma: " + db.getTurmas().get(i).getIdentificacao());
  }
  int turmaEscolhida = entrada.nextInt();
  if (turmaEscolhida < 0 || turmaEscolhida > db.getTurmas().size()-1) {
      System.out.println("Turma inválida!");
      return;
  }

  System.out.println("Vincular Estudante "+ db.getAlunos().get(alunoEscolhido).getNome()+ " a Turma " + db.getTurmas().get(turmaEscolhida).getIdentificacao() +"?" );
  System.out.println("1 - Sim \n2 - Não");
  int opcEscolhida = entrada.nextInt();
  if(opcEscolhida == 1){
    System.out.println("Professor Vinculado com Sucesso");
    db.getTurmas().get(turmaEscolhida).adicionarAluno( new AlunoTurma( db.getAlunos().get(alunoEscolhido)));
  }else if(opcEscolhida == 2){
    System.out.println("Operação Cancelada");
  }else{
    System.out.println("Opção Inválida - Operação Cancelada");
  }
}

public static void cadastrarTurma(){ 
   DataBase db = DataBase.getInstance();
  System.out.println(" ---- Cadastrar Turma ----");
  Turma turma = new Turma();

  System.out.print("Informe identificação: ");
  turma.setIdentificacao(entrada.nextLine());

  System.out.print("Informe o semestre: ");
  turma.setSemestre(entrada.nextLine());

  System.out.print("Escolha o curso para vinculá-lo como coordenador: ");
  for (int i = 0; i < db.getCursos().size(); i++) {
    System.out.printf("%d - %s\n", i + 1, db.getCursos().get(i).getNomeCurso());
  }
  int escolhaCurso = entrada.nextInt();

  if (escolhaCurso < 0 || escolhaCurso > db.getCursos().size()-1) {
      System.out.println("Escolha inválida.");
      return;
  }

  turma.setCurso( db.getCursos().get(escolhaCurso));

  System.out.println("Turma cadastrada com sucesso!");
}

}
