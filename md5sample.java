import java.security.*;

public class md5sample{
	public static void main(String args[]){		
		// ①適当な文字列を用意
		String plainText = "abcdefgh";

		try{
			// ②MessageDigestのインスタンスを生成
			MessageDigest md = MessageDigest.getInstance("MD5");
			// ③文字列のバイト列をupdate
			md.update(plainText.getBytes());

			// ④変換後バイト列を取得
			byte[] hashBytes = md.digest();

			// ⑤16進数に変えつつ桁数を補正
			int[] hashInts = new int[hashBytes.length];
			StringBuilder sb = new StringBuilder();
			for (int i=0; i < hashBytes.length; i++) {
				hashInts[i] = (int)hashBytes[i] & 0xff;
				if (hashInts[i] <= 15) {
					sb.append("0");
				}
				sb.append(Integer.toHexString(hashInts[i]));
			}

			// ⑥標準出力
			String hashText = sb.toString();
			System.out.println("Original Text:" + plainText);
			System.out.println("MD5 Hash Text:" + hashText);

		}catch(Exception e){

		}


	}
}
