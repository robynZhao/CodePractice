import java.util.ArrayList;
import java.util.List;

public class PurchasingSupply {
    public static  void main(String[] args) {
        List<Integer> a = new ArrayList<>();

        a.add(0, 10);
        a.add(1, 2);
        a.add(2, 5);

        result(a);
    }

    public static void result(List<Integer> a) {
        int n = a.get(0);
        int cost = a.get(1);
        int m = a.get(2);

        int containers= n / cost;

        int result = containers;

        int remainder = n % cost;

        System.out.println("remainder first: " + remainder);
        System.out.println("containers first: " + containers);
        System.out.println("result first: " + result);
        System.out.println("------------------------");

        while(containers >= m) {
            int shang = containers / m;

            remainder += containers % m;

            result += shang;

            System.out.println("shang : " + shang);
            System.out.println("remainder : " + remainder);
            System.out.println("containers : " + containers);
            System.out.println("result : " + result);
            System.out.println("------------------------");


            if(remainder >= m) {
                containers = shang + remainder;
                remainder = 0;
            } else {
                containers = shang;
            }

            System.out.println("remainder after if: " + remainder);
            System.out.println("containers after if: " + containers);
            System.out.println("------------------------");

        }

        System.out.println("remainder final: " + remainder);
        System.out.println("containers final: " + containers);
        System.out.println("------------------------");

        result += (remainder + containers) / m;

        System.out.println(result);
    }
}
