package com.shiva.myssiach3ex2;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

public class Test {
    public static void main(String[] args) {

        String salt = KeyGenerators.string().generateKey();
        String password = "pass";
        String bankName = "Axis";

        TextEncryptor e = Encryptors.delux(password, salt);
        String encrypted = e.encrypt(bankName);
        String decrypted = e.decrypt(encrypted);

        System.out.println(encrypted);
        System.out.println(decrypted);
    }
}
