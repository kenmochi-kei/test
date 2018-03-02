package com.internousdev.cherry.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class PassGenerator {


	public String FakeID() throws UnknownHostException{
		      InetAddress addr = InetAddress.getLocalHost();
		      InetAddress addr2 = InetAddress.getLocalHost();
		      if (addr.equals(addr2)) System.out.println("addrとaddr2は同じインスタンス");
		      System.out.println("Local Host Name: " + addr.getHostName());
		      System.out.println("IP Address     : " + addr.getHostAddress());


		String str1=addr.getHostName();
		String str2=addr.getHostAddress();

		String str3=str1.substring(str1.length()-3);
		String str4=str2.substring(str2.length()-3);
		String fakeId=str3+str4;
		return fakeId;
	}

}
