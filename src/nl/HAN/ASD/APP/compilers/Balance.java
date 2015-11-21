package nl.HAN.ASD.APP.compilers;

import nl.HAN.ASD.APP.dataStructures.MyStack;

import java.io.Reader;

/**
 * Created by Pim van Gurp, 9/26/2015.
 */
public class Balance {
    /**
     * Amount of errors found while balancing
     */
    private int errors;

    /**
     * Tokenizer used to process a stringReader
     */
    private Tokenizer tokenizer;

    /**
     * Constructor of balance
     * @param inStream an input stream to check for syntax errors
     */
    public Balance( Reader inStream) {
        errors = 0;
        tokenizer = new Tokenizer( inStream );
    }

    /**
     * Check the inputStream for syntax errors.
     * Increment errors when syntax errors are found.
     * @return amount of errors found
     */
    public int checkBalance() {
        char ch;
        Symbol match;
        MyStack<Symbol> pendingTokens = new MyStack<>();

        while( (ch = tokenizer.getNextOpenClose() ) != '\0' ) {
            Symbol lastSymbol = new Symbol( ch, tokenizer.getLineNumber() );

            switch (ch) {
                case '(': case '{': case '[':
                    pendingTokens.push(lastSymbol);
                    break;

                case ')': case '}': case ']':
                    if(pendingTokens.isEmpty()) {
                        errors++;
                        System.out.println("Closing symbol found without opening symbol" +
                                " at line: " + tokenizer.getLineNumber());
                    } else {
                        match = pendingTokens.pop();
                        checkMatch( match, lastSymbol );
                    }
                    break;
                default:
                    break;
            }
        }

        while( !pendingTokens.isEmpty() ) {
            match = pendingTokens.pop();
            if(match != null)
                System.out.println("Unmatched " + match.token + " at line: " + match.line);
            errors++;
        }
        return errors + tokenizer.getErrorCount();
    }

    /**
     * Internal class Symbol used to represent
     * a single character in the input Stream
     */
    private static class Symbol {
        public char token;
        public int line;

        public Symbol(char token, int line) {
            this.token = token;
            this.line = line;
        }
    }

    /**
     * Check if an opening symbol corresponds with a closing symbol.
     * @param open opening symbol
     * @param close closing symbol
     */
    private void checkMatch( Symbol open, Symbol close) {
        if( open.token == '(' && close.token != ')' ||
            open.token == '{' && close.token != '}' ||
            open.token == '[' && close.token != ']' ) {
                System.out.println("Found " + close.token + " on line: " + close.line + " that does not match " +
                                    open.token + " at line: " + open.line);
                errors++;
        }
    }
}
