package br.com.stefanini.hackathon.util;

public class Validacao {
    public static boolean validaCampoNumerico(String campo) {
        return campo.matches("[0-9]+");
    }

    public static boolean validaCampoString(String campo) {
        return !campo.equals("") && campo.matches("[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ'\\s]+");
    }
}
