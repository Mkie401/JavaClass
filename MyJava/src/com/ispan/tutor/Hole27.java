// 身份證字號驗證
package com.ispan.tutor;

import com.ispan.apis.TWid;


public class Hole27 {
//
//	public static void main(String[] args) {
//		double rand = Math.random();
//		System.out.println(rand);
//		boolean isRightID = TWid.isRight("A323456789");
//		System.out.println(isRightID);
//		
//		String id = "A123456789";    // 正規表示法 [0-9]{8}表示0-9出現8次
//		System.out.println(TWid.isRight(id));
	
	
	public static void main(String[] args) {
		TWid id1 = new TWid();
		System.out.println(id1.getId());
		TWid id2 = new TWid('A');
		System.out.println(id2.getId());
		TWid id3 = new TWid(false);
		System.out.println(id3.getId());
		
		
	}

}
