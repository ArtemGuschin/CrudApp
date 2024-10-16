package net.artem.crudapp.view;

import net.artem.crudapp.controller.PostController;
import net.artem.crudapp.controller.WriterController;
import net.artem.crudapp.enums.PostStatus;
import net.artem.crudapp.enums.WriterStatus;
import net.artem.crudapp.model.Label;
import net.artem.crudapp.model.Post;
import net.artem.crudapp.model.Writer;


import java.awt.*;
import java.util.*;
import java.util.List;

public class WriterView {
    private final Scanner SCANNER = new Scanner(System.in);
    private final WriterController writerController = new WriterController();
    private final PostController postController = new PostController();


    private void createWriter() {
        System.out.println("Enter firstName: ");
        String firstName = SCANNER.nextLine();
        System.out.println("Enter lastName: ");
        String lastName = SCANNER.nextLine();
        List<Post> posts = new ArrayList<>();
        WriterStatus writerStatus = WriterStatus.ACTIVE;
        Writer createdWriter = writerController.createWriter(firstName, lastName, posts);
        System.out.println("Writer created ");


    }

    private void updateWriter() {
        System.out.println("Enter  id Writer to update :");
        Long id = SCANNER.nextLong();
        SCANNER.nextLine();
        System.out.println("Enter update name :");
        String firstName = SCANNER.nextLine();
        System.out.println("Enter LastName");
        String lastName = SCANNER.nextLine();
        List<Post> posts = fulfillsPosts();
        WriterStatus writerStatus = WriterStatus.UNDER_REVIEW;
        Writer updatedWriter = writerController.updateWriter(id, firstName, lastName, posts, writerStatus);
        System.out.println("Writer updated ");


    }


    private void deleteWriter() {
        System.out.println("Enter writer Id  to delete :");
        Long id = SCANNER.nextLong();
        writerController.deleteWriter(id);
        System.out.println("Writer  with id " + id + " deleted");


    }

    private List<Post> fulfillsPosts() {
        List<Post> result = new ArrayList<>();
        List<Post> allPosts = postController.getAll();
        while (true) {
            System.out.println("Enter Post id (-1 To complete ) ");
            System.out.println(allPosts);

            Long choice = SCANNER.nextLong();
            if (choice == -1L) {
                return result;
            }
            Post selectedPost = allPosts.stream()
                    .filter(cl -> cl.getId().equals(choice)).findFirst().orElse(null);
            if (Objects.nonNull(selectedPost)) {
                result.add(selectedPost);
            }
        }
    }
    public void startWriter() {
        while (true) {
            System.out.println("Hello I am firstApp!!!");
            System.out.println("1 -  create Writer ");
            System.out.println("2 - update Writer");
            System.out.println("3 - delete Writer");
            System.out.println("Press 0 for exit");

            int userChoice = SCANNER.nextInt();
            SCANNER.nextLine();

            switch (userChoice) {
                case 1:
                    createWriter();
                    break;
                case -1, -2, -3:
                    System.out.println("Good Bye");
                    System.exit(0);
                case 2:
                    updateWriter();
                    break;
                case 3:
                    deleteWriter();
                    break;
                default:
                    System.exit(0);
            }
        }
    }


}
