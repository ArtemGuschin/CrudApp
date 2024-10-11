package net.artem.crudapp.view;

import net.artem.crudapp.controller.PostController;
import net.artem.crudapp.enums.LabelStatus;
import net.artem.crudapp.enums.PostStatus;
import net.artem.crudapp.model.Label;
import net.artem.crudapp.model.Post;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PostView {
    private final Scanner SCANNER = new Scanner(System.in);
    private final PostController postController = new PostController();

    public void showMainLabelView() {

    }


    public void createPost() {
        System.out.println("Enter post id: ");
        Long id = SCANNER.nextLong();
        System.out.println("Enter post content ");
        String content = SCANNER.nextLine();
        PostStatus postStatus = PostStatus.ACTIVE;
        Label label = Label.builder()
                .id(1L)
                .labelStatus(LabelStatus.UNDER_REVIEW)
                .name("sport")
                .build();
        Post createdPost = postController.createPost(id,content,postStatus, (List<Label>) label,new Date(),new Date());

    }

    public void updatePost() {

    }

    public void deletePost() {
        System.out.println("Enter id to delete :");
        Long id = SCANNER.nextLong();
        postController.deletePost(id);
        System.out.println("Post with id " + id + " deleted");
    }


}