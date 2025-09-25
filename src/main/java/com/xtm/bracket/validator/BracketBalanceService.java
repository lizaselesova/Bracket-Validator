package com.xtm.bracket.validator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Objects;

/**
 * Service for checking whether a bracket sequence is balanced.
 * <p>
 * Supports round (), square [], and curly {} brackets.
 * Uses a stack to ensure each opening bracket has a corresponding closing bracket in the correct order.
 * </p>
 */
class BracketBalanceService {

    private static final Map<Character, Character> BRACKET_PAIRS = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
    );

    /**
     * Checks if the given bracket sequence is balanced.
     * <p>
     * A sequence is balanced if:
     * <ul>
     *     <li>Every opening bracket has a corresponding closing bracket of the same type.</li>
     *     <li>Brackets are closed in the correct order.</li>
     * </ul>
     * </p>
     *
     * @param sequence the string containing only brackets
     * @return {@code true} if the sequence is balanced, {@code false} otherwise
     */
    boolean isBalanced(String sequence) {

        if (sequence == null || sequence.isEmpty()) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>(sequence.length());

        for (char bracket : sequence.toCharArray()) {
            if (BRACKET_PAIRS.containsValue(bracket)) {
                stack.push(bracket);
            } else if (BRACKET_PAIRS.containsKey(bracket) && (stack.isEmpty()
                    || !Objects.equals(stack.pop(), BRACKET_PAIRS.get(bracket)))) {
                return false;
            }

        }
        return stack.isEmpty();
    }

}