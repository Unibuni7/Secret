/*
 *  Developed by Abdulmuaz Alshaikhli
 * Slmnshukur1993@gmail.com
 * Student Easj.dk 2017. 
 MIT Licensed.
 */
package secret;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.*;
import java.util.Scanner;

/**
 *
 * @author slmns
 */
public class Secret {
    
       private static final String ALGO = "AES";
       private static final byte[] keyValue = new byte [] {'T','h','e','B','e','s','t',
               'S','e','c','r','e','t','K','e','y'};

       
       public static String encrypt(String Data) throws Exception {
         Key key = generateKey();
         Cipher c = Cipher.getInstance(ALGO);
         c.init(Cipher.ENCRYPT_MODE,key);
         byte[] encVal = c.doFinal(Data.getBytes());
         String encryptedValue = new BASE64Encoder().encode(encVal);
         return encryptedValue;
       }
       
       public static String decrypt (String encryptedData) throws Exception {
           Key key = generateKey();
           Cipher c = Cipher.getInstance(ALGO);
           c.init(Cipher.DECRYPT_MODE, key);
           byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
           byte [] decValue = c.doFinal(decordedValue);
           String decryptedValue = new String(decValue);
           return decryptedValue;
       }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        String s = new String (keyValue);
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter key Value");
        String key = scan.next();
        s = key;
        
        System.out.println("Enter password ");
        String pass = scan.next(); 
        
        String password = pass;
        System.out.println("Enter Key Value again");
       String key2 = scan.next();
       key2 = key;
       
        
        String passwordEnc = Secret.encrypt(password);
        
        String passwordDec = Secret.decrypt(passwordEnc);
        
        
        System.out.println("Encrypted text " + passwordEnc);
        
        
        if(key2.equals(s)){
            System.out.println( "Decrypted text " + passwordDec);
        } else{
            System.out.println("Wrong");
        }
        
        
     
    }

    private static Key generateKey() {
        Key key = new SecretKeySpec(keyValue,ALGO);
        return key;
    }
    
}
