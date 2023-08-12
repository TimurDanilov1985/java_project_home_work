package PhoneBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Project {
    public static ArrayList<String> newphone(ArrayList<String> phones) {
        Input number = new Input();
        String phone = number.inp("Введите номер телефона: ");
        phones.add(phone);
        return phones;
    }

    public static String newname() {
        Input number = new Input();
        return number.inp("Введите имя: ");
    }

    public static void menu() {
        Map<String, ArrayList<String>> abonent = new HashMap<>();
        Input number = new Input();
        String name = "";
        String l = "";
        for ( ; ; ) {
            ArrayList<String> phones = new ArrayList<>();
            System.out.println("Введите - '1', чтобы добавить нового абонента");
            System.out.println("Введите - '2', для продолжения");
            System.out.println("Введите - '3', для выхода из программы");
            l = number.inp("Введите число: ");
            if (l.equals("1")) {
                name = newname();
                Set<String> keys = abonent.keySet();
                for (String k: keys){
                    if (k.equals(name)){
                        System.out.println("Такое имя уже существует");
                        System.exit(Integer.parseInt(l));
                    }
                }
                phones = newphone(phones);
                String n = "";
                for ( ; ; ) {
                    System.out.println("Введите - '1' для добавления очередного номера телефона");
                    System.out.println("Введите - '2' для окончательной записи данных");
                    n = number.inp("Введите число: ");
                    if (n.equals("1")) {
                        phones = newphone(phones);
                    } else if (n.equals("2")) {
                        break;
                    }
                }
            } else if (l.equals("2")) {
                break;
            } else if (l.equals("3")) {
                System.exit(Integer.parseInt(l));
            }
            abonent.put(name, phones);
            System.out.println(abonent);
        }
        String [] arrkeys = new String[abonent.size()];
        ArrayList[] arrvalues = new ArrayList[abonent.size()];
        String[] arrs = new String[abonent.size()];
        Set<String> keys = abonent.keySet();
        Integer i = 0;
        for (String k: keys){
            arrkeys[i] = k;
            arrvalues[i] = abonent.get(k);
            i++;
        }
        Integer a = 0;
        for (ArrayList m : arrvalues) {
            arrs[a] = m.toString();
            a++;
        }
        String temp ="";
        for (int j = 0; j < arrvalues.length; j++) {
            for (int k = 0; k < arrvalues.length; k++) {
                if (arrvalues[j].size() < arrvalues[k].size()){
                    temp = arrs[k];
                    arrs[k] = arrs[j];
                    arrs[j] = temp;
                    temp = arrkeys[k];
                    arrkeys[k] = arrkeys[j];
                    arrkeys[j] = temp;
                }
            }
        }
        for (int o = 0; o < arrs.length; o++) {
            System.out.println(arrkeys[o] + ":" + arrs[o]);
        }
    }
    public static void main(String[] args) {
        //Задание
        //Реализуйте структуру телефонной книги с помощью HashMap.
        //Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
        //их необходимо считать, как одного человека с разными телефонами.
        //Вывод должен быть отсортирован по убыванию числа телефонов.

        menu();
    }
}
