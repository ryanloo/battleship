package entity;

public class Ship {
    
    private int rowHead;
    private int colHead;
    private int rowTail;
    private int colTail;
    private int length;
    private int type;
    private String shipName;

    public Ship(int rowHead, int colHead, int rowTail, int colTail, int type) {
        
        this.rowHead = rowHead;
        this.colHead = colHead;
        this.rowTail = rowTail;
        this.colTail = colTail;
        this.type = type;
        switch(type){
            case 1:
                this.shipName = "Carrier";
                this.length = 5;
                break;
            case 2:
                this.shipName = "Battleship";
                this.length = 4;
                break;
            case 3:
                this.shipName = "Cruiser";
                this.length = 3;
                break;
            case 4:
                this.shipName = "Submarine";
                this.length = 3;
                break;
            case 5:
                this.shipName = "Destroyer";
                this.length = 2;
                break;
        }
        
    }
    
    public Ship(int type) {
        
        this.rowHead = -1;
        this.colHead = -1;
        this.rowTail = -1;
        this.colTail = -1;
        this.type = type;
        switch(type){
            case 1:
                this.shipName = "Carrier";
                this.length = 5;
                break;
            case 2:
                this.shipName = "Battleship";
                this.length = 4;
                break;
            case 3:
                this.shipName = "Cruiser";
                this.length = 3;
                break;
            case 4:
                this.shipName = "Submarine";
                this.length = 3;
                break;
            case 5:
                this.shipName = "Destroyer";
                this.length = 2;
                break;
        }
        
    }

    public int getRowHead() {
        return rowHead;
    }

    public int getColHead() {
        return colHead;
    }

    public int getRowTail() {
        return rowTail;
    }

    public int getColTail() {
        return colTail;
    }

    public int getLength() {
        return length;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipHead(int rowHead,int colHead) {
        this.rowHead = rowHead;
        this.colHead = colHead;
    }

    public void setShipTail(int rowTail,int colTail) {
        this.rowTail = rowTail;
        this.colTail = colTail;
    }

    public void setType(int type) {
        this.type = type;
        switch(type){
            case 1:
                this.shipName = "Carrier";
                this.length = 5;
                break;
            case 2:
                this.shipName = "Battleship";
                this.length = 4;
                break;
            case 3:
                this.shipName = "Cruiser";
                this.length = 3;
                break;
            case 4:
                this.shipName = "Submarine";
                this.length = 3;
                break;
            case 5:
                this.shipName = "Destroyer";
                this.length = 2;
                break;
        }
    }
    
}
