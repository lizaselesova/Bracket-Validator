package com.xtm.bracket.validator;

import java.util.Set;

/**
 * Validates a sequence string.
 * <p>
 * A valid sequence:
 * <ul>
 *     <li>Contains only the characters: '(', ')', '{', '}', '[', ']'</li>
 *     <li>Has a length between 2 and 999 inclusive</li>
 * </ul>
 * </p>
 */
class InputValidator {

    private static final Set<Character> ALLOWED_CHARS = Set.of('(', ')', '{', '}', '[', ']');
    private static final int MIN_INPUT_LENGTH = 2;
    private static final int MAX_INPUT_LENGTH = 999;

    /**
     * Checks if the given string is a valid sequence.
     *
     * @param input the string to validate
     * @return {@code true} if the string is not null, has a length between
     * {@value #MIN_INPUT_LENGTH} and {@value #MAX_INPUT_LENGTH} inclusive,
     * and contains only allowed characters; {@code false} otherwise
     */
    boolean isValid(String input) {
        if (input == null
                || input.length() < MIN_INPUT_LENGTH
                || input.length() > MAX_INPUT_LENGTH) {
            return false;
        }

        for (char ch : input.toCharArray()) {
            if (!ALLOWED_CHARS.contains(ch)) {
                return false;
            }
        }

        return true;
    }

}

