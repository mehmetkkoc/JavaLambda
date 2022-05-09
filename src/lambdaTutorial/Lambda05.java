package lambdaTutorial;

import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {

        System.out.println("TASK 01 --> Structured topla " + toplaAmele(10));
        System.out.println("****");
        System.out.println("TASK 01 --> Lambda topla " + toplaCincix(10));
        System.out.println("****");
        System.out.println("TASK 02 -->" + ciftTopla(20));
        System.out.println("****");
        System.out.println("TASK 03 -->" + ilkCiftTopla(10));
        System.out.println("****");
        System.out.println("TASK 04 -->" + ilkTekTopla(10));
        System.out.println("****");
        System.out.print("TASK 05 -->");
        ilkXKuvvetYazdir(10);
        System.out.println("****");
        System.out.print("TASK 06 -->");
        sayiXKuvvetYazdir(3,4);
        System.out.println("****");
        System.out.println("TASK 07 -->"+faktoriyel(5));
        System.out.println("****");
        System.out.println("TASK 08 -->"+sayiXKuvvet(3,5));
        System.out.println("****");


    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program create ediniz.

    //Structured(AMELE) Programming
    public static int toplaAmele(int x) {
        int toplam = 0;
        for (int i = 0; i <= x; i++) {
            toplam += i;

        }
        return toplam;
    }

    //Functional(cincix Programming

    public static int toplaCincix(int x) {

        return IntStream.
                range(1, x + 1). // 1 den x e kadar(x dahil) int degerler akisa eklendi
                        sum(); // akisdaki int degerler toplandi
    }


    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.

    public static int ciftTopla(int x) {

        return IntStream.
                rangeClosed(1, x). // rangeClosed(1,x) methodunda son veri dahil olur
                        filter(Lambda01::ciftBul). // cift bulma methodu call edildi
                        sum(); // toplama yapildi
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.

    public static int ilkCiftTopla(int x) {
        return IntStream.
                iterate(2, t -> t + 2). // 2 den sonsuza kadar elemanlari 2 artirarak akisa alir
                        limit(x). // akistaki ilk x tane int degerini akisa alir
                        sum();
    }


    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int ilkTekTopla(int x) {
        return IntStream.
                iterate(1, t -> t + 2). // 1 den sonsuza kadar elemanlari 2 artirarak akisa alir
                        limit(x). // akistaki ilk x tane int degerini akisa alir
                        sum();
    }


    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ilkXKuvvetYazdir(int x) {
        IntStream.
                iterate(2, t -> t * 2).
                limit(x).
                forEach(Lambda01::yazdir);

    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void sayiXKuvvetYazdir(int y, int x) {
      IntStream.
                iterate(y,t->t*y).limit(x).forEach(Lambda01::yazdir);

    }



    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    public static OptionalInt faktoriyel(int x) {
        return IntStream.
                rangeClosed(1,x).
                reduce(Math::multiplyExact);

    }


    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.
    public static int sayiXKuvvet(int y, int x) {
        return IntStream.
                iterate(y,t->t*y).
                limit(x).
                skip(x-1).
                reduce(0,(t,u)->u);

    }

}
