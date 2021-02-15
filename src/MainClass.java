import java.until.Scanner;
class Sotrudnik{
    String fam, im, otch, doljnost;
    int oklad;
}
public class MainClass {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество сотрудников");
        int count = sc.nextInt();
        sc.nextLine();
        Sotrudnik[] sotr = new Sotrudnik[count];

        for(int i=0; i < count; i++) {
            System.out.println("введите информацию о"+(i+1)+"-м сотруднике");
            sotr[i] = new Sotrudnik();
            System.out.println("Введите фамалию");
            sotr[i].fan= sc.nextLine();
        }
    }
}
