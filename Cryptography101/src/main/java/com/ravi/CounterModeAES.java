/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravi;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author ravi
 */
public class CounterModeAES {
    
    public static enum Mode{
        ENCRYPT,
        DECRYPT
    }

    private Cipher cipher;
    private SecretKey key;

    public CounterModeAES(byte[] raw) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        this.cipher = Cipher.getInstance("AES/CTR/NoPadding");
        this.key = new SecretKeySpec(raw, "AES");      
    }
    
    public byte[] decrypt(byte[] raw, IvParameterSpec ivSpec) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException{
        this.cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
        return this.cipher.doFinal(raw);
    }
    
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException{
        String ctHex = "e46218c0a53cbeca695ae45faa8952aa0e311bde9d4e01726d3184c34451";
        byte[] raw = new byte[ctHex.length()/2];
        
        String keyStr = "36f18357be4dbd77f050515c73fcf9f2";
        byte[] keyRaw = new byte[16];
        
        String ivStr =  "770b80259ec33beb2561358a9f2dc617";
        byte[] ivRaw = new byte[16];
        
        for(int ctr = 0 ; ctr < ctHex.length() ; ctr = ctr+2){
            raw[ctr/2] = (byte) ((Character.digit(ctHex.charAt(ctr), 16) << 4)
                             + Character.digit(ctHex.charAt(ctr+1), 16));
             
        }
        
        for(int ctr = 0 ; ctr < keyStr.length() ; ctr = ctr+2){
             
            keyRaw[ctr/2] = (byte) ((Character.digit(keyStr.charAt(ctr), 16) << 4)
                             + Character.digit(keyStr.charAt(ctr+1), 16));
             
            ivRaw[ctr/2] = (byte) ((Character.digit(ivStr.charAt(ctr), 16) << 4)
                             + Character.digit(ivStr.charAt(ctr+1), 16));
        }
                
        CounterModeAES aes = new CounterModeAES(keyRaw);
        byte[] rawResults = aes.decrypt(raw,new IvParameterSpec(ivRaw));
        System.out.println("Decrypted result is " + DatatypeConverter.printHexBinary(rawResults));
        System.out.println("Decrypted result is " + new String(rawResults));
    }

}
