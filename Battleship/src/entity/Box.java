package entity;

public class Box {
    
    private boolean isBomb;
    private boolean isShip;

    public Box(boolean isBomb, boolean isShip) {
        this.isBomb = isBomb;
        this.isShip = isShip;
    }

    public Box() {
        this.isBomb = false;
        this.isShip = false;
    }

    public void setBomb() {
        this.isBomb = true;
    }

    public void setShip() {
        this.isShip = true;
    }

    public boolean hasBombed() {
        return isBomb;
    }
    
    public boolean hasHit() {
        return (isBomb && isShip);
    }
    
    public boolean hasShip() {
        return isShip;
    }
    
    
}
