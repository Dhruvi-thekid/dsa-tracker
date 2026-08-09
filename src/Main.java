import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        DSATracker tracker = new DSATracker();

       /*  Problem p1 = new Problem(
            1,
            "Two Sum",
            "LeetCode",
            "Easy",
            "Arrays",
            "Solved"
        );

        Problem p2 = new Problem(
            2,
            "Binary Search",
            "LeetCode",
            "Easy",
            "Searching",
            "Solved"
        );


        tracker.addProblem(p1);   
        tracker.addProblem(p2);

        tracker.updateProblem(1, "Need Revision");
        //tracker.updateProblem(12, "Solved");

        tracker.deleteProblem(2);

        tracker.viewProblem();*/

        Scanner sc = new Scanner(System.in);

        int choice = 0;
        while(choice != 6){

            System.out.println("========== DSA TRACKER ==========");
            System.out.println();
            System.out.println("1. Add Problem");
            System.out.println("2. View Problems");
            System.out.println("3. Search Problem");
            System.out.println("4. Update Problem");
            System.out.println("5. Delete Problem");
            System.out.println("6. Exit");

            System.out.println();
            System.out.println();


            System.out.println("Enter your choice:");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter a new Problem");

                    System.out.println("Enter ID number:");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Title Name:");
                    String title = sc.nextLine();

                    System.out.println("Enter The Platform:");
                    String platform = sc.nextLine();

                    System.out.println("Choose A  Difficulty Level of the Problem:");
                    System.out.println("1. Easy");
                    System.out.println("2. Medium");
                    System.out.println("3. Hard");

                    int difficultyChoice = sc.nextInt();
                    sc.nextLine();

                    Difficulty difficulty;
                    switch(difficultyChoice){
                        case 1:
                            difficulty = Difficulty.EASY;
                            break;
                        case 2:
                            difficulty = Difficulty.MEDIUM;
                            break;
                        case 3:
                            difficulty = Difficulty.HARD;
                        default:
                            difficulty = Difficulty.EASY;
                            System.out.println("Invalid choice. Defaulting to RASY");
                    }
                    System.out.println("Difficulty Selected");

                    System.out.println("Enter Topic Name:");
                    String topic = sc.nextLine();

                    System.out.println("Choose A Status for the Problem:");
                    System.out.println("1. Not Started");
                    System.out.println("2. Attemped");
                    System.out.println("3. Solved");
                    System.out.println("4. Need Revision");

                    int statusChoice = sc.nextInt();
                    sc.nextLine();

                    Status status;
                    switch(statusChoice){
                        case 1:
                            status = Status.NOT_STARTED;
                            break;
                        case 2:
                            status = Status.ATTEMPTED;
                            break;
                        case 3:
                            status = Status.SOLVED;
                            break;
                        case 4:
                            status = Status.NEED_REVISION;
                            break;
                        default:
                            status = Status.NOT_STARTED;
                            System.out.println("Invalid Choice. Defaulting to Not Started");
                    }
                    System.out.println("Status Selected");

                    Problem pn = new Problem(id, title, platform, difficulty, topic, status);

                    tracker.addProblem(pn);
                    break;

                    
                case 2:
                    System.out.println("View All the Problmes");
                    tracker.viewProblem();

                    break;
                case 3:
                    System.out.println("Search A Problem");
                    sc.nextLine();

                    System.out.println("Enter the problem you want to search:");
                    String keyword = sc.nextLine();

                    tracker.searchProblem(keyword);
                    break;
                case 4:
                    System.out.println("Update the Staus of the Problem");

                    System.out.println("Enter the ID number of the Problem:");
                    int sid = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Choose A Status for the Problem:");
                    System.out.println("1. Not Started");
                    System.out.println("2. Attemped");
                    System.out.println("3. Solved");
                    System.out.println("4. Need Revision");

                    int statusChoiceUpdate = sc.nextInt();
                    sc.nextLine();

                    Status newStatus;
                    switch(statusChoiceUpdate){
                        case 1: 
                            newStatus = Status.NOT_STARTED;
                            break;
                        case 2:
                            newStatus = Status.ATTEMPTED;
                            break;
                        case 3:
                            newStatus = Status.SOLVED;
                            break;
                        case 4:
                            newStatus = Status.NEED_REVISION;
                            break;
                        default:
                            newStatus = Status.NOT_STARTED;
                            System.out.println("Invalid Choice. Defaulting to Not Started");
                    }
                    tracker.updateProblem(sid,newStatus);
                    break;
                case 5:
                    System.out.println("Delete A Problem");

                    System.out.println("Enter the ID of the Problem you want to Delete");
                    int did = sc.nextInt();

                    tracker.deleteProblem(did);
                    break;

                case 6:
                    System.out.println("Exiting DSA Tracker");
                    break;

                default:
                    System.out.println("Invalid Choice. Please try again");
            }
        }
        sc.close();
    }
}
