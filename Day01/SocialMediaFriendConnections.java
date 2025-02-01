import java.util.ArrayList;

class FriendNode {
    int friendId;
    FriendNode next;

    public FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friendHead;
    UserNode next;

    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendHead = null;
        this.next = null;
    }
}

public class SocialMediaFriendConnections {
    private UserNode userHead;

    // Add a friend connection between two users
    public void addFriendConnection(int userId1, int userId2) {
        UserNode user1 = searchUserById(userId1);
        UserNode user2 = searchUserById(userId2);
        if (user1 != null && user2 != null) {
            addFriend(user1, userId2);
            addFriend(user2, userId1);
        }
    }

    // Helper method to add a friend to a user's friend list
    private void addFriend(UserNode user, int friendId) {
        FriendNode newFriend = new FriendNode(friendId);
        newFriend.next = user.friendHead;
        user.friendHead = newFriend;
    }

    // Remove a friend connection
    public void removeFriendConnection(int userId1, int userId2) {
        UserNode user1 = searchUserById(userId1);
        UserNode user2 = searchUserById(userId2);
        if (user1 != null && user2 != null) {
            removeFriend(user1, userId2);
            removeFriend(user2, userId1);
        }
    }

    // Helper method to remove a friend from a user's friend list
    private void removeFriend(UserNode user, int friendId) {
        if (user.friendHead == null) return;
        if (user.friendHead.friendId == friendId) {
            user.friendHead = user.friendHead.next;
            return;
        }
        FriendNode current = user.friendHead;
        while (current.next != null && current.next.friendId != friendId) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Find mutual friends between two users
    public ArrayList<Integer> findMutualFriends(int userId1, int userId2) {
        ArrayList<Integer> mutualFriends = new ArrayList<>();
        UserNode user1 = searchUserById(userId1);
        UserNode user2 = searchUserById(userId2);
        if (user1 != null && user2 != null) {
            FriendNode f1 = user1.friendHead;
            while (f1 != null) {
                FriendNode f2 = user2.friendHead;
                while (f2 != null) {
                    if (f1.friendId == f2.friendId) {
                        mutualFriends.add(f1.friendId);
                    }
                    f2 = f2.next;
                }
                f1 = f1.next;
            }
        }
        return mutualFriends;
    }

    // Display all friends of a specific user
    public void displayAllFriends(int userId) {
        UserNode user = searchUserById(userId);
        if (user != null) {
            System.out.println("Friends of " + user.name + ":");
            FriendNode current = user.friendHead;
            while (current != null) {
                System.out.print(current.friendId + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    // Search for a user by Name
    public UserNode searchUserByName(String name) {
        UserNode current = userHead;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Search for a user by User ID
    public UserNode searchUserById(int userId) {
        UserNode current = userHead;
        while (current != null) {
            if (current.userId == userId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Count the number of friends for each user
    public void countFriendsForEachUser() {
        UserNode current = userHead;
        while (current != null) {
            int count = 0;
            FriendNode friendCurrent = current.friendHead;
            while (friendCurrent != null) {
                count++;
                friendCurrent = friendCurrent.next;
            }
            System.out.println("User " + current.name + " has " + count + " friends.");
            current = current.next;
        }
    }

    // Add a user to the social media platform
    public void addUser(int userId, String name, int age) {
        UserNode newUser = new UserNode(userId, name, age);
        newUser.next = userHead;
        userHead = newUser;
    }

    public static void main(String[] args) {
        SocialMediaFriendConnections smfc = new SocialMediaFriendConnections();
        
        // Adding users
        smfc.addUser(1, "Alice", 25);
        smfc.addUser(2, "Bob", 30);
        smfc.addUser(3, "Charlie", 35);

        // Adding friend connections
        smfc.addFriendConnection(1, 2);
        smfc.addFriendConnection(1, 3);

        // Display friends
        smfc.displayAllFriends(1);

        // Find mutual friends
        ArrayList<Integer> mutualFriends = smfc.findMutualFriends(1, 2);
        System.out.println("Mutual Friends between User 1 and User 2: " + mutualFriends);

        // Count friends for each user
        smfc.countFriendsForEachUser();

        // Remove a friend connection
        smfc.removeFriendConnection(1, 2);

        // Display friends after removal
        smfc.displayAllFriends(1);
    }
}
