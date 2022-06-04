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
public abstract class BattleLoc extends Location{
    
    protected Obstacle obstacle;
    protected String award;
    
    public BattleLoc(Player player, String name, Obstacle obstacle, String award) {
        super(player);
        this.obstacle = obstacle;
        this.name = name;
        this.award = award;
    }

    @Override
    public boolean getLocation(){
        int obsCount = obstacle.count();
        System.out.println("");
        System.out.println("Şuan " + this.getName() + " adlı yerdesiniz");
        System.out.println("Dİkkatli olun burada " + obsCount + " tane " + obstacle.getName() + " var!!");
        System.out.println("<S>avaş veya <K>aç");
        String selCase = scanner.nextLine();
        selCase = selCase.toUpperCase();
        if(selCase.equals("S")){
            if(combat(obsCount)){
                System.out.println(this.getName() + " bölgesindeki tüm düşmaları temizlediniz");
                if(this.award.equals("Food") && player.getInventory().isFood() == false){
                    System.out.println(this.award + " kazandınız");
                    player.getInventory().setFood(true);
                }
                if(this.award.equals("Water") && player.getInventory().isWater()== false){
                    System.out.println(this.award + " kazandınız");
                    player.getInventory().setWater(true);
                }
                if(this.award.equals("Firewood") && player.getInventory().isFirewood()== false){
                    System.out.println(this.award + " kazandınız");
                    player.getInventory().setFirewood(true);
                }                
                return true;
            }   
            if(player.getHealthy() <= 0){
                System.out.println("Öldünüz");
                return false;   
            }
            
        }
        return true;
    }
    
    public boolean combat(int obsCount){
        for(int i = 0; i<obsCount; i++){
            int defObsHealth = obstacle.getHealth();
            playerStats();
            enemytats();
            while(player.getHealthy() > 0 && obstacle.getHealth() > 0){
                System.out.println("<V>ur ya da <K>aç");
                String selCase = scanner.nextLine();
                selCase = selCase.toUpperCase();
                if(selCase.equals("V")){
                    System.out.println("Siz vurdunuz !");
                    obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
                    afterHit();
                    if(obstacle.getHealth() >= 0){
                        System.out.println("");
                        System.out.println("Canavar size vurdu");
                        player.setHealthy(player.getHealthy() - (obstacle.getDamage() - player.getInventory().getArmor()));
                        afterHit();                        
                    }
                }
                else{
                    return false;
                }
            }
            if(obstacle.getHealth() < player.getHealthy()){
                System.out.println("Düşmanı yendiniz");
                player.setMoney(player.getMoney() + obstacle.getAward());
                System.out.println("Güncel paranız : " + player.getMoney());
                obstacle.setHealth(defObsHealth);
            }
            else{
                return false;
            }
        }
        return true;
    }

    public void playerStats() {
        System.out.println("");
        System.out.println("Oyuncu değerleri \n------------");
        System.out.println("Can : " + player.getHealthy());
        System.out.println("Hasar : " + player.getTotalDamage());
        System.out.println("Para : " + player.getMoney());
        if(player.getInventory().getDamage() > 0){
            System.out.println("Silah : " + player.getInventory().getwName());  
        }
        if(player.getInventory().getArmor()> 0){
            System.out.println("Zırh : " + player.getInventory().getaName());  
        }
    }

    public void enemytats() {
        System.out.println("");
        System.out.println(obstacle.getName() + " değerleri \n------------");
        System.out.println("Can : " + obstacle.getHealth());
        System.out.println("Hasar : " + obstacle.getDamage());
        System.out.println("Ödül : " + obstacle.getAward());
    }

    private void afterHit() {
        System.out.println("Oyuncu canı : " + player.getHealthy());
        System.out.println(obstacle.getName() + " canı : " + obstacle.getHealth());
        System.out.println("");
    }
    
}
