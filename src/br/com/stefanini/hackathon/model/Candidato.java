package br.com.stefanini.hackathon.model;

import java.util.Objects;

public class Candidato {

    private String nome;
    private String cidade;
    private double nota;
    private boolean status;

    public Candidato() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidato)) return false;
        Candidato candidato = (Candidato) o;
        return isStatus() == candidato.isStatus() &&
                getCidade().equals(candidato.getCidade());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCidade(), isStatus());
    }

    public Candidato(String nome, String cidade, double nota) {
        super();
        this.nome = nome;
        this.cidade = cidade;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {

        String s = "Candidato [nome=" + nome + ", cidade=" + cidade + ", nota=" + nota + ", status=";

        if (status) {
            s += "APROVADO";
        } else {
            s += "REPROVADO]";
        }

        return s;
    }

}
