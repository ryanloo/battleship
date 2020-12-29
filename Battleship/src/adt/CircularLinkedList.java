package adt;

public class CircularLinkedList<T> implements ListInterface<T>{
    private Node head = null;
    private Node tail = null;
    private int currNodePos = 1;
    private int length;
    
    public CircularLinkedList(){
        clear();
    }
    
    @Override
    public T get(int givenPosition){
        T result = null;

        if ((givenPosition >= 1)) {
            Node currentNode = head;
            for (int i = 0; i < givenPosition - 1; ++i) {
                currentNode = currentNode.nextNode;	
            }
            result = currentNode.data;
        }

        return result;
    }
    
    public T getCurr(){
        return get(currNodePos);
    }
    
    public void nextNode(){
        currNodePos++;
    }
     
    @Override
    public boolean insert(T newEntry){
        Node newNode = new Node(newEntry);
 
        if (isEmpty()) {
            head = newNode;
        } 
        else {
            tail.nextNode = newNode;
        }
 
        tail = newNode;
        tail.nextNode = head;
        length++;
        return true;
    }
    
    @Override
    public T remove(int givenPosition){
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= length)) {
            if (givenPosition == 1) {
                result = head.data;
                head = head.nextNode;
            }
            else if (givenPosition == length){
                result = tail.data;
                Node currentNode = head;
                for (int i = 0; i < givenPosition - 1; ++i) {
                    currentNode = currentNode.nextNode;	
                }
                tail = currentNode;
            }
            else {                    
                Node nodeBefore = head;
                for (int i = 1; i < givenPosition - 1; ++i) {
                nodeBefore = nodeBefore.nextNode;	
            }
            result = nodeBefore.nextNode.data;
            nodeBefore.nextNode = nodeBefore.nextNode.nextNode;
        } 																// one to be deleted (to disconnect node from chain)
        length--;
    }

    return result;
    }
    
    @Override
    public boolean replace(int givenPosition, T newEntry){
         boolean isSuccessful = true;

        if ((givenPosition >= 1) && (givenPosition <= length)) {
            Node currentNode = head;
            for (int i = 0; i < givenPosition - 1; ++i) {
                currentNode = currentNode.nextNode;
            }
            currentNode.data = newEntry;
        } 
        else {
            isSuccessful = false;
        }
    return isSuccessful;
    }
    
    @Override
    public int size(){
        return length;
    }
    
    @Override
    public boolean isEmpty(){
        if (head == null){
            return true;
        }
        else{
            return false;
        }
    }
    
    public Node getHead(){
        return head;
    }
    
    @Override
    public final void clear(){
        head = null;
        tail = null;
        int currNode = 1;
        length = 0;
    }
    
    
    private class Node {
        private T data;
        private Node nextNode;

        private Node(T data) {
            this.data = data;
        }
    }
}
