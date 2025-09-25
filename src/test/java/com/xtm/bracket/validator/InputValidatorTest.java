package com.xtm.bracket.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

class InputValidatorTest {

    private static final int MAX_INPUT_LENGTH = 999;

    private static final int EXCEEDING_MAX_INPUT_LENGTH = 1000;

    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "()",
            "{}[]()",
            "({[]})"
    })
    void isValid_givenValidSequences_returnsTrue(String sequence) {
        Assertions.assertTrue(inputValidator.isValid(sequence));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "",
            "(",
            "abc",
            "()a{}",
            "[1]"
    })
    @NullSource
    void isValid_givenInvalidSequences_returnsFalse(String sequence) {
        Assertions.assertFalse(inputValidator.isValid(sequence));
    }

    @Test
    void isValid_givenMinimumLengthSequence_returnsTrue() {
        String sequence = "()";
        Assertions.assertTrue(inputValidator.isValid(sequence));
    }

    @Test
    void isValid_givenMaximumLengthSequence_returnsTrue() {
        char[] bracketChars = new char[MAX_INPUT_LENGTH];
        Arrays.fill(bracketChars, '(');
        String sequence = new String(bracketChars);
        Assertions.assertTrue(inputValidator.isValid(sequence));
    }

    @Test
    void isValid_givenSequenceExceedingMaximumLength_returnsFalse() {
        char[] bracketChars = new char[EXCEEDING_MAX_INPUT_LENGTH];
        Arrays.fill(bracketChars, '(');
        String sequence = new String(bracketChars);
        Assertions.assertFalse(inputValidator.isValid(sequence));
    }
}