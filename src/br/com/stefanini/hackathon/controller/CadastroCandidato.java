package br.com.stefanini.hackathon.controller;

import br.com.stefanini.hackathon.interfaces.Crud;
import br.com.stefanini.hackathon.model.Candidato;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class CadastroCandidato implements Crud {
    public static void cadastrarCandidato(Candidato candidato, @NotNull List<Candidato> listaCandidatos) {
        listaCandidatos.add(candidato);
    }

    private static void reprovar(int qtdVagas, @NotNull List<Candidato> listaCandidatos) {
        for (int i = qtdVagas; i < listaCandidatos.size() - 1; i++) {
            listaCandidatos.get(i).setStatus(false);
        }
    }

    public static void aprovar(int qtdVagas, @NotNull List<Candidato> listaCandidatos) {
        if (listaCandidatos.size() > qtdVagas) {
            for (int i = 0; i < qtdVagas; i++) {
                if (listaCandidatos.get(i).getNota() != 0) {
                    listaCandidatos.get(i).setStatus(true);
                }
            }
            reprovar(qtdVagas, listaCandidatos);
        } else {
            for (int i = 0; i < listaCandidatos.size() - 1; i++) {
                if (listaCandidatos.get(i).getNota() != 0) {
                    listaCandidatos.get(i).setStatus(true);
                }
            }
        }
    }

    public static void imprimeLista(List<Candidato> listaCandidatos) {
        if (listaCandidatos != null) {
            for (Candidato candidato : listaCandidatos) {
                System.out.println(candidato);
            }
        } else {
            System.out.println("Não existem candidatos cadastrados");
        }
    }

    public static void ranquearNotas(List<Candidato> listaCandidatos) {
        listaCandidatos.sort(Comparator.comparingDouble(Candidato::getNota).reversed());
    }
}
