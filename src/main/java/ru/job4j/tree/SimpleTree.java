package ru.job4j.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

public class SimpleTree<E> implements Tree<E> {

    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        if (findBy(parent).isPresent()) {
            Node<E> head = findBy(parent).get();
            if (findBy(child).isEmpty()) {
                head.children.add(new Node<>(child));
                return true;
            }
        }
        return false;
    }

    public boolean isBinary() {
        if (findByPredicate(s -> s.children.size() > 2).isPresent()) {
            return false;
        }
        return true;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        return findByPredicate(s -> s.value.equals(value));
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}