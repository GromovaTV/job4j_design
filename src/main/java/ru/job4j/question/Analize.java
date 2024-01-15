package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        int deleted = 0;
        Map<Integer, User> map = new HashMap<>();
        for (User user : previous) {
            map.put(user.getId(), user);
        }
        for (User currUser : current) {
            User prevUser = map.remove(currUser.getId());
            if (prevUser == null) {
                added++;
                continue;
            }
            if (!prevUser.equals(currUser)) {
                changed++;
            }
        }
        deleted = map.size();
        Info info = new Info(added, changed, deleted);
        return info;
    }
}