package net.artem.crudapp.view;

import net.artem.crudapp.controller.LabelController;
import net.artem.crudapp.enums.LabelStatus;
import net.artem.crudapp.model.Label;

import java.util.Scanner;

public class LabelView {

    private final LabelController labelController = new LabelController();
    private final Scanner SCANNER = new Scanner(System.in);

    public void startLabel() {
        while (true) {
            System.out.println("Hello I am firstApp!!!");
            System.out.println("1 - create Label ");
            System.out.println("2 - update Label");
            System.out.println("3 - delete Label");
            System.out.println("Press 0 for exit");

            int userChoice = SCANNER.nextInt();
            SCANNER.nextLine();

            switch (userChoice) {
                case 1:
                    createLabel();
                    break;
                case -1, -2, -3:
                    System.out.println("Good Bye");
                    System.exit(0);
                case 2:
                    updateLabel();
                    break;
                case 3:
                    deleteLabel();
                    break;
                default:
                    System.exit(0);
            }
        }
    }


   private void createLabel() {
        System.out.println("Enter label name: ");
        String labelName = SCANNER.nextLine();
        Label createdLabel = labelController.createLabel(labelName);
        System.out.println("Crated label: " + createdLabel);
    }

   private void updateLabel() {
        System.out.println("Enter  id Label to update :");
        Long id = SCANNER.nextLong();
        SCANNER.nextLine();

        System.out.println("Enter update name :");
        String name = SCANNER.nextLine();

        LabelStatus labelStatus = LabelStatus.ACTIVE;

        Label updateLabel = labelController.updateLabel(id, name, labelStatus);
        System.out.println("Label update with Id " + updateLabel.getId());
    }

   private void deleteLabel() {
        System.out.println("Enter label Id  to delete :");
        Long id = SCANNER.nextLong();
        labelController.deleteLabel(id);
        System.out.println("Label deleted");
    }


}

