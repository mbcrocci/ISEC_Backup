package com.company.Ficha3;

public class Ponto<T extends Number, E extends Number>{
    private T x;
    private E y;

    public Ponto(T x, E y) {
        this.x = x;
        this.y = y;
    }

    public T getX() { return this.x; }
    public E getY() { return this.y; }

    @Override
    public String toString() {
        return super.toString();
    }

    public void copy(Ponto <? extends T, ? extends E> p) {
        this.x = p.getX();
        this.y = p.getY();
    }
}