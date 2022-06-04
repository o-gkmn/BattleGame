/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.battlegame;

/**
 *
 * @author Özgür
 */
public class SafeHouse extends NormalLoc{
    
    SafeHouse(Player player){
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean getLocation() {
        player.setHealthy(player.getrHealthy());
        System.out.println("İyileştiniz");
        System.out.println("Şu anda Güvenli Ev adlı yerdesiniz.");
        return true;
    }
    
    
}
