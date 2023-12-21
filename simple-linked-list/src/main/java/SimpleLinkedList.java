class SimpleLinkedList<T> {
    Node<T> head;
    Node<T> end;
    int size;
    SimpleLinkedList() {
        this.head = null;
        this.end = null;
    }

    SimpleLinkedList(T[] values) {
        for(T item:values){
            this.push(item);
        }
    }

    void push(T value) {
        Node<T> newNode = new Node<T>(value);
        if(head==null){
            head = newNode;
            end = newNode;
        }
        else{
            newNode.prev = end;
            end.next = newNode;
            end=newNode;
        }
        size++;
    }

    T pop() {
        if(end!=null){
            Node<T> popped = end;
            end = end.prev;
            if(end==null){
                head = null;
            }
            size--;
            return popped.value;
        }
        return null;
    }

    void reverse() {
        if(head==null){
            return;
        }
        Node<T> pointer = head;
        while(true){
            Node<T> temp = pointer.next;
            pointer.next=pointer.prev;
            pointer.prev=temp;
            pointer=temp;
            if(pointer==null){
                break;
            }
        }
    }

    T[] asArray(Class<T> clazz) {
        Node<T> pointer = head;
        T[] array = (T[]) new Object[this.size];
        int index = 0;
        while(true){
            if(pointer==null){
                break;
            }
            array[index]=pointer.value;
            pointer=pointer.next;
            index++;
        }
        return array;
    }

    int size() {
        return this.size;
    }
}

class Node<T>{
    T value;
    public Node<T> next;
    public Node<T> prev;
    public Node(T value){
        this.value = value;
        this.next = null;
        this.prev = null;
    }

}