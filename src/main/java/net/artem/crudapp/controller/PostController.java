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


    public PostController() {
        this.postRepository = new GsonPostRepositoryImpl();
    }

    public Post createPost(String content, List<Label> labels) {
        Post newPost = Post.builder()
                .content(content)
                .postStatus(PostStatus.ACTIVE)
                .labels(labels)
                .created(new Date())
                .updated(new Date())
                .build();
        return postRepository.save(newPost);

    }

    public Post updatePost(Long id, String content, PostStatus postStatus, List<Label> labels,
                           Date created, Date updated) {
        Post updatePost = Post.builder()
                .id(id)
                .content(content)
                .postStatus(postStatus)
                .labels(labels)
                .build();
        return postRepository.update(updatePost);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }




    public List<Post> getAll() {
        return postRepository.getAll();
    }
}





