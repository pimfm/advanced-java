package nl.HAN.ASD.APP.compilers;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;

/**
 * Created by Pim van Gurp, 9/26/2015.
 */
public class Tokenizer {
    /**
     * InputStream to check for errors
     */
    private PushbackReader in;

    /**
     * Current character checking
     */
    private char ch;

    /**
     * The line the compiler is currently checking
     * for syntax errors
     */
    private int currentLine;

    /**
     * Amount of errors found while checking stream
     */
    private int errors;

    /**
     * Represents a single line comment
     */
    public static final int SLASH_SLASH = 0;

    /**
     * represents a multi line comment
     */
    public static final int SLASH_STAR = 1;

    /**
     * Constructor for new Tokenizer
     * @param inStream stream to check for errors
     */
    public Tokenizer(Reader inStream) {
        errors = 0;
        ch = '\0';
        currentLine = 1;
        in = new PushbackReader( inStream );
    }

    /**
     * Give the line number the tokenizer is checking
     * @return current line
     */
    public int getLineNumber() {
        return currentLine;
    }

    /**
     * Get amount of errors found.
     * @return amount of errors
     */
    public int getErrorCount() {
        return errors;
    }

    /**
     * Scan the input for the next opening symbol
     * or closing symbol
     * @return opening or closing symbol
     */
    public char getNextOpenClose() {
        while(nextChar()) {
            if(ch == '/') {
                processSlash();
            } else if( ch == '\'' || ch == '"') {
                skipQuote( ch );
            } else if( ch == '(' || ch == '{' || ch == '[' ||
                       ch == ')' || ch == '}' || ch == ']' ){
                return ch;
            }
        }
        return '\0';
    }

    /**
     * Give the next character in the stream
     * @return next character
     */
    private boolean nextChar() {
        try {
            int readVal = in.read();

            if(readVal == -1) return false;
            ch = (char) readVal;

            if( ch == '\n' ) currentLine++;

            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Puck back the removed character to the
     * inputStream
     */
    private void putBackChar() {
        if( ch == '\n' ) currentLine--;

        try {
            in.unread( (int) ch );
        } catch (IOException e) {
            //
        }
    }

    /**
     * Do not check a comment but skip it.
     * @param start multi or single line comment
     */
    private void skipComment(int start) {
        if(start == SLASH_SLASH) {
            //noinspection StatementWithEmptyBody
            while(nextChar() && (ch != '\n')) {
                //
            }
            return;
        }
        boolean state = false;

        while( nextChar() ) {
            if(state && ch == '/') return;

            state = ( ch == '*' );
        }
        errors++;
        System.out.println("Unterminated Comment!");
    }

    /**
     * A string does not have to be checked for syntax
     * errors. Skip it
     * @param quoteType type of String
     */
    private void skipQuote(char quoteType) {
        while(nextChar()) {
            if(ch == quoteType) return;

            if(ch == '\n') {
                errors++;
                System.out.println("Missing closed quote at line: " + currentLine);
                return;
            } else if(ch == '\\') nextChar();
        }
    }

    /**
     * Process a slash character.
     * Could be a javaDoc or other comment.
     */
    private void processSlash() {
        if(nextChar()) {
            if(ch == '*') {
                //javadoc comment
                if(nextChar() && ch != '*')
                    putBackChar();

                skipComment( SLASH_STAR );
            } else if(ch == '/') {
                skipComment( SLASH_SLASH );
            } else if(ch != '\n') {
                putBackChar();
            }
        }
    }
}
