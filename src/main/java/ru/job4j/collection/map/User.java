package ru.job4j.collection.map;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public int getChildren() {
        return children;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    @SuppressWarnings("CheckStyle")
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        User o = (User) obj;
        return name == o.getName()
                && children == o.getChildren()
                && birthday == o.getBirthday();
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", children=" + children
                + ", birthday=" + birthday
                + '}';
    }

    public static void main(String[] args) {
        Calendar birthday = new GregorianCalendar(1990, 2, 20, 20, 20, 0);
        User user1 = new User("Ivan", 2, birthday);
        User user2 = new User("Ivan", 2, birthday);
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        for (Map.Entry<User, Object> user: map.entrySet()) {
            System.out.println(user.getKey().hashCode());
        }
    }
}
