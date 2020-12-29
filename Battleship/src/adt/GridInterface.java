package adt;

import entity.Location;

public interface GridInterface<T> {
    
    public boolean insert(Location loc,T newEntry);
    
    public T get(Location loc);
    
    public T remove(Location loc);
    
    public T replace(Location loc,T newEntry);
    
    public int getNumRows();
    
    public int getNumCols();
}
