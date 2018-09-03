package com.example.erzhena.starwars.models;

public class Films {
    private Object next;
    private Object previous;
    private int count;
    private FilmsResults[] results;

    public Object getNext() {
        return this.next;
    }

    public void setNext(Object next) {
        this.next = next;
    }

    public Object getPrevious() {
        return this.previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public FilmsResults[] getResults() {
        return this.results;
    }

    public void setResults(FilmsResults[] results) {
        this.results = results;
    }
}
