package leetcode.primary.stack;

public class TestMyStack {

    public static void main(String[] args) {
        MyStack s = new MyStack(5);
        s.push(1);
        s.push(2);
        s.push(3);
        for (int i = 0; i < 4; ++i) {
            if (!s.isEmpty()) {
                System.out.println(s.top());
            }
            System.out.println(s.pop());
        }
    }

}
