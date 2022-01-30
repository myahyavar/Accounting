/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Muasebe;

import java.util.ArrayList;

/**
 *
 * @author Yahya
 */
public class Kasa {

    ArrayList<Hesap> hesaplar = new ArrayList();
    ArrayList<Envanter> envanterler = new ArrayList();

    void hesapEkle(Hesap h) {
        hesaplar.add(h);
    }

    void envanterEkle(Envanter e) {
        envanterler.add(e);
    }

    void bakiyeGoster() {
        for (Envanter envanter : envanterler) {
            Envanter ebg = envanter;
            if (ebg.netBakiye > 0) {
                System.out.println("Bakiyede " + ebg.netBakiye + " lira var.");
            } else if (ebg.netBakiye == 0) {
                System.out.println("Bakiyede para bulunmuyor.");
            }
        }
    }

    void musteriAlVerHesapla() {
        for (Hesap hesap : hesaplar) {
            if (hesap instanceof Musteri) {
                Musteri m = (Musteri) hesap;
                int netAlVer = 0;
                if (m.borc > m.alacak) {
                    netAlVer = m.borc - m.alacak;
                    System.out.println(m.ad + " " + m.soyad + " Müşterisinin " + netAlVer + " lira NET borcu var.");
                } else if (m.alacak > m.borc) {
                    netAlVer = m.alacak - m.borc;
                    System.out.println(m.ad + " " + m.soyad + " Müşterisinin " + netAlVer + " lira NET alacağı var.");
                } else if (m.alacak == m.borc) {
                    System.out.println(m.ad + m.soyad + " Müşterisinin NET bazında herhangi bir borcu ya da alacağı bulunmuyor.");
                }
            }
        }
    }

    int MborcSil(int silMiktar) {
        for (Hesap hesap : hesaplar) {
            for (Envanter envanter : envanterler) {
                if (hesap instanceof Musteri) {
                    Hesap h = hesap;
                    Envanter ebs = envanter;
                    if (h.borc >= silMiktar) {
                        ebs.netBakiye += silMiktar;
                        h.borc -= silMiktar;
                    } else if (h.borc < silMiktar) {
                        ebs.netBakiye += h.borc;
                        h.borc = 0;
                    }
                }
            }
        }
        return silMiktar;
    }

    int MalacakSil(int silMiktar) {
        for (Hesap hesap : hesaplar) {
            for (Envanter envanter : envanterler) {
                if (hesap instanceof Musteri) {
                    Hesap h = hesap;
                    Envanter eas = envanter;
                    if (eas.netBakiye > 0) {
                        if (eas.netBakiye >= h.alacak) {
                            if (h.alacak >= silMiktar) {
                                eas.netBakiye -= silMiktar;
                                h.alacak -= silMiktar;
                            } else if (h.alacak < silMiktar) {
                                if (eas.netBakiye >= silMiktar) {
                                    eas.netBakiye -= h.alacak;
                                    h.alacak = 0;
                                } else if (eas.netBakiye < silMiktar) {
                                    eas.netBakiye -= h.alacak;
                                    h.alacak = 0;
                                }
                            }
                        }
                        if (eas.netBakiye < h.alacak) {
                            if (h.alacak >= silMiktar) {
                                if (eas.netBakiye >= silMiktar) {
                                    eas.netBakiye -= silMiktar;
                                    h.alacak -= silMiktar;
                                } else if (eas.netBakiye < silMiktar) {
                                    h.alacak -= eas.netBakiye;
                                    eas.netBakiye = 0;
                                }
                            }
                            if (h.alacak < silMiktar) {
                                h.alacak -= eas.netBakiye;
                                eas.netBakiye = 0;
                            }
                        }
                    }
                }
            }
        }
        return silMiktar;
    }

}
