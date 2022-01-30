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
public class YetkiliKasa extends Kasa {

    void firmaAlVerHesapla() {
        for (Hesap hesap : hesaplar) {
            if (hesap instanceof Firma) {
                Firma f = (Firma) hesap;
                if (f.anlasmaTarihi >= f.anlasmaSinir) {
                    int netAlVer = 0;
                    if (f.borc > f.alacak) {
                        netAlVer = f.borc - f.alacak;
                        System.out.println(f.Unvan + " Firmasının " + netAlVer + " lira NET borcu var.");
                    } else if (f.alacak > f.borc) {
                        netAlVer = f.alacak - f.borc;
                        System.out.println(f.Unvan + " Firmasının " + netAlVer + " lira NET alacağı var.");
                    } else if (f.alacak == f.borc) {
                        System.out.println(f.Unvan + " Firmansının NET bazında herhangi bir borcu ya da alacağı bulunmuyor.");
                    }
                } else {
                    System.out.println("FİRMANIN ANLAŞMASI GÜNCEL OLMADIĞINDAN İŞLEM YAPILAMIYOR.");
                }
            }
        }
    }

    int FborcSil(int silMiktar) {
        for (Hesap hesap : hesaplar) {
            for (Envanter envanter : envanterler) {
                if (hesap instanceof Firma) {
                    Firma f = (Firma) hesap;
                    if (f.anlasmaTarihi >= f.anlasmaSinir) {
                        Envanter ebs = envanter;
                        if (f.borc >= silMiktar) {
                            ebs.netBakiye += silMiktar;
                            f.borc -= silMiktar;
                        } else if (f.borc < silMiktar) {
                            ebs.netBakiye += f.borc;
                            f.borc = 0;
                        }
                    } else {
                        System.out.println("FİRMANIN ANLAŞMASI GÜNCEL OLMADIĞINDAN İŞLEM YAPILAMIYOR.");
                    }
                }
            }
        }
        return silMiktar;
    }

    int FalacakSil(int silMiktar) {
        for (Hesap hesap : hesaplar) {
            for (Envanter envanter : envanterler) {
                if (hesap instanceof Firma) {
                    Firma f = (Firma) hesap;
                    if (f.anlasmaTarihi >= f.anlasmaSinir) {
                        Envanter eas = envanter;
                        if (eas.netBakiye > 0) {
                            if (eas.netBakiye >= f.alacak) {
                                if (f.alacak >= silMiktar) {
                                    eas.netBakiye -= silMiktar;
                                    f.alacak -= silMiktar;
                                } else if (f.alacak < silMiktar) {
                                    if (eas.netBakiye >= silMiktar) {
                                        eas.netBakiye -= f.alacak;
                                        f.alacak = 0;
                                    } else if (eas.netBakiye < silMiktar) {
                                        eas.netBakiye -= f.alacak;
                                        f.alacak = 0;
                                    }
                                }
                            }
                            if (eas.netBakiye < f.alacak) {
                                if (f.alacak >= silMiktar) {
                                    if (eas.netBakiye >= silMiktar) {
                                        eas.netBakiye -= silMiktar;
                                        f.alacak -= silMiktar;
                                    } else if (eas.netBakiye < silMiktar) {
                                        f.alacak -= eas.netBakiye;
                                        eas.netBakiye = 0;
                                    }
                                }
                                if (f.alacak < silMiktar) {
                                    f.alacak -= eas.netBakiye;
                                    eas.netBakiye = 0;
                                }
                            }
                        }
                    } else {
                        System.out.println("FİRMANIN ANLAŞMASI GÜNCEL OLMADIĞINDAN İŞLEM YAPILAMIYOR");
                    }
                }
            }
        }
        return silMiktar;
    }

    void anlasmaUzat() {
        for (Hesap hesap : hesaplar) {
            if (hesap instanceof Firma) {
                Firma f = (Firma) hesap;
                f.anlasmaTarihi++;
            }
        }
    }

}
