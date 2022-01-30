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
public class Firma extends Hesap {

    String Unvan;
    int anlasmaTarihi;
    int anlasmaSinir;

    public Firma(String Unvan, int borc, int alacak, int anlasmaTarihi, final int anlasmaSinir) {
        this.Unvan = Unvan;
        this.borc = borc;
        this.alacak = alacak;
        this.anlasmaTarihi = anlasmaTarihi;
        this.anlasmaSinir = anlasmaSinir;
    }
}
