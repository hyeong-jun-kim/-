package LastWeekMarch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class ValueOfBrackets {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<String> stack = new Stack<>();
        stack.push(input.split("")[0]);
        boolean key = false;
        int result = 0;

        for(int i=1; i<input.length(); i++){
            String bracket = input.split("")[i];
            if(")]".contains(bracket)){
                int res = popBracket(stack,bracket);
                result+=res;
                if(stack.size()>0 && "([".contains(stack.lastElement())){
                    key=true;
                }
            }
            else if("([".contains(bracket)){
                if(key){
                    stack.push(" ");
                    key = false;
                }
                stack.push(bracket);
            }
        }
        if(stack.size()!=0) result = 0;
        System.out.println(result);
    }

    public static int checkValue(String s){
        if("()".contains(s)){return 2;}
        else if("[]".contains(s)){ return 3;}
        else if(" ".equals(s)) {return 1;}
        else return 0;
    }

    public static int popBracket(Stack<String> stack, String bracket){
        int res = 0;
        if((stack.size() > 0) &&(
                (stack.lastElement()+bracket).equals("()") ||
                        (stack.get(stack.size()-1)+bracket).equals("[]"))){
            res = checkValue(stack.lastElement());
            int pre = 0;
            stack.pop();
            if(stack.size()>0){
                if(checkValue(stack.lastElement()) != 1){pre=1;}
                for(int i=stack.size()-1; i>=0; i--){
                    res *= checkValue(stack.get(i));
                    pre *= checkValue(stack.get(i));
                }
                res = res - pre;
                if(checkValue(stack.lastElement())==1){stack.pop();}
            }
        }
        else {
            System.out.println(0);
            System.exit(0);
        }
        return res;
    }
}
