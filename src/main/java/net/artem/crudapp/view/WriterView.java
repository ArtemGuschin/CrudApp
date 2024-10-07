package net.artem.crudapp.view;

import net.artem.crudapp.controller.WriterController;
import net.artem.crudapp.enums.LabelStatus;
import net.artem.crudapp.enums.WriterStatus;
import net.artem.crudapp.model.Label;
import net.artem.crudapp.model.Writer;

import java.util.Scanner;

public class WriterView {
    private final WriterController writerController = new WriterController();
    private final Scanner SCANNER = new Scanner(System.in);


//    public void createWriter() {
//        System.out.println("Enter  firstName: ");
//        String firstName = SCANNER.nextLine();
//        String lastName = SCANNER.nextLine();
//        String posts = SCANNER.nextLine();
//        WriterStatus writerStatus = WriterStatus.ACTIVE;
//        Writer createdWriter = WriterController.createWriter(firstName,lastName,posts);
//        System.out.println("Crated label: " + createdWriter);
//
//    }
//
//    public void updateWriter() {
//        System.out.println("Enter  id Writer to update :");
//        Long id = SCANNER.nextLong();
//        SCANNER.nextLine();
//
//        System.out.println("Enter update name :");
//        String firstName = SCANNER.nextLine();
//        String lastName = SCANNER.nextLine();
//        String posts = SCANNER.nextLine();
//        WriterStatus writerStatus = WriterStatus.UNDER_REVIEW;
//
//        Writer updatedWriter = WriterController.
//
//    }
//    public void deleteWriter() {
//        System.out.println("Enter writer Id  to delete :");
//        Long id = SCANNER.nextLong();
//        WriterController.
//
//
//    }


}
