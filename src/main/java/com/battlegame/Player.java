
package com.battlegame;

import java.util.Scanner;

class Player {
    private int damage;
    private int healthy;
    private int rHealthy;
    private int money;
    private String name;
    private String cName;
    private Inventory inventory;
    Scanner scanner = new Scanner(System.in);

    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
        
    }
    public void selectCha(){
        switch(chaMenu()){
            case 1:
                initPlayer("Samuray", 5, 21, 15);
                break;
            case 2:
                initPlayer("Okçu", 7, 18, 20);
                break;
            case 3:
                initPlayer("Şövalye", 8, 24, 5);
                break;
            default:

                break;                
        }
        System.out.println("Karakter : " + getcName() + "\t Hasar : " + getDamage()
                + "\t Sağlık : " + getHealthy() + "\t Para : " + getMoney());
    }
    
    public void initPlayer(String cName, int damage, int healthy, int money){
        setcName(cName);
        setDamage(damage);
        setHealthy(healthy);
        setMoney(money);
        setrHealthy(healthy);
    }
    
    public int chaMenu(){
        System.out.println("Lütfen bir karakter seçiniz : ");
        System.out.println("1- Samuray \tHasar : 5\tSağlık : 21\tPara : 15");
        System.out.println("2- Okçu \tHasar : 7\tSağlık : 18\tPara : 20");
        System.out.println("3- Şövalye \tHasar : 8\tSağlık : 24\tPara : 5");
        System.out.println("Karakter seçiminiz : ");
        int chaId = scanner.nextInt();
        
        while(chaId < 1 || chaId > 3){
            System.out.println("Lütfen geçerli bir karakter giriniz");
            chaId = scanner.nextInt();

        }
        return chaId;
    }
    
    public int getTotalDamage(){
        return this.getDamage() + this.getInventory().getDamage();
    }
    
    public int getDamage() {
        return damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public int getrHealthy() {
        return rHealthy;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public String getcName() {
        return cName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public void setrHealthy(int rHealthy) {
        this.rHealthy = rHealthy;
    }
    
    public void setMoney(int money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    
}
