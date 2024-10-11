package net.artem.crudapp.view;

import net.artem.crudapp.controller.WriterController;
import net.artem.crudapp.enums.PostStatus;
import net.artem.crudapp.enums.WriterStatus;
import net.artem.crudapp.model.Post;
import net.artem.crudapp.model.Writer;


import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class WriterView {
    private final Scanner SCANNER = new Scanner(System.in);
    private final WriterController writerController = new WriterController();


    public void createWriter() {
        System.out.println("Enter id");
        Long id = SCANNER.nextLong();
        System.out.println("Enter firstName: ");
        String firstName = SCANNER.nextLine();
        System.out.println("Enter lastName: ");
        String lastName = SCANNER.nextLine();
        List<Post> posts = new ArrayList<>();
        WriterStatus writerStatus = WriterStatus.UNDER_REVIEW;
        Writer writerCreated = writerController.createWriter(id,firstName,lastName,posts,writerStatus);




    }

    public void updateWriter() {
        System.out.println("Enter  id Writer to update :");
        Long id = SCANNER.nextLong();
        System.out.println("Enter update name :");
        String firstName = SCANNER.nextLine();
        String lastName = SCANNER.nextLine();
        List<Post> posts = new ArrayList<>();
        WriterStatus writerStatus = WriterStatus.UNDER_REVIEW;
        Writer updatedWriter = writerController.updateWriter(id, firstName, lastName, posts, writerStatus);


    }

    public void deleteWriter() {
        System.out.println("Enter writer Id  to delete :");
        Long id = SCANNER.nextLong();
        writerController.deleteWriter(id);
        System.out.println("Writer  with id " + id + " deleted");


    }


}
