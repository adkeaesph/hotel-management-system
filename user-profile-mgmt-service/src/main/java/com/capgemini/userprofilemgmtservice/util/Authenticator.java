package com.capgemini.userprofilemgmtservice.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;



public class Authenticator {



	public static String encrypt(String strClearText, String strKey) throws Exception {
		String strData = "";

		try {

			SecretKeySpec skeyspec = new SecretKeySpec(strKey.getBytes(), "Blowfish");
			Cipher cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
			byte[] encrypted = cipher.doFinal(strClearText.getBytes());
			strData = new String(encrypted);

		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}
		return strData;
	}


	public static String decrypt(String strEncrypted, String strKey) throws Exception {
		String strData = "";

		try {

			SecretKeySpec skeyspec = new SecretKeySpec(strKey.getBytes(), "Blowfish");
			Cipher cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.DECRYPT_MODE, skeyspec);
			byte[] decrypted = cipher.doFinal(strEncrypted.getBytes());
			strData = new String(decrypted);

		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}
		return strData;
	}

	
}
