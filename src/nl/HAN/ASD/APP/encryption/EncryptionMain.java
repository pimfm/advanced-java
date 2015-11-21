package nl.HAN.ASD.APP.encryption;

import java.math.BigInteger;

/**
 * Created by Pim van Gurp, 10/7/2015.
 */
public class EncryptionMain {
    public static void main(String[] args) {
        int N = 233234567;
        RSA key = new RSA(N);
        System.out.println(key);

        // create random message, encrypt and decrypt
        BigInteger message = new BigInteger(N-1, key.getRandom());

        //// create message by converting string to integer
        // String s = "test";
        // byte[] bytes = s.getBytes();
        // BigInteger message = new BigInteger(bytes);

        BigInteger encrypt = key.encrypt(message);
        BigInteger decrypt = key.decrypt(encrypt);
        System.out.println("message   = " + message);
        System.out.println("encrypted = " + encrypt);
        System.out.println("decrypted = " + decrypt);
    }
}
