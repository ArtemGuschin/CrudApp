package net.artem.crudapp.view;

import java.util.Scanner;

public class MainView {
    private final LabelView labelView = new LabelView();
    private final PostView postView = new PostView();
    private final WriterView writerView = new WriterView();
    private final Scanner SCANNER = new Scanner(System.in);

    public void mainApp() {
        while (true) {
            System.out.println("Enter 1 to work for labels");
            System.out.println("Enter 2 to work for Posts");
            System.out.println("Enter 3 to work for Writers");
            System.out.println("Enter 0 for exit");

            int userChoice = SCANNER.nextInt();

            switch (userChoice) {
                case 1:
                    startLabel();
                    break;
                case -1, -2, -3:
                    System.out.println("Good Bye");
                    System.exit(0);
                case 2:
                    startPost();
                    break;
                case 3:
                    startWriter();
                    break;
                default:
                    System.exit(0);
            }
        }
    }

    public void startLabel() {
        while (true) {
            System.out.println("Hello I am firstApp!!!");
            System.out.println("1 - create Label ");
            System.out.println("2 - update Label");
            System.out.println("3 - delete Label");
            System.out.println("4 - mainApp");

            System.out.println("Press 0 for exit");

            int userChoice = SCANNER.nextInt();

            switch (userChoice) {
                case 1:
                    labelView.createLabel();
                    break;
                case -1, -2, -3, -4:
                    System.out.println("Good Bye");
                    System.exit(0);
                case 2:
                    labelView.updateLabel();
                    break;
                case 3:
                    labelView.deleteLabel();
                    break;
                case 4:
                    mainApp();

                default:
                    System.exit(0);
            }
        }
    }

    public void startPost() {
        while (true) {
            System.out.println("Hello I am firstApp!!!");
            System.out.println("1 -  create Post ");
            System.out.println("2 - update Post");
            System.out.println("3 - delete Post");
            System.out.println("4 - mainApp");
            System.out.println("Press 0 for exit");

            int userChoice = SCANNER.nextInt();

            switch (userChoice) {
                case 1:
                    postView.createPost();
                    break;
                case -1, -2, -3, -4:
                    System.out.println("Good Bye");
                    System.exit(0);
                case 2:
                    postView.updatePost();
                    break;
                case 3:
                    postView.deletePost();
                    break;
                case 4:
                    mainApp();
                    break;

                    default:
                    System.exit(0);
            }
        }
    }

    public void startWriter() {
        while (true) {
            System.out.println("Hello I am firstApp!!!");
            System.out.println("1 -  create Writer ");
            System.out.println("2 - update Writer");
            System.out.println("3 - delete Writer");
            System.out.println("4 - mainApp");
            System.out.println("Press 0 for exit");

            int userChoice = SCANNER.nextInt();

            switch (userChoice) {
                case 1:
                    writerView.createWriter();
                    break;
                case -1, -2, -3, -4:
                    System.out.println("Good Bye");
                    System.exit(0);
                case 2:
                    writerView.updateWriter();
                    break;
                case 3:
                    writerView.deleteWriter();
                    break;
                case 4:
                    mainApp();


                default:
                    System.exit(0);
            }
        }
    }
}
