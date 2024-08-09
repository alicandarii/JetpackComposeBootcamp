package com.example.kotlindersleri.oop

class Odev2 {
    fun soru1(kenarSayisi:Int):Int{
        var icAcilarToplami = 0
        icAcilarToplami = (kenarSayisi -2) * 180
        return icAcilarToplami
    }

    fun soru2(gunSayisi:Int):Int {
        val normalUcret = 10
        val mesaiUcret = 20
        val saat = 8
        val mesaisiz = 160
        var toplamSaat = gunSayisi * saat
        var toplamMaas = 0
        if (gunSayisi<=30){
            if (toplamSaat > mesaisiz) {
                toplamMaas = (mesaisiz * normalUcret) + ((toplamSaat- mesaisiz) * mesaiUcret)
            }else {
                toplamMaas = toplamSaat * normalUcret
            }
        }
        return toplamMaas
    }

    fun soru3(kotaMiktari: Int):Int{
        var tutar =100
        if(kotaMiktari>50){
            for (i in 51..kotaMiktari){
                tutar +=4
            }
        }
        return tutar
    }

    fun soru4(derece:Double):Double{
        var fahrenhiet:Double?
        fahrenhiet = (derece*1.8) + 32
        return fahrenhiet
    }

    fun soru5(kisaKenar:Double,uzunKenar:Double){
        var cevre = (kisaKenar*2) + (uzunKenar*2)
        println("Dikdörtgenin çevresi : $cevre")
    }

    fun soru6(sayi:Int):Long {
        var faktoriyel:Long = 1
        for (i in 1..sayi){
                faktoriyel *= i
        }
        return faktoriyel
    }

    fun soru7(kelime:String){
        var sayac = 0
        for (element in kelime){
            if (element =='a'){
                sayac++
            }
        }
        println("Kelimedeki a harflerinin sayısı : $sayac")
    }


}