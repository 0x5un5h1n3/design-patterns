//package FlyweightPattern;
//
////A common interface for all players
//import java.util.HashMap;
//import java.util.Random;
//
//interface Player {
//
//    public void assignWeapon(String weapon);
//
//    public void mission();
//}
//
////Gurilla must have weapon and mission
//class Guerilla implements Player {
//
//    //Intrinsic Attribute
//    private final String TASK;
//    //Extrinsic Attribute
//    private String weapon;
//
//    public Guerilla() {
//        TASK = "Shoot To Soldier";
//    }
//
//    @Override
//    public void assignWeapon(String weapon) {
//        //Assign a weapon
//        this.weapon = weapon;
//    }
//
//    @Override
//    public void mission() {
//        //work on the mission
//        System.out.println("Guerilla with weapon " + weapon + " | " + "task is " + TASK);
//    }
//}
////Soldier must have weapon and mission
//
//class Soldier implements Player {
//
//    //Intrinsic Attribute
//    private final String TASK;
//    //Extrinisic String weapon;
//    private String weapon;
//
//    public Soldier() {
//        TASK = "Shoot to Guerilla";
//    }
//
//    @Override
//    public void assignWeapon(String weapon) {
//        this.weapon = weapon;
//    }
//
//    @Override
//    public void mission() {
//        System.out.println("Soldier with weapon " + weapon + " | " + "task is " + TASK);
//    }
//}
//
//class PlayerFactory {
//
//    /*HashMap stores the reference to the object of Guerilla (TS) or Soldier (CT)
//     */
//    private static HashMap<String, Player> hm = new HashMap<String, Player>();
//
//    //Method ro get a player
//    public static Player getPlayer(String type) {
//        Player p = null;
//        /*If an object for Guerilla or Soldier has already been created simply return its reference
//         */
//
//        if (hm.containsKey(type)) {
//            p = hm.get(type);
//        } else {
//            // creates an object of Guerilla/Soldier
//            switch (type) {
//                case "Guerilla":
//                    System.out.println("Guerilla Created");
//                    p = new Guerilla();
//                    break;
//
//                case "Soldier":
//                    System.out.println("Soldier Created");
//                    p = new Soldier();
//                    break;
//
//                default:
//                    System.out.println("Unreachable code!");
//            }
//            //Code created insert it into the HashMap
//            hm.put(type, p);
//        }
//        return p;
//    }
//}
//
//// Driver class
//class BattleField {
//    //All payer types and weapons (used by getRandPlayerType() and getRandWeapon())
//
//    private static String[] playerType = {"Guerilla", "Soldier"};
//    private static String[] weapons = {"308_SniperRifle", "M16", "M1921", "QBZ-95", "RPG"};
//
////Driver Code
//    public static void main(String[] args) {
//        //Assume that we have a total of 10 players in the game
//        for (int i = 0; i < 10; i++) {
//            //getPlayer() is called simply using the class name since the method is a static one
//
//            Player p = PlayerFactory.getPlayer(getRandPlayerType());
//
//            //Assign a weapon chosen randomly uniformly from the weapon array
//            p.assignWeapon(getRandWeapon());
//
//            //Send this player on a mission
//            p.mission();
//        }
//    }
//    //Utility methods to get a random player type and weapon
//
//    public static String getRandPlayerType() {
//        Random r = new Random();
//
//        //Will return an integer between(0, 2)
//        int randInt = r.nextInt(playerType.length);
//        System.out.println("@@@@@" + randInt);
//
//        //return the player stored at index 'randInt'
//        return playerType[randInt];
//    }
//
//    public static String getRandWeapon() {
//        Random r = new Random();
//        int randInt = r.nextInt(weapons.length);
//        System.out.println("@@@@@" + randInt);
//        //Return the weapon stored at index 'randInt'
//        return weapons[randInt];
//    }
//
//}
