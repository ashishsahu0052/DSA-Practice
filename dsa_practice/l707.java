class Node<T>{
    T val;
    Node<T> next;

    Node(T val){
        this.val = val;
    }
}

class MyLinkedList {
    int size;

    Node<Integer> head; //null 

    public MyLinkedList() {
        size = 0; 
    }
    
    public int get(int index) {
        Node<Integer> temp = head;
        if(index < 0 || index >= size ){
            return -1; 
        }
       for(int i  = 0 ; i < index ; i++){
            temp = temp.next;
       }
       return temp.val;
    }
    
    public void addAtHead(int val) {
        Node<Integer> node = new Node<>(val);
        size++;
        if(head == null){
            head = node;
        }
        else{
            node.next = head;
             head = node;

        }
    }
    
    public void addAtTail(int val) {
         Node<Integer> node = new Node<>(val);
         size++;
        if(head == null){
            head = node;
        }
        else{
            Node<Integer> temp = head;
            while(temp.next != null){
            temp = temp.next;
            }
            temp.next = node;

        }
        
    }
    
    public void addAtIndex(int index, int val) {
        // negative fcases
        
        Node<Integer> node = new Node<>(val);
        if(index < 0 || index >size ){
            return ; 
        }
        if(index == 0 ){
            addAtHead(val);
            
            return ; 
        }
        if(index == size){
            addAtTail(val);
            
            return;
        }
        Node<Integer> temp = head;
        for(int i = 0 ; i <index-1; i++){
            temp = temp.next;
        }

        node.next = temp.next;
        temp.next = node;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >=size ){
            return ; 
        }
        if(head == null){
            size--;
            return ;

        }
        if(head.next == null){
            head = null;
            size--;
            return;
        }
        if(index == 0){
            head = head.next;
            size--;
            return;
        }

        Node<Integer> temp = head ;
        for(int i = 0 ; i <index-1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */