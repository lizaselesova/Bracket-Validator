package com.xtm.bracket.validator;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handles reading bracket sequences from the user, validating them,
 * and checking if they are balanced.
 * <p>
 * This class interacts with the console, reads user input line by line,
 * validates each line using {@link InputValidator}, and checks the balance
 * of brackets using {@link BracketBalanceService}. Results and warnings are logged.
 * </p>
 */
class BracketValidator {

    private static final Logger log = Logger.getLogger(BracketValidator.class.getName());
    private static final String INPUT_MESSAGE_PROMPT =
            "Enter bracket strings (Ctrl+D or Ctrl+Z + Enter) to finish):";
    private static final String INVALID_INPUT_MESSAGE =
            "Invalid input. String must be 2–999 chars and contain only (), {}, [].";

    private final InputValidator inputValidator = new InputValidator();
    private final BracketBalanceService bracketBalanceService = new BracketBalanceService();

    /**
     * Starts reading bracket sequences from the console.
     * <p>
     * For each line entered:
     * <ul>
     *     <li>Trims the input string</li>
     *     <li>Validates the format using {@link #isValidSequence(String)}</li>
     *     <li>If valid, checks if the brackets are balanced using {@link BracketBalanceService}</li>
     *     <li>Logs the result or a warning for invalid input</li>
     * </ul>
     * </p>
     */
    void readAndValidate() {
        try (Scanner scanner = new Scanner(System.in)) {
            log.info(INPUT_MESSAGE_PROMPT);

            while (scanner.hasNextLine()) {
                String sequence = scanner.nextLine().trim();
                if (isValidSequence(sequence)) {
                    log.log(Level.INFO, () -> String.valueOf(bracketBalanceService.isBalanced(sequence)));
                }
            }
        }
    }

    boolean isValidSequence(String sequence) {
        if (!inputValidator.isValid(sequence)) {
            log.warning(INVALID_INPUT_MESSAGE);
            return false;
        }
        return true;
    }

}


