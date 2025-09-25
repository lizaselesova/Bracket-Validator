# Bracket Validator

###  Exercise

<p>A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].
Two brackets are considered to be a matched pair if the opening bracket (i.e., (, [,
or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type.
There are three types of matched pairs of brackets: [], {}, and ().
A matching pair of brackets is not balanced if the set of brackets it encloses are
not matched. 
For example, {[(])} is not balanced because the contents in
between { and } are not balanced. 
The pair of square brackets encloses a single,
unbalanced opening bracket, (, and the pair of parentheses encloses a single,
unbalanced closing square bracket, ].</p> 

#### By this logic, we say a sequence of brackets is balanced if the following conditions are met:

- It contains no unmatched brackets.</ul>
- The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.

Given strings of brackets, determine whether each sequence of brackets is
balanced. If a string is balanced, return true. Otherwise, return false. 

## Description
An application for validating and checking the balance of bracket sequences:
- Round brackets `()`
- Square brackets `[]`
- Curly brackets `{}`

The application reads strings from the console, checks their format, and verifies if the brackets are balanced.

---

## Validation Rules
1. String length: ` 1 < s < 1000`
2. Allowed characters: `(){}[]`

---

## Project Structure

```
com.xtm.bracket.validator
│
├─ Main.java // Entry point
├─ BracketValidator.java // Validation + balance checking
├─ InputValidator.java // Checks length and allowed characters
└─ BracketBalanceService.java // Checks bracket balance using a stack
```
---

## Installation and Running

### Requirements

- Java 17+
- Maven 

### Build

```bash
mvn clean compile
```

### Run Console Application

```bash
mvn exec:java -Dexec.mainClass="com.xtm.bracket.validator.Main"
```

---

### Programmatic Usage

```
BracketValidator validator = new BracketValidator();
List<String> sequences = List.of("()", "({[]})", "(]", "abc");
```

```
List<Boolean> results = validator.validateSequences(sequences);

true — valid and balanced

false — valid but unbalanced

null — invalid format
 ```

---

### Parameterized Test Example

```
@ParameterizedTest
@ValueSource(strings = {"()", "{}", "[]", "({[]})"})
void validateSequences_givenValidSequences_returnsTrue(String sequence) {
    BracketValidator validator = new BracketValidator();
    List<Boolean> results = validator.validateSequences(List.of(sequence));
    assertEquals(Boolean.TRUE, results.get(0));
}
 ```

---


### Algorithm Complexity

### InputValidator.class
#### Time complexity: O(n) — iterate through all characters of the sequence

#### Memory complexity: O(1) (constant set of allowed characters)

---

### BracketBalanceService.class
#### Time complexity: O(n) — each opening/closing bracket is processed once

#### Memory complexity: O(n) — the stack can store all open brackets

---

### Why this approach:

#### Using a stack is the standard and optimal way to check bracket nesting.

#### BRACKET_PAIRS Map allows fast matching of closing brackets.

#### Sequence validation is separated for readability and testability.

---

## Running Tests
### Maven

```bash
mvn test
```

## Tests cover:

### 1. Valid minimum and maximum sequences

### 2. Unbalanced sequences

### 3. Invalid characters

### 4. Empty and null strings

### 5. Long sequences (performance edge cases)

---


## Implementation Highlights

### BracketValidator separates logic from console, making it fully testable.

### BracketBalanceService uses a stack to verify proper nesting.

### InputValidator checks length and allowed characters.

### Methods are short, readable, and constants are extracted.

### Parameterized tests cover all key scenarios.