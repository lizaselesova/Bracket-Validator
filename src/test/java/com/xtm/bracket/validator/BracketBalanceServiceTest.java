package com.xtm.bracket.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class BracketBalanceServiceTest {

    private BracketBalanceService bracketBalanceService;

    @BeforeEach
    void setUp() {
        bracketBalanceService = new BracketBalanceService();
    }

    @ParameterizedTest(name = "Balanced sequence: \"{0}\" should return true")
    @ValueSource(strings = {
            "()",
            "{}[]",
            "({[]})",
            "([]{})",
            "({[({})]})" // вложенные скобки
    })
    void isBalanced_givenValidSequences_returnsTrue(String sequence) {
        Assertions.assertTrue(bracketBalanceService.isBalanced(sequence));
    }

    @ParameterizedTest(name = "Unbalanced sequence: \"{0}\" should return false")
    @ValueSource(strings = {
            "(",
            ")",
            "({[)]}",
            "({}",
            "({[]})(",
            "({[]})]",
            ""
    })
    @NullSource
    void isBalanced_givenInvalidOrEmptySequences_returnsFalse(String sequence) {
        Assertions.assertFalse(bracketBalanceService.isBalanced(sequence));
    }

}