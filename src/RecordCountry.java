package recordcountry;
import java.util.Scanner;

class Country{
    String name;
    double square;
}

public class RecordCountry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ведите количество стран>> ");
        int n = sc.nextInt();
        Country country[] = new Country[n];
        System.out.println("Введите информацию о странах: ");
        for (int i = 0; i < country.length; i++) {
            sc.nextLine();
            country[i] = new Country();
            System.out.print("Название " + (i + 1) + "-й страны>> ");
            country[i].name = sc.nextLine();
            System.out.print("Площадь " + (i + 1) + "-й страны>> ");
            country[i].square = sc.nextDouble();
        }
        System.out.println("\nХарактерристика стран: ");
        for (Country c : country) {
            System.out.println("" + c.name + "\t" + c.square + " кв. км.");
        }

        int nommax = 0;
        double max = country[nommax].square;
        for (int i = 0; i < country.length; i++) {
            if (country[i].square > max) {
                max = country[i].square;
                nommax = i;
            }
        }
        System.out.println("\nСтрана с максимальной площадью: ");
        System.out.println("" + country[nommax].name + "\t" + country[nommax].square + "кв. км.");

        for (int i = 0; i < country.length - 1; i++) {
            for (int j = 0; j < country.length - 1 - i; j++) {
                if (country[j].square > country[j + 1].square) {
                    Country rab = country[j];
                    country[j] = country[j + 1];
                    country[j + 1] = rab;
                }
            }
        }
        System.out.println("\nОтсортированный список по площади: ");
        for (int i = 0; i <= country.length - 1; i++) {
            System.out.println("" + country[i].name + "\t" + country[i].square + " кв. км");
        }

        for (int i = 0; i < country.length - 1; i++) {
            for (int j = 0; j < country.length - i - 1; j++) {
                if (country[j].name.compareTo(country[i + 1].name) > 0) {
                    Country rab = country[j];
                    country[j] = country[j + 1];
                    country[j + 1] = rab;
                }
            }
        }
        System.out.println("\nОтсортированный список по названиям: ");
        for (Country c : country) {
            System.out.println("" + c.name + "\t" + c.square + " кв. км");
        }

        double s=0;
        for (Country value : country) {
            s += value.square;
        }
        double avgC = s/country.length;
        System.out.println("\nСредняя площадь =" + avgC);
        System.out.println("\nСтраны, с площадью больше средней: ");
        for (Country c : country) {
            if (c.square > avgC)
                System.out.println(c.name + "\t" + c.square + " млн кв. км");
        }

        sc.nextLine();
        System.out.println("\nВведите название искомой страны: ");
        String name = sc.nextLine();
        int nom = -1;

        for (int i = 0; i < country.length; i++) {
            if (name.equalsIgnoreCase(country[i].name))
                nom = i;
        }
        if (nom!= -1) {
            System.out.println("Такая страна есть в списке. Это " + country[nom].name + " " + country[nom].square+ " кв. км");
        }
        else System.out.println("Такой страны нет в списке");

    }
}