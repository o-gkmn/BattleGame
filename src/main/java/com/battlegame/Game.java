
package com.battlegame;

import java.util.Scanner;


public class Game {
    Player player;
    Location location;
    Scanner scanner = new Scanner(System.in);
    
    public void login(){
        System.out.println("Macera Oyununa Hoş Geldiniz");
        System.out.println("Oyuna başlamadan önce isminizi giriniz : ");
        String playerName = scanner.nextLine();
        player = new Player(playerName);
        player.selectCha();
        start();
    }
    
    public void start(){
        while(true){
            System.out.println("");
            System.out.println("===============================");
            System.out.println("");
            System.out.println("Eylem gerçekleştirmek için bir yer seçiniz");
            System.out.println("1- Güvenli ev : Güvenli bir şekilde kendinizi iyileştirebilirsiniz.");
            System.out.println("2- Mağara : Karşınıza zombi çıkabilir! Arkanızı kollayın!");
            System.out.println("3- Orman : Karşınıza vampir çıkabilir! Arkanızı kollayın!");
            System.out.println("4- Nehir : Karşınıza ayı çıkabilir! Arkanızı kollayın!");
            System.out.println("5- Mağaza : Silah ve cephane satın alabilirsiniz.");
            System.out.println("6- Kontrol Merkezi : Oyunu kazanıp kazanmadığınızı kontrol edebilirsiziniz");
            System.out.println("Seçiminiz : ");
            int selLoc = scanner.nextInt();

            while(selLoc > 6 || selLoc < 1){
                System.out.println("Lütfen geçerli bir sayı giriniz");
                selLoc = scanner.nextInt();
            }

            switch(selLoc){
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Cave(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4: 
                    location = new River(player);
                    break;
                case 5:
                    location = new ToolStore(player);
                    break;
                case 6:
                    if(player.getInventory().isFirewood() && player.getInventory().isFood() && player.getInventory().isWater()){
                        System.out.println("Tebrikler oyunu kazandınız");
                        System.exit(0);
                    }
                    break;
                default:
                    location = new SafeHouse(player);
                    break;
            }
            if(!location.getLocation()){
                System.out.println("Oyun bitti");
                break;
            }
        }
    }
}
