package net.artem.crudapp.controller;

import net.artem.crudapp.enums.PostStatus;
import net.artem.crudapp.model.Label;
import net.artem.crudapp.model.Post;
import net.artem.crudapp.repository.PostRepository;
import net.artem.crudapp.repository.gson.GsonPostRepositoryImpl;

import java.util.Date;
import java.util.List;

public class PostController {
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostController() {
        this.postRepository = new GsonPostRepositoryImpl();
    }

    public Post createPost(Long id, String content, PostStatus postStatus, List<Label> labels,
                           Date created, Date updated) {
        Post newPost = new Post(id, content, postStatus, labels, created, updated);
        return postRepository.save(newPost);

    }

    public Post updatePost(Long id, String content, PostStatus postStatus, List<Label> labels,
                           Date created, Date updated) {
        Post updatePost = new Post(id, content, postStatus, labels, created, updated);
        return postRepository.update(updatePost);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

}





