import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AlbumCopa {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            list.add(a);
        }

        int total = list.stream().distinct().collect(Collectors.toList()).size();
        System.out.println(n - total);
    }

}
