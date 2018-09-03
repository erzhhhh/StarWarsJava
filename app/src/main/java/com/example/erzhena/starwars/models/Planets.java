package com.example.erzhena.starwars.models;

public class Planets {
    private String next;
    private Object previous;
    private int count;
    private PlanetsResults[] results;

    public String getNext() {
        return this.next;
    }

    public void setNext(String next) {
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

    public PlanetsResults[] getResults() {
        return this.results;
    }

    public void setResults(PlanetsResults[] results) {
        this.results = results;
    }
}
