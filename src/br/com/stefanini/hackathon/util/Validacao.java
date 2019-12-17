package br.com.stefanini.hackathon.util;

import br.com.stefanini.hackathon.model.Candidato;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validacao {
    public static boolean validaCampoNumerico(String campo) {
        return campo.matches("[0-9]+");
    }

    public static boolean validaCampoString(String campo) {
        return !campo.equals("") && campo.matches("[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ'\\s]+");
    }

    public static Map<String, Integer> retornaFrequencia(List<Candidato> listaCandidatos) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (Candidato canditado : listaCandidatos) {
            int frequency = Collections.frequency(listaCandidatos, canditado);
            System.out.println(frequency);
            map.put(String.valueOf(canditado), frequency);
        }
        return map;
    }
}
