package PhoneBook;

import java.util.Scanner;

public class Input {
    public String inp(String x){
        Scanner line = new Scanner(System.in, "ibm866");
        System.out.print(x);
        String value = line.nextLine();
        return value;
    }
}
