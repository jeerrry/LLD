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
}
