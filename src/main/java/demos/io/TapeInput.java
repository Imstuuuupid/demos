package demos.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 键盘输入
 * @author xzx
 * @date 2021/02/08 10/22
 */
public class TapeInput {
    public static void main(String[] args) {

        methodSecond();
    }

    public static void methodFirst(){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(s);
        in.close();
    }

    private static void methodSecond(){
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = in.readLine();
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
