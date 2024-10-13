package net.artem.crudapp.view;

import net.artem.crudapp.controller.LabelController;
import net.artem.crudapp.enums.LabelStatus;
import net.artem.crudapp.model.Label;

import java.util.Scanner;

public class LabelView {

    private final LabelController labelController = new LabelController();
    private final Scanner SCANNER = new Scanner(System.in);


    public void createLabel() {
        System.out.println("Enter label name: ");
        String labelName = SCANNER.nextLine();
        Label createdLabel = labelController.createLabel(labelName);
        System.out.println("Crated label: " + createdLabel);
    }

    public void updateLabel() {
        System.out.println("Enter  id Label to update :");
        Long id = SCANNER.nextLong();
        SCANNER.nextLine();

        System.out.println("Enter update name :");
        String name = SCANNER.nextLine();

        LabelStatus labelStatus = LabelStatus.ACTIVE;

        Label updateLabel = labelController.updateLabel(id, name, labelStatus);
        System.out.println("Label update with Id " + updateLabel.getId());
    }

    public void deleteLabel() {
        System.out.println("Enter label Id  to delete :");
        Long id = SCANNER.nextLong();
        labelController.deleteLabel(id);
        System.out.println("Label deleted");
    }


}

