package com.pro.RSA;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;

import org.bouncycastle.util.encoders.Base64;

public class TestRSA {
	public static void main(String args[]) throws Exception{
		createKeyPairs();
	}
	public static void createKeyPairs() throws Exception {  
	    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());  
	    // create the keys  
	    KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA", "BC");  
	    generator.initialize(512, new SecureRandom());  
	    KeyPair pair = generator.generateKeyPair();  
	    PublicKey pubKey = pair.getPublic();  
	    PrivateKey privKey = pair.getPrivate();  
	    byte[] pk = pubKey.getEncoded();  
	    byte[] privk = privKey.getEncoded();  
	    String strpk = new String(Base64.encode(pk));  
	    String strprivk = new String(Base64.encode(privk));  
	  
	    System.out.println("公钥:" + Arrays.toString(pk));  
	    System.out.println("私钥:" + Arrays.toString(privk));  
	    System.out.println("公钥Base64编码:" + strpk);  
	    System.out.println("私钥Base64编码:" + strprivk);  
	  
	    X509EncodedKeySpec pubX509 = new X509EncodedKeySpec(Base64.decode(strpk.getBytes()));  
	    PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(strprivk.getBytes()));  
	  
	    KeyFactory keyf = KeyFactory.getInstance("RSA", "BC");  
	    PublicKey pubkey2 = keyf.generatePublic(pubX509);  
	    PrivateKey privkey2 = keyf.generatePrivate(priPKCS8);  
	  
	    System.out.println(pubKey.equals(pubkey2));  
	    System.out.println(privKey.equals(privkey2));  
	}
}
