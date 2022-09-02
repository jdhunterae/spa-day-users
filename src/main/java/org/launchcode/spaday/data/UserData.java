package org.launchcode.spaday.data;

import org.launchcode.spaday.models.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;

public class UserData {
    private static HashMap<Integer, User> users;

    private static HashMap<Integer, User> sampleUsers() {
        HashMap<Integer, User> map = new HashMap<Integer, User>();
        User sample1 = new User(0, "john314", "john@domain.com", "ilovecake", new Date());
        User sample2 = new User(1, "kittensinmittens", "katy@domain.com", "ilovecake", new Date());
        User sample3 = new User(2, "fydor", "fydor@domain.com", "kittensaremid", new Date());

        map.put(sample1.getId(), sample1);
        map.put(sample2.getId(), sample2);
        map.put(sample3.getId(), sample3);

        return map;
    }

    public static User getById(int id) {
        init();

        return users.get(id);
    }

    public static ArrayList<User> getAll() {
        init();

        ArrayList<User> userList = new ArrayList<>(users.values());
        userList.sort(Comparator.comparing(User::getUsername));

        return userList;
    }

    public static void addUser(User user) {
        init();

        users.put(user.getId(), user);
    }

    private static void init() {
        if (users == null) {
            users = new HashMap<>();
        }

        if (users.isEmpty()) {
            users = sampleUsers();
        }
    }

}
