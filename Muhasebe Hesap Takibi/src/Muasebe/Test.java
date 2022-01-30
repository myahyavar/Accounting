/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Muasebe;

/**
 *
 * @author Yahya
 */
public class Test {

    public static void main(String[] args) {
        Kasa k = new Kasa();
        k.envanterEkle(new Envanter(5000));
        k.hesapEkle(new Musteri("Yahya", "Avar", 600, 500));
        k.musteriAlVerHesapla();
        k.MborcSil(600);
        k.MalacakSil(500);
        k.musteriAlVerHesapla();
        k.bakiyeGoster();
        System.out.println("-------------------------------------");

        YetkiliKasa yk = new YetkiliKasa();
        yk.envanterEkle(new Envanter(5000));
        yk.hesapEkle(new Firma("Fatih Bilgisayar", 500, 600, 2019, 2020));
        yk.firmaAlVerHesapla();
        yk.anlasmaUzat();
        yk.FborcSil(500);
        yk.firmaAlVerHesapla();
        yk.bakiyeGoster();
        System.out.println("-------------------------------------");

        yk.hesapEkle(new Musteri("Ahmet", "Kaska", 700, 800));
        yk.musteriAlVerHesapla();
        yk.MalacakSil(100);
        yk.bakiyeGoster();
        System.out.println("-------------------------------------");

        YetkiliKasa yk2 = new YetkiliKasa();
        yk2.envanterEkle(new Envanter(2000));
        yk2.hesapEkle(new Firma("Kozahan Kitabevi", 0, 200, 2030, 2020));
        yk2.firmaAlVerHesapla();
        yk2.FalacakSil(800);
        yk2.firmaAlVerHesapla();
        yk2.bakiyeGoster();
        System.out.println("-------------------------------------");

        Kasa k2 = new Kasa();
        k2.envanterEkle(new Envanter(200));
        k2.hesapEkle(new Musteri("Emir", "Çelik", 0, 800));
        k2.musteriAlVerHesapla();
        k2.MalacakSil(800);
        k2.musteriAlVerHesapla();
        k2.bakiyeGoster();

    }
}
