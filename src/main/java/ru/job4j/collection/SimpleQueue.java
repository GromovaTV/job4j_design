package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    int size = 0;
    public T poll() {
        T returned;
        for (int i = 0; i < size; i++) {
            out.push(in.pop());
        }
        returned = out.pop();
        size--;
        for (int i = 0; i < size; i++) {
            in.push(out.pop());
        }
        return returned;
    }
    public void push(T value) {
        in.push(value);
        size++;
    }
}
