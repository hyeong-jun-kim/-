import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String start = bf.readLine();
        String end = bf.readLine();
        while (end.length() != start.length()) {
            if (end.charAt(end.length() - 1) == 'A') {
                end = end.substring(0, end.length() - 1);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(end.substring(0, end.length() - 1));
                end = sb.reverse().toString();
            }
        }
        if (end.equals(start)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}