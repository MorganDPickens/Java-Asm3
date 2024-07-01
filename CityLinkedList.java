package HW3Arrays;                                                                                                                    // Morgan Pickens 5/27/2024

import java.util.Iterator;
import java.util.NoSuchElementException;                      // this is our linked list file 


public class CityLinkedList<E extends City> implements CityInterface<E>, Iterable<E> {
    private Node<E> head; // this is for the head
    private int size; // this of course is for size

    // Node class representing each element in the linked list
    private static class Node<E> {
        E data; // we used this for data store dint he node
        Node<E> next; // this is for the following node 

        Node(E data) {
            this.data = data; // we use this to Initialize data
            this.next = null; // and to this is to reference the next 
        }
    }

    
     //constructor for the empty linked list.
     
    public CityLinkedList() {
        this.head = null; // Initialize head to null
        this.size = 0; // Initialize size to 0
    }
                                                        //Below is our override section //
    @Override
    public int getSize() {
        return size; // return the size 
    }

    @Override
    public E get(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position"); // Validate position
        }
        Node<E> current = head; // begin at  head
        for (int i = 0; i < position; i++) {
            current = current.next; // traverse to the position
        }
        return current.data; // return the data at the position
    }

    @Override
    public void add(E value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null"); // Validate value
        }
        Node<E> newNode = new Node<>(value); // create a new node
        if (head == null) {
            head = newNode; // set head to the new node if the list is empty
        } else {
            Node<E> current = head; // start from the head
            while (current.next != null) {
                current = current.next; // traverse to the end of the list
            }
            current.next = newNode; // add the new node at the end
        }
        size++; // Increment the size
    }

    @Override
    public void addFront(E value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null"); // Validate value
        }
        Node<E> newNode = new Node<>(value); // create a new node
        newNode.next = head; // point the new node to the current head
        head = newNode; // Set the head to the new node
        size++; // increment the size
    }

    @Override
    public void addSorted(E value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null"); // Validate value
        }
        Node<E> newNode = new Node<>(value); // Create a new node
        if (head == null || value.compareTo(head.data) < 0) {
            newNode.next = head; 
            head = newNode; // set the head to the new node
        } else {
            Node<E> current = head; // start from the head
            while (current.next != null && value.compareTo(current.next.data) > 0) {
                current = current.next; // find the correct position
            }
            newNode.next = current.next; // point the new node to the next node
            current.next = newNode; // set the current node's next to the new node
        }
        size++; // Increment the size
    }

    @Override
    public int indexOf(E value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null"); // Validate value
        }
        Node<E> current = head; // start from the head
        int index = 0; // initialize index
        while (current != null) {
            if (current.data.equals(value)) {
                return index; // return the index if found
            }
            current = current.next; // traverse to the next node
            index++; // increment index
        }
        return -1; // Return -1 if not found
    }

    @Override
    public boolean remove(E value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null"); // validate value
        }
        if (head == null) {
            return false; // return false if the list is empty
        }
        if (head.data.equals(value)) {
            head = head.next; // remove the head if it matches the value
            size--; // decrement the size
            return true; // return true if removed
        }
        Node<E> current = head; // Start from the head
        while (current.next != null && !current.next.data.equals(value)) {
            current = current.next; // traverse to find the node to remove
        }
        if (current.next == null) {
            return false; // return false if not found
        }
        current.next = current.next.next; // remove the node
        size--; // decrement the size
        return true; // return true if removed
    }

    @Override
    public void remove(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position"); // validate position
        }
        if (position == 0) {
            head = head.next; // remove the head if position is 0
        } else {
            Node<E> current = head; // start from the head
            for (int i = 0; i < position - 1; i++) {
                current = current.next; // traverse to the position
            }
            current.next = current.next.next; // remove the node at the position
        }
        size--; // decrement the size
    }

    @Override
    public boolean isEmpty() {
        return size == 0; // return true if the list is empty
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator(); // return a new iterator
    }

    // Iterator class to iterate over the linked list
    private class MyIterator implements Iterator<E> {
        private Node<E> current = head; // current node

        @Override
        public boolean hasNext() {
            return current != null; // return true if there are more elements
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements"); // throw exception if no more elements
            }
            E data = current.data; // get the data of the current node
            current = current.next; // move to the next node
            return data; // return the data
        }
    }
}

