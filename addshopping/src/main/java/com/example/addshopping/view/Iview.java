package com.example.addshopping.view;

public interface Iview<E> {
    void requestData(E e);
    void requestFail(E e);
}
