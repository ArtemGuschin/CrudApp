package net.artem.crudapp.view;

import net.artem.crudapp.controller.LabelController;
import net.artem.crudapp.controller.PostController;
import net.artem.crudapp.enums.LabelStatus;
import net.artem.crudapp.enums.PostStatus;
import net.artem.crudapp.model.Label;
import net.artem.crudapp.model.Post;

import java.util.*;

public class PostView {
    private final Scanner SCANNER = new Scanner(System.in);
    private final PostController postController = new PostController();
    private final LabelController labelController = new LabelController();


    public void createPost() {
        System.out.println("Enter post content ");
        String content = SCANNER.nextLine();
        PostStatus postStatus = PostStatus.ACTIVE;
        List<Label> labels = fulfillsLabels();
        Post createdPost = postController.createPost(content, labels);
        System.out.println("Created post " + createdPost);

    }

    private List<Label> fulfillsLabels() {
        List<Label> result = new ArrayList<>();
        List<Label> allLabels = labelController.getAll();
        while (true) {
            System.out.println("Enter label id (-1 To complete ) ");
            System.out.println(allLabels);

            Long choice = SCANNER.nextLong();
            if (choice == -1L) {
                return result;
            }
//            HashMap<Long,Label> idLabel = new HashMap<>();
//            allLabels.stream().forEach(label -> idLabel.put(label.getId(),label));
            Label selectedLabel = allLabels.stream()
                    .filter(cl -> cl.getId().equals(choice)).findFirst().orElse(null);
            if (Objects.nonNull(selectedLabel)) {
                result.add(selectedLabel);
            }
        }
    }

    public void updatePost() {
        System.out.println("Enter id post to update ");
        Long id = SCANNER.nextLong();
        SCANNER.nextLine();
        System.out.println("Enter content to update ");
        String content = SCANNER.nextLine();
        PostStatus postStatus = PostStatus.UNDER_REVIEW;
        List<Label> labels = fulfillsLabels();
        Post updatedPost = postController.updatePost(id, content, postStatus, labels, new Date(),new Date());


    }

    public void deletePost() {
        System.out.println("Enter id to delete :");
        Long id = SCANNER.nextLong();
        postController.deletePost(id);
        System.out.println("Post with id " + id + " deleted");
    }


}