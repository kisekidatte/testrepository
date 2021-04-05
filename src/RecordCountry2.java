import java.util.Scanner;

class Country{
    String name;
    double square;
}

public class RecordCountry2{
    public static Country[] setCountryArr(int k){
        Scanner sc = new Scanner(System.in);
        Country country[] = new Country[k];

        System.out.println("Введите информацию о странах: ");
        for (int i = 0; i < country.length; i++){
            country[i] = new Country();
            System.out.print("Название " + (i + 1) + "-й страны>> ");
            country[i].name = sc.nextLine();
            System.out.print("Площадь " + (i + 1) + "-й страны>> ");
            country[i].square = sc.nextDouble();
            sc.nextLine();
        }
        return country;
    }

    public static void showArray(Country[] cntr){
        for (Country c : cntr) {
            System.out.println("" + c.name + "\t" + c.square + " кв. км");
        }
    }

    public static void showCountry(Country cntr){
        System.out.println(""+cntr.name+"\t"+cntr.square+" кв. км");
    }

    public static int nomMax(Country[] cntr){
        int nommax = 0;
        double max = cntr[nommax].square;
        for (int i = 0; i < cntr.length; i++)
            if (cntr[i].square > max) {
                max = cntr[i].square;
                nommax = i;
            }
        return nommax;
    }

    public static void sortSquare(Country[] cntr){
        for (int i = 0; i < cntr.length - 1; i++) {
            for (int j = 0; j < cntr.length - 1 - i; j++) {
                if (cntr[j].square > cntr[j + 1].square) {
                    Country rab = cntr[j];
                    cntr[j] = cntr[j + 1];
                    cntr[j + 1] = rab;
                }
            }
        }
    }

    public static void sortName(Country[] cntr){
        for (int i = 0; i < cntr.length-1; i++) {
            for (int j = 0; j < cntr.length - i - 1; j++) {
                if (cntr[j].name.compareTo(cntr[i + 1].name) > 0) {
                    Country rab = cntr[j];
                    cntr[j] = cntr[j + 1];
                    cntr[j + 1] = rab;
                }
            }
        }
    }

    public static double avgSquare(Country[] cntr){
        double s = 0;
        for (Country country : cntr) {
            s += country.square;
        }
        double avgC = s/cntr.length;

        return avgC;
    }

    public static Country[] avgBig(Country[] cntr){
        double avgSq = avgSquare(cntr);
        int qu = 0;
        for (Country country : cntr) {
            if (country.square > avgSq)
                ++qu;
        }
        if (qu != 0){
            Country[] avgCountry= new Country[qu];
            int n = -1;
            for (Country country : cntr)
                if (country.square > avgSq) {
                    avgCountry[++n] = country;
                }
            return avgCountry;
        }
        else return null;
    }

    public static Country findName(Country[] cntr, String name){
        int n=-1;
        for (int i = 0; i < cntr.length; i++)
            if (name.equals(cntr[i].name))
                n = i;
        if (n != -1) {
            return cntr[n];
        }
        else return null;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Введите количество стран>> ");
        int n=sc.nextInt();
        Country country[]= setCountryArr(n);

        System.out.println("\nХарактеристики стран:");
        showArray(country);

        int nommax = nomMax(country);
        System.out.println("\nСтрана с максимальной площадью:");
        showCountry(country[nommax]);

        sortSquare(country);
        System.out.println("\nОтсортированный список по площади:");
        showArray(country);

        sortName(country);
        System.out.println("\nОтсортированный список по названиям:");
        showArray(country);

        System.out.println("Средняя площадь>> " + avgSquare(country));


        System.out.println("\nСтраны, с площадью больше средней");
        Country[] larger = avgBig(country);
        if (larger == null){
            System.out.println("Введена одна страна:  ");
            showArray(country);
        }
        else {
            showArray(larger);
        }
        System.out.println("\nfindCountry \n" + "Введите название страны: ");
        sc.nextLine();
        String sname = sc.nextLine();
        Country sfind = findName(country, sname);
        if (sfind!=null) {
            showCountry(sfind);
        } else {
            System.out.println("Такой страны нет в списке!");
        }
    }
}