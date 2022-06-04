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
public class Cave extends BattleLoc{

    public Cave(Player player) {
        super(player, "Mağara", new Zombie(), "Food");
    }
    
}
