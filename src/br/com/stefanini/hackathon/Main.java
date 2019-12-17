package br.com.stefanini.hackathon;

import br.com.stefanini.hackathon.controller.CadastroCandidato;
import br.com.stefanini.hackathon.model.Candidato;
import br.com.stefanini.hackathon.util.Validacao;
import br.com.stefanini.hackathon.util.VetorUtil;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import static br.com.stefanini.hackathon.controller.CadastroCandidato.cadastrarCandidato;

public class Main {

    private static final int CADASTRAR_CANDIDATO = 1;
    private static final int CADASTRAR_VAGAS = 2;
    private static final int LISTAR_CANDIDATOS = 3;
    private static final int LISTAR_PERCENTUAL = 4;
    private static final int GERAR_ARQUIVOS = 5;
    private static final int SAIR = 0;

    private static int qtdVagas = 0;

    private static Scanner scanner = new Scanner(System.in);
    static VetorUtil vet = new VetorUtil();
    private static List<Candidato> listaCandidatos = vet.getLista();
//    private static List<Candidato> listaCandidatos = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int opcaoEscolhida = -1;

        while (opcaoEscolhida != SAIR) {
            imprimirMenu();
            opcaoEscolhida = scanner.nextInt();
            scanner.nextLine();
            switch (opcaoEscolhida) {
                case CADASTRAR_CANDIDATO:
                    Candidato novo = new Candidato();
                    do {
                        System.out.println("***AVISO*** - O nome do Candidato não pode estar em branco e nem conter digítos");
                        System.out.println("Digite o nome do candidato: ");
                        novo.setNome(scanner.nextLine());
                    } while (!Validacao.validaCampoString(novo.getNome()));
                    do {
                        System.out.println("***AVISO*** - O nome da Cidade não pode estar em branco e nem conter digítos");
                        System.out.println("Digite o cidade do candidato: ");
                        novo.setCidade(scanner.nextLine());
                    } while (!Validacao.validaCampoString(novo.getCidade()));
                    String nota;
                    do {
                        System.out.println("***AVISO*** - A nota deverá ser maior ou igual a 0 e menor que 100.");
                        System.out.println("Digite a nota do candidato: ");
                        nota = scanner.next();
                    } while (!Validacao.validaCampoNumerico(nota) || !(Integer.parseInt(nota) >= 0) && !(Integer.parseInt(nota) > 99));
                    novo.setNota(Integer.parseInt(nota));
                    if (novo.getNota() == 0) {
                        novo.setStatus(false);
                    }
                    cadastrarCandidato(novo, listaCandidatos);
                    break;
                case CADASTRAR_VAGAS:
                    String vagas;
                    do {
                        System.out.println("***AVISO*** - A quantidade de vagas deverá ser maior ou igual a 0.");
                        System.out.println("Digite a quantidadde de vagas: ");
                        vagas = scanner.next();
                    } while (!Validacao.validaCampoNumerico(vagas) || !(Integer.parseInt(vagas) >= 0));
                    qtdVagas = Integer.parseInt(vagas);
                    break;

                case LISTAR_CANDIDATOS:
                    CadastroCandidato.ranquearNotas(listaCandidatos);
                    CadastroCandidato.aprovar(qtdVagas, listaCandidatos);
                    CadastroCandidato.imprimeLista(qtdVagas, listaCandidatos);
                    break;

                case LISTAR_PERCENTUAL:
                    System.out.println(Validacao.retornaFrequencia(listaCandidatos));
                    break;
                case GERAR_ARQUIVOS:
                    Calendar data = Calendar.getInstance();
//                    Date data = new Date();
                    String arquivo = String.format("US03-%s.%s.%s-%s.%s.txt", data.get(Calendar.DAY_OF_MONTH), data.get(Calendar.MONTH), data.get(Calendar.YEAR), data.get(Calendar.HOUR_OF_DAY), data.get(Calendar.MINUTE));
                    CadastroCandidato.gerarArquivo(arquivo, listaCandidatos);
                    break;

            }
        }
    }


//    private static void imprimeLista2() {
//
//        if (listaCandidatos.size() - 1 <= qtdVagas) {
//            for (int i = 0; i < listaCandidatos.size() - 1; i++) {
//                if (listaCandidatos.get(i).getNota() != 0) {
//                    listaCandidatos.get(i).setStatus(true);
//                }
//            }
//        } else {
//            for (int i = 0; i < qtdVagas - 1; i++) {
//                if (listaCandidatos.get(i).getNota() != 0) {
//                    listaCandidatos.get(i).setStatus(true);
//                }
//            }
//
//        }
//        if (listaCandidatos != null) {
//            for (Candidato cand : listaCandidatos) {
//                System.out.println(cand);
//            }
//        } else {
//            System.out.println("Não existem candidatos cadastrados");
//        }
//
//    }

    private static void imprimirMenu() {
        System.out.println("************************************************************************");
        System.out.println("**** 0 - SAIR");
        System.out.println("**** 1 - CADASTRAR NOTA DO CANDIDATO");
        System.out.println("**** 2 - CADASTRAR NÚMERO DE VAGAS");
        System.out.println("**** 3 - LISTAR DE CANDIDATOS");
        System.out.println("**** 4 - EXIBIR PERCENTUAL DE APROVADOS POR CIDADE");
        System.out.println("**** 5 - GERAR ARQUIVOS");
        System.out.println("************************************************************************");
        System.out.print("ESCOLHA UMA OPÇÃO:");

    }

}
