package entity;

import adt.ArraySet;

public class Player {
    public ArraySet<Ship> ship = new ArraySet<>();
    public Board playerBoard;
    public String name;
    public shipCounter shipCount;

    public Player(String name) {
        this.name = name;
        for(int i = 1; i <= 5;i++){
            Ship temp = new Ship(i);
            ship.insert(temp);
        }
        playerBoard = new Board();
    }
    
    public int shipsLeft(){
        shipCount = new shipCounter();
        for(int i = 1; i <= 5;i++){
            Ship tempShip = ship.get(i);
            int ch = tempShip.getColHead();
            int rh = tempShip.getRowHead();
            int ct = tempShip.getColTail();
            int rt = tempShip.getRowTail();
            int len = tempShip.getLength();
            int chc = 0;
            for (int r = rt;r <= rh;r++){
                for (int c = ct;c <= ch;c++){
                    if (playerBoard.hasHit(r, c))chc++;
                }
            }   
            if (chc == len) shipCount.decrement();
            chc = 0;
        }
        return shipCount.getCount();
    }
    
    public void setName(String inp){
        name = inp;
    }
    
    public String getName(){
        return name;
    }
    
    public Board getBoard(){
        return playerBoard;
    }
}
    