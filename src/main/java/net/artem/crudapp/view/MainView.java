package net.artem.crudapp.view;

import java.util.Scanner;

public class MainView {
    private final LabelView labelView = new LabelView();
    private final PostView postView = new PostView();
    private final WriterView writerView = new WriterView();
    private final Scanner SCANNER = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("Hello I am firstApp!!!");
            System.out.println("1 -  create Label ");
            System.out.println("2 - update Label");
            System.out.println("3 - delete Label");

            int userChoice = SCANNER.nextInt();

            switch (userChoice) {
                case 1:
                    labelView.createLabel();
                    break;
                case -1, -2, -3:
                    System.out.println("Good Bye");
                    System.exit(0);
                case 2:
                    labelView.updateLabel();
                    break;
                case 3:
                    labelView.deleteLabel();
                    break;

                default:
                    System.exit(0);
            }
        }
    }
}
