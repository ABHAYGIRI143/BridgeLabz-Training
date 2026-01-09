
class FriendNode {
    int friendId;
    FriendNode next;

    FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}


class User {
    int userId;
    String name;
    int age;

    FriendNode friendList;   // Head of friend list
    User next;              // Next user in main list

    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendList = null;
        this.next = null;
    }
}


class SocialMedia {

    private User head = null;

    // Add new user
    void addUser(int id, String name, int age) {
        User newUser = new User(id, name, age);
        newUser.next = head;
        head = newUser;
    }

    // Find user by ID
    private User findUser(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == id)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // Add friend connection
    void addFriend(int id1, int id2) {
        User u1 = findUser(id1);
        User u2 = findUser(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found");
            return;
        }

        u1.friendList = addToFriendList(u1.friendList, id2);
        u2.friendList = addToFriendList(u2.friendList, id1);

        System.out.println("Friend connection added");
    }

    // Add to friend list
    private FriendNode addToFriendList(FriendNode head, int id) {
        FriendNode newNode = new FriendNode(id);
        newNode.next = head;
        return newNode;
    }

    // Remove friend connection
    void removeFriend(int id1, int id2) {
        User u1 = findUser(id1);
        User u2 = findUser(id2);

        if (u1 == null || u2 == null) return;

        u1.friendList = removeFromFriendList(u1.friendList, id2);
        u2.friendList = removeFromFriendList(u2.friendList, id1);

        System.out.println("Friend removed");
    }

    private FriendNode removeFromFriendList(FriendNode head, int id) {
        if (head == null) return null;

        if (head.friendId == id)
            return head.next;

        FriendNode temp = head;
        while (temp.next != null) {
            if (temp.next.friendId == id) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    // Display all friends of a user
    void displayFriends(int id) {
        User u = findUser(id);
        if (u == null) return;

        System.out.print("Friends of " + u.name + ": ");
        FriendNode temp = u.friendList;

        while (temp != null) {
            System.out.print(temp.friendId + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Find mutual friends
    void mutualFriends(int id1, int id2) {
        User u1 = findUser(id1);
        User u2 = findUser(id2);

        if (u1 == null || u2 == null) return;

        System.out.print("Mutual Friends: ");
        FriendNode f1 = u1.friendList;

        while (f1 != null) {
            if (isFriend(u2.friendList, f1.friendId))
                System.out.print(f1.friendId + " ");
            f1 = f1.next;
        }
        System.out.println();
    }

    private boolean isFriend(FriendNode head, int id) {
        while (head != null) {
            if (head.friendId == id) return true;
            head = head.next;
        }
        return false;
    }

    // Search by ID
    void searchById(int id) {
        User u = findUser(id);
        if (u != null)
            System.out.println("User: " + u.name + ", Age: " + u.age);
        else
            System.out.println("User not found");
    }

    // Search by Name
    void searchByName(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("User ID: " + temp.userId + ", Age: " + temp.age);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found");
    }

    // Count friends
    void countFriends(int id) {
        User u = findUser(id);
        if (u == null) return;

        int count = 0;
        FriendNode temp = u.friendList;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Total friends of " + u.name + ": " + count);
    }
}

public class SocialMediaApp {

    public static void main(String[] args) {

        SocialMedia sm = new SocialMedia();

        sm.addUser(1, "Abhay", 22);
        sm.addUser(2, "Manas", 23);
        sm.addUser(3, "Divyansh", 21);
        sm.addUser(4, "Kapil", 24);

        sm.addFriend(1, 2);
        sm.addFriend(1, 3);
        sm.addFriend(2, 3);
        sm.addFriend(3, 4);

        sm.displayFriends(1);
        sm.displayFriends(3);

        sm.mutualFriends(1, 2);

        sm.searchByName("Kapil");
        sm.countFriends(3);

        sm.removeFriend(1, 3);
        sm.displayFriends(1);
    }
}
