package adt;

public class ArraySet<T> implements SetInterface<T> {
    private final int STARTING_CAPACITY = 100;
    private int length;
    private T[] data;
    
    public ArraySet()
   {
      length = 0;
      data = (T[])(new Object[STARTING_CAPACITY]);
   }
    
    @Override
    public T get(int givenIndex){
        return data[givenIndex-1];
    }
    
    @Override
    public boolean insert(T newEntry){
        if (!(contains(newEntry))){
            if (size() == data.length)expand();
            data[length] = newEntry;
            length++;
            return true;
        }
        else{
            return false;
        }
    }
    
    public T remove(T givenData){
        T result = null;
        int search = -1;
        for (int i=0; i < length && search == -1; i++){
            if (data[i].equals(givenData))
               search = i;
        }
        result = data[search];
        if(search != -1){
            for (int i= search; i < length-1; i++){
                data[i] = data[i+1];
                data[i+1] = null;
            }
            length--;
        }
      return result;
    }
    public T removeAt(int givenPosition){
       T value = data[givenPosition];
       for (int i = givenPosition; i < length-1; i++){
                data[i] = data[i+1];
                data[i+1] = null;
        }
        length--;
       return value;
    }
    
    @Override
    public boolean replace(int givenPosition, T newEntry){
        if(givenPosition < length){
            data[givenPosition] = newEntry;
            return true;
        }
        else return false;
    }
    
    @Override
    public int size(){
        return length;
    }
    
    @Override
    public boolean isEmpty(){
        return length == 0;
    }
    
    @Override
    public boolean contains(T givenData){
        boolean flag = false;

        for (int i=0; i < length && flag == false; i++){
            if (data[i].equals(givenData))flag = true;
        }
        return flag;
    }
    
     private void expand()
   {
      T[] larger = (T[])(new Object[data.length*2]);

      for(int i=0; i < data.length; i++)larger[i] = data[i];

      data = larger;
   }
}
