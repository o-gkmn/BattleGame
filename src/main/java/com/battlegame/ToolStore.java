
package com.battlegame;


public class ToolStore extends NormalLoc{
    ToolStore(Player player){
        super(player,"Mağaza");
    }
    
    @Override
    public boolean getLocation(){
        System.out.println("");
        System.out.println("Para : " + player.getMoney());
        System.out.println("1- Silahlar");
        System.out.println("2- Zırhlar");
        System.out.println("3- Çıkış");        
        System.out.println("Seçiminiz : ");
        int selTool = scanner.nextInt();
        int selItemId;
        
        switch(selTool){
            case 1:
                selItemId = weaponMenu();
                buyWeapon(selItemId);
                break;
            case 2:
                selItemId = armorMenu();
                buyArmor(selItemId);
                break;
            case 3:
                break;
            default:
                break;
        }
        return true;
    }

    private int weaponMenu() {
        System.out.println("");
        System.out.println("1- Tabanca /tPara : 25 /tHasar : 2");
        System.out.println("2- Kılıç /tPara : 35 /tHasar : 3");
        System.out.println("1- Tüfek /tPara : 45 /tHasar : 7");
        System.out.println("4- Çıkış");
        System.out.println("Silah seçiniz : ");
        int selWeaponId = scanner.nextInt();
        return selWeaponId;
    }

    private void buyWeapon(int id) {
        int damage = 0;
        int price = 0;
        String wName = null;
        if(id > 0 || id < 4){
            switch(id){
                case 1:
                    damage = 2;
                    wName = "Tabanca";
                    price = 25;
                    break;
                case 2:
                    damage = 3;
                    wName = "Kılıç";
                    price = 35;
                    break;
                case 3:
                    damage = 7;
                    wName = "Tüfek";
                    price = 45;
                    break;
                case 4:
                    System.out.println("Çıkış yapılıyor");
                    break;
                default:
                    System.out.println("Geçersiz işlem");
                    break;
            }
            if(price > 0){
                if(player.getMoney() > price){
                    player.getInventory().setDamage(damage);
                    player.getInventory().setwName(wName);
                    player.setMoney(player.getMoney() - price);
                    System.out.println("");
                    System.out.println("Silah satın aldınız. Önceki hasarınız : " + player.getDamage() + 
                        " Yeni hasarınız : " + player.getTotalDamage());
                    System.out.println("Bakiye : " + player.getMoney());
                }
                else{
                    System.out.println("");
                    System.out.println("Bakiye yetersiz");
            }
                
            }
        }
        else{
            System.out.println("Geçersiz işlem");
        }
    }

    private int armorMenu() {
        System.out.println("");
        System.out.println("1- Hafif Zırh /tPara : 15 /tHasar : 1");
        System.out.println("2- Orta Zırh /tPara : 25 /tHasar : 3");
        System.out.println("3- Ağır Zırh /tPara : 40 /tHasar : 5");
        System.out.println("4- Çıkış");
        System.out.println("Zırh seçiniz : ");
        int selArmorId = scanner.nextInt();
        return selArmorId;        
    }

    private void buyArmor(int id) {
        int avoid = 0;
        int price = 0;
        String aName = null;
        if(id > 0 || id < 4){
            switch(id){
                case 1:
                    avoid = 1;
                    aName = "Hafif Zırh";
                    price = 15;
                    break;
                case 2:
                    avoid = 3;
                    aName = "Orta Zırh";
                    price = 25;
                    break;
                case 3:
                    avoid = 5;
                    aName = "Ağır Zırh";
                    price = 40;
                    break;
                case 4:
                    System.out.println("Çıkış yapılıyor");
                    break;
                default:
                    System.out.println("Geçersiz işlem");
                    break;
            }
            if(price > 0){
                if(player.getMoney() >= price){
                    player.getInventory().setArmor(avoid);
                    player.getInventory().setaName(aName);
                    player.setMoney(player.getMoney() - price);
                    System.out.println("");
                    System.out.println("Zırh satın aldınız. Engellenen hasar : " + player.getInventory().getArmor());
                    System.out.println("Bakiye : " + player.getMoney());
                }
                else{
                    System.out.println("");
                    System.out.println("Bakiye yetersiz");
            }
                
            }
        }
        else{
            System.out.println("Geçersiz işlem");
        }        
    }
}
