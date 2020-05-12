package com.finley.basic;

public class Item {
    public int value;
    public Item next;

    public Item(int value,Item next){
        this.value=value;
        this.next=next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Item getNext() {
        return next;
    }

    public void setNext(Item next) {
        this.next = next;
    }


    @Override
    public String toString() {
        return "Item{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
