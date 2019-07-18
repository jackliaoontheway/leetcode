package leetcode.primary.array;

public class StringSustring {
	public static void main(String[] args) {
		
		String s = "\"date/time\",\"settlement id\",\"type\",\"order id\",\"sku\",\"";
		s = s.replaceAll("\",\"", "&EDA&");
		System.out.println(s);
	}
}
