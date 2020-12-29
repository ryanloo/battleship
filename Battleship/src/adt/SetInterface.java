package adt;

public interface SetInterface<T>{
    
    public T get(int givenPosition);
    
    public boolean insert(T newEntry);
    
    public T remove(T givenData);
    
    public T removeAt(int givenPosition);
    
    public boolean replace(int givenPosition, T newEntry);
    
    public int size();
    
    public boolean isEmpty();
    
    public boolean contains(T givenData);
}
