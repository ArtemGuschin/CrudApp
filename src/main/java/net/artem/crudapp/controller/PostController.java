package net.artem.crudapp.controller;

import lombok.RequiredArgsConstructor;
import net.artem.crudapp.enums.LabelStatus;
import net.artem.crudapp.enums.PostStatus;
import net.artem.crudapp.model.Label;
import net.artem.crudapp.model.Post;
import net.artem.crudapp.repository.PostRepository;
import net.artem.crudapp.repository.gson.GsonPostRepositoryImpl;

import java.util.ArrayList;
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


    public Post createWriter(String content, Date created, Date update, List<Label> labels) {

        Post newPost = new Post(content, created, update, labels);
        return postRepository.save(newPost);

    }

    public Post updatePost(Long id, String content, Date created, Date updated, List<Label> labels) {
        Post updatePost = new Post(content, created, updated, labels);
        return postRepository.update(updatePost);

    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

}

