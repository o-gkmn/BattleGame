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
public class Forest extends BattleLoc {

    public Forest(Player player) {
        super(player, "Orman", new Vampire(), "Firewood");
    }
    
}
