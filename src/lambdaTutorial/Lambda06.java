package lambdaTutorial;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda06 {
    public static void main(String[] args) throws IOException {
        //TASK 01 --> haluk.txt dosyasini okuyunuz.(Console'a yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini okuyunuz -->  ");

        Files.lines(Paths.get("src/lambdaTutorial/haluk.txt")).

                    // Files class dan lines() methd call edilerek
                    // data cekilecek dosya yolu(path) parametre girilerek
                    // path deki dosyanin datalari akisa alindi
                            forEach(System.out::println);  // akistaki datalar(her satirdaki String) yazildi

        //TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini buyuk harflerle okuyunuz -->  ");


        Files.lines(Paths.get("src/lambdaTutorial/haluk.txt")).map(String::toUpperCase).forEach(System.out::println);

        //TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz 01 -->  ");
        Files.lines(Paths.get("src/lambdaTutorial/haluk.txt")).map(String::toLowerCase).limit(1).forEach(System.out::println);

        //TASK 04 --> haluk.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");
        long adet=Files.lines(Paths.get("src/lambdaTutorial/haluk.txt")).
                filter(t->t.toUpperCase().contains("BASARI")).count();
        System.out.println(adet+" adet satirda basari kelimesi gecmektedir");

        //TASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");
        List<String> list2=new ArrayList<>();
        list2=Files.lines(Paths.get("src/lambdaTutorial/haluk.txt")).
                map(t->t.split(" ")).
                flatMap(Arrays::stream).collect(Collectors.toList());
        list2.stream().distinct().forEach(System.out::println);




        //TASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");
        Files.lines(Paths.get("src/lambdaTutorial/haluk.txt")).
                map(t->t.split(" ")).
                flatMap(Arrays::stream).sorted().forEach(System.out::println);

        //TASK 07 --> haluk.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bagımsız yaziniz.
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");
        int sayi= (int) list2.stream().filter(t->t.toLowerCase().equalsIgnoreCase("basari")).count();
        System.out.println(sayi+" adet basari kelimesi var");

        //TASK 08 --> haluk.txt dosyasinda "a" harfi gecen kelimelerin sayisini ekrana yazdiran programi yaziniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");
        sayi= (int) list2.stream().filter(t->t.toLowerCase().contains("a")).count();
        System.out.println("a harfi gecen kelime sayisi : "+sayi);
        //TASK 09 --> haluk.txt dosyasinda icinde "a" harfi gecen kelimeleri yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");
        list2.stream().filter(t->t.toLowerCase().contains("a")).forEach(t -> System.out.print(t + " "));

        //TASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini yazdiriniz
        System.out.println("\n\n*** haluk.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. -->  ");

        sayi= (int) list2.stream().map(t->t.split("")).
                flatMap(Arrays::stream).distinct().count();

        System.out.println(sayi);

        //TASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
        sayi= (int) list2.stream().map(String::toUpperCase).distinct().count();

        System.out.println(sayi);
    }
}
