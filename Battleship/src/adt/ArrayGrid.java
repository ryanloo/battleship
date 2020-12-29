package adt;

import entity.Location;

public class ArrayGrid<T> implements GridInterface<T>{
    private int rowNum;
    private int colNum;
    private T[][] data;
    
    public ArrayGrid(int numOfRow,int numOfCol){
        rowNum = numOfRow;
        colNum = numOfCol;
        data = (T[][])(new Object[rowNum][colNum]);
    }
    
    @Override
    public boolean insert(Location loc,T newEntry){
        int r = loc.getRow();
        int c = loc.getCol();
        if ((r >= 0 & r < rowNum) & (c >= 0 & c < colNum) & data[r][c] == null){
            data[r][c] = newEntry;
            return true;
        }
        else{
            return false;
        }
        
    }
    
    @Override
    public T get(Location loc){
        int r = loc.getRow();
        int c = loc.getCol();
        T result = null;
        if ((r >= 0 & r < rowNum) & (c >= 0 & c < colNum)){
            result = data[r][c];
        }
        return result;
    }
    
    @Override
    public T remove(Location loc){
        int r = loc.getRow();
        int c = loc.getCol();
        T result = null;
        if ((r > 0 & r < rowNum) & (c > 0 & c < colNum)){
            result = data[r][c];
            data[r][c] = null;
        }
        return result;
    }
    
    @Override
    public T replace(Location loc,T newEntry){
        int r = loc.getRow();
        int c = loc.getCol();
        T result = null;
        if ((r > 0 & r < rowNum) & (c > 0 & c < colNum)){
            result = data[r][c];
            data[r][c] = newEntry;
        }
        return result;
    }
    
    @Override
    public int getNumRows(){
        return rowNum;
    }
    
    @Override
    public int getNumCols(){
        return colNum;
    }
}
