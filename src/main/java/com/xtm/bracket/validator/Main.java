package com.xtm.bracket.validator;

/**
 * Entry point for the Bracket Validator application.
 * <p>
 * This class contains the {@code main} method which starts the console
 * application for reading bracket sequences, validating their format,
 * and checking if they are balanced.
 * </p>
 * <p>
 * The actual logic for reading input and validating sequences is delegated
 * to {@link BracketValidator#readAndValidate()}.
 * </p>
 */
public class Main {


    /**
     * Starts the Bracket Validator console application.
     * <p>
     * This method creates an instance of {@link BracketValidator} and invokes
     * its {@code readAndValidate()} method to begin reading input from the user.
     * </p>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        new BracketValidator().readAndValidate();
    }

}