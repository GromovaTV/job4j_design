package ru.job4j.ood.isp.menu;

import java.util.*;

public class SimpleMenu implements Menu {
    private final List<MenuItem> rootElements = new ArrayList<>();

    @Override
    public boolean add(String parentName, String childName, ActionDelegate actionDelegate) {
        if (parentName == null) {
            rootElements.add(new SimpleMenuItem(childName, actionDelegate));
            return true;
        }
        Optional<ItemInfo> parent = findItem(parentName);
        if (parent.isPresent()) {
            List<MenuItem> children = parent.get().menuItem.getChildren();
            children.add(new SimpleMenuItem(childName, actionDelegate));
            return true;
        }
        return false;
    }

//    public static void main(String[] args) {
////        SimpleMenuItem item1 = new SimpleMenuItem("item1", () -> System.out.println("act1"));
////        SimpleMenuItem item2 = new SimpleMenuItem("item1", () -> System.out.println("act1"));
//        SimpleMenu menuItem = new SimpleMenu();
//        menuItem.add(null, "item1", () -> System.out.println("act1"));
//        menuItem.add(null, "item2", () -> System.out.println("act2"));
//        menuItem.add("item1", "item3", () -> System.out.println("act3"));
//    }

    @Override
    public Optional<MenuItemInfo> select(String itemName) {
        var item = findItem(itemName);
        if (item.isPresent()) {
            MenuItem menuItem = item.get().menuItem;
            String number = item.get().number;
            return Optional.of(new MenuItemInfo(menuItem, number));
        }
        return Optional.empty();
    }

    @Override
    public Iterator<MenuItemInfo> iterator() {
        return new MenuItemInfoIterator();
    }

    public class MenuItemInfoIterator implements Iterator<MenuItemInfo> {
        private DFSIterator dfsi = new DFSIterator();

        @Override
        public boolean hasNext() {
            return dfsi.hasNext();
        }

        @Override
        public MenuItemInfo next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            ItemInfo next = dfsi.next();
            return new MenuItemInfo(next.menuItem, next.number);
        }
    }

    private Optional<ItemInfo> findItem(String name) {
        Optional<ItemInfo> res = Optional.empty();
        DFSIterator dfsi = new DFSIterator();
        while (dfsi.hasNext()) {
            ItemInfo item = dfsi.next();
            if (item.menuItem.getName().equals(name)) {
                res = Optional.of(item);
            }
        }
        return res;
    }

    private static class SimpleMenuItem implements MenuItem {
        private String name;
        private List<MenuItem> children = new ArrayList<>();
        private ActionDelegate actionDelegate;

        public SimpleMenuItem(String name, ActionDelegate actionDelegate) {
            this.name = name;
            this.actionDelegate = actionDelegate;
        }

        @Override
        public String toString() {
            return "SimpleMenuItem{"
                    + "name='" + name + '\''
                    + ", children=" + children
                    + ", actionDelegate=" + actionDelegate
                    + '}';
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public List<MenuItem> getChildren() {
            return children;
        }

        @Override
        public ActionDelegate getActionDelegate() {
            return actionDelegate;
        }
    }

    private class DFSIterator implements Iterator<ItemInfo> {
        Deque<MenuItem> stack = new LinkedList<>();
        Deque<String> numbers = new LinkedList<>();
        DFSIterator() {
            int number = 1;
            for (MenuItem item : rootElements) {
                stack.addLast(item);
                numbers.addLast(String.valueOf(number++).concat("."));
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public ItemInfo next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            MenuItem current = stack.removeFirst();
            String lastNumber = numbers.removeFirst();
            List<MenuItem> children = current.getChildren();
            int currentNumber = children.size();
            for (var i = children.listIterator(children.size()); i.hasPrevious();) {
                stack.addFirst(i.previous());
                numbers.addFirst(lastNumber.concat(String.valueOf(currentNumber--)).concat("."));
            }
            return new ItemInfo(current, lastNumber);
        }
    }

    private class ItemInfo {
        MenuItem menuItem;
        String number;
        public ItemInfo(MenuItem menuItem, String number) {
            this.menuItem = menuItem;
            this.number = number;
        }
    }

    public class SimpleMenuPrinter implements MenuPrinter {
        @Override
        public void print(Menu menu) {

        }
    }
}