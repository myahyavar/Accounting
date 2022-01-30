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
public class Musteri extends Hesap {

    String ad, soyad;

    public Musteri(String ad, String soyad, int borc, int alacak) {
        this.ad = ad;
        this.soyad = soyad;
        this.borc = borc;
        this.alacak = alacak;
    }

}
