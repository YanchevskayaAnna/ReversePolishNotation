import sun.security.util.Length;

import java.util.LinkedList;
import java.util.List;

public class PolishNotation {

    public static final String OPERANDS = "[+,-,*,/,^,(]";
    public static final String A_Z = "[a-z]";

    public static int getPriority(String s1){

        int pris1 = 0;
        if (s1.equals("(")){
            pris1 = 0;
        }
        if (s1.matches("[+-]")){
            pris1 = 1;
        }
        if (s1.matches("[*/]")){
            pris1 = 2;
        }
        if (s1.equals("^")){
            pris1 = 3;
        }
        return pris1;
    }

    public static String reverse( String input){

        String output = "";

        List<String> charList = new LinkedList<String>();

        for (String c : input.split("")) {

            if (c.equals(" ")){
                continue;
            }

            if (c.equals(")")){
                int k = charList.size();
                String newS = "";
                while (!newS.equals("(") & charList.size() > 0)  {
                    newS = charList.get(k-1);
                    charList.remove(k-1);
                    if (!newS.equals("(")){
                    output = output + newS;}
                    k--;
                }
                if (!newS.equals("(")) {
                    System.out.println("brackets not matched!");
                    return input;
                }
                continue;
            }

            if (c.matches(A_Z)){
                output = output + String.valueOf(c);
                continue;
            }

            if (c.matches(OPERANDS)){
                int priority = getPriority(c);
                if (priority <= 1) {  charList.add(String.valueOf(c)); continue;} //+- or (

                while (charList.size() > 0){

                    int k = charList.size();
                    String newS = charList.get(k-1);
                    if (newS == "(") {break;}
                    if (getPriority(String.valueOf(c)) <= getPriority(newS)) {
                        charList.remove(k-1);
                        output = output + newS;
                    }
                    else break;
                }

                charList.add(String.valueOf(c));
                continue;
            }

            System.out.println("the expression contains invalid characters");
            return input;
        }

        for(String s: charList){
            output = output + s;
        }

        return output;
    }
}
