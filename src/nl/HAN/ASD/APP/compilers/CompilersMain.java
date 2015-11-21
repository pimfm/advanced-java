package nl.HAN.ASD.APP.compilers;

import java.io.StringReader;

/**
 * Created by Pim van Gurp, 9/26/2015.
 */
public class CompilersMain {
    public static void main(String[] args) {
        String toRead =
                "public void aFunction() {" +
                    "int random = 10;" +
                    "setCoolStuff( withMoreStuffz() );" +
                    "andSomeUnclosedBusiness(" +
                "}";
        Balance balance = new Balance(new StringReader( toRead ));
        balance.checkBalance();
    }
}
