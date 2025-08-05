package com.example.DesignPatterns;

import java.util.ArrayList;
import java.util.List;

// 🧱 Các lớp chính:
// User: Các đối tượng cần giao tiếp.
// ChatMediator: Interface mediator.
// ChatRoom: Concrete mediator điều phối message giữa các User.

// Mediator interface
interface ChatMediator {
    void sendMessage(String msg, User user);
    void addUser(User user);
}
// Concrete Mediator
class ChatRoom implements ChatMediator {
    private final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void sendMessage(String msg, User sender) {
        for (User u : users) {
            if (u != sender) {
                u.receive(msg);
            }
        }
    }
}
// Colleague (User)
abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator m, String name) {
        this.mediator = m;
        this.name = name;
    }

    public abstract void send(String msg);
    public abstract void receive(String msg);
}
// Concrete Colleague
class ChatUser extends User {
    public ChatUser(ChatMediator m, String name) {
        super(m, name);
    }

    public void send(String msg) {
        System.out.println(this.name + " sends: " + msg);
        mediator.sendMessage(msg, this);
    }

    public void receive(String msg) {
        System.out.println(this.name + " receives: " + msg);
    }
}
public class Mediator {
    public static void main(String[] args) {
        ChatMediator chat = new ChatRoom();

        User alice = new ChatUser(chat, "Alice");
        User bob = new ChatUser(chat, "Bob");
        User charlie = new ChatUser(chat, "Charlie");

        chat.addUser(alice);
        chat.addUser(bob);
        chat.addUser(charlie);

        alice.send("Hi everyone!");
        bob.send("Hello Alice!");
    }
}
