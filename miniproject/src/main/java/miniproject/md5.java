package miniproject;

import java.security.MessageDigest;

import org.springframework.stereotype.Repository;

abstract class md5 {
	public String md5_code(String pw) throws Exception {
		StringBuilder sb = new StringBuilder();
		String md5_data = "";
		
		MessageDigest md = MessageDigest.getInstance("md5");
		md.update(pw.getBytes());
		byte md5byte[] = md.digest();
		
		for(byte alg : md5byte) {
			sb.append(String.format("%01x", alg));
		}
		md5_data = String.valueOf(sb);		
		
		return md5_data;
	}
}
