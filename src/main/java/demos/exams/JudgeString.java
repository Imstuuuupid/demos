package demos.exams;

import java.util.Stack;

/**
 * 判断字符串"({})[]"之类是否合法
 * @author xzx
 * @date 2021/02/24 22/26
 */
public class JudgeString {
    public static void main(String[] args) {
        String a = "({[{}]})";
        System.out.println(judgeString(a));
    }

    public static boolean judgeString(String str) {
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char a : chars) {
            if (a == '(' || a == '{' || a == '[') {
                stack.push(a);
            }
            if (a == ')') {
                if (stack.pop() != '(') {
                    return false;
                }
            } else if (a == ']') {
                if (stack.pop() != '[') {
                    return false;
                }
            } else if (a == '}'){
                if (stack.pop() != '{'){
                    return false;
                }
            }
        }

        return true;

    }
}
