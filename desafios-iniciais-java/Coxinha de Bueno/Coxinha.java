import java.util.Scanner;

public class Coxinha {
    public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();

            String[] inputSplit = input.split(" ",2);
//TODO: Complete os espaços em branco com uma possível solução para o desafio
            double media = Double.parseDouble(inputSplit[0])/Double.parseDouble(inputSplit[1]);
            System.out.printf("%.2f\n", media);

    }
}


