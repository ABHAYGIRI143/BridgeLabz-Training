import java.util.ArrayList;

public class UncheckedExample {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        ArrayList list = new ArrayList();

        list.add("Java");
        list.add(10);
        list.add(true);

        String value = (String) list.get(0);
        System.out.println(value);
    }
}
