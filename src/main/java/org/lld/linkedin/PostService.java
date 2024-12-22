package org.lld.linkedin;

import java.util.ArrayList;
import java.util.List;

public class PostService {
    public static PostService instance;

    public static PostService getInstance() {
        if (instance == null) {
            instance = new PostService();
        }

        return instance;
    }

    private PostService() {
    }

    private List<Post> posts = new ArrayList<Post>();

    public void addPost(Post post) {
        posts.add(post);
    }

    public boolean removePost(int id) {
        Post post = posts.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        if (post == null) {
            System.out.println("Invalid post ID " + id + " provided for deletion");
            return false;
        }

        posts.remove(post);
        return true;
    }
}
