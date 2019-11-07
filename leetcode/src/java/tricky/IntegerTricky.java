package java.tricky;

public class IntegerTricky {
    public static void main(String[] args) {

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3; // -128 ~ 127 直接取IntegerCache 而不需要new
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;

        System.out.println(c == d); // true  -128 ~ 127 直接取IntegerCache 而不需要new ,所以比较的是IngeterCache的值
        System.out.println(e == f); // false 超过 127 则需要new
        System.out.println(c == (a + b)); // true 有计算的 会自动拆箱
        System.out.println(c.equals(a + b)); // true // a + b 是int类型
        System.out.println(g == (a + b)); // true 有计算的 == , + 会自动拆箱
        System.out.println(g.equals(a + b)); // false

        Integer x = new Integer(1);
        Integer y = new Integer(1);
        System.out.println(x == y); // false 明显new出来的对象 是不一样的地址

        /*Integer Long 类型的equals 如果比较的不是Long,Integer 的实例 直接返回false
        public boolean equals(Object obj) {
            if (obj instanceof Long) {
                return this.value == (Long)obj;
            } else {
                return false;
            }
        }
        */

    }


}
