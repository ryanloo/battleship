package adt;

public interface ListInterface<T>{
    
    public T get(int givenPosition);
    
    public boolean insert(T newEntry);
    
    public T remove(int givenPosition);
    
    public boolean replace(int givenPosition, T newEntry);
    
    public int size();
    
    public boolean isEmpty();
    
    public void clear();
    
    
}
