import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Run {

    public static void main(String[] args) {

        BufferedReader br = null;

        try {

            br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {

                System.out.print("Enter expression : ");
                String input = br.readLine();

                if ("q".equals(input)) {
                    System.out.println("Exit!");
                    System.exit(0);
                }

                System.out.println("input : " + input);
                System.out.println("output : " + PolishNotation.reverse(input));
                System.out.println("-----------\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
