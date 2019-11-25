package br.com.stefanini.hackathon.teste;

import br.com.stefanini.hackathon.util.Validacao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidacaoTest {

    @ParameterizedTest
    @ValueSource(strings = {"65", "34", "234"})
    void validaCampoNumerico(String numeral) {
        assertTrue(Validacao.validaCampoNumerico(numeral));
    }

    @Test
    void validaCampoString() {
        assertFalse(Validacao.validaCampoString("56sdds32"));
        assertFalse(Validacao.validaCampoString("56sdds"));
        assertFalse(Validacao.validaCampoString("sdds32"));
        assertFalse(Validacao.validaCampoString("23"));
        assertTrue(Validacao.validaCampoString("Lucas"));
        assertTrue(Validacao.validaCampoString("Pandora Automovel"));
        assertTrue(Validacao.validaCampoString("ábracadabra"));
    }
}