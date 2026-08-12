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

                    System.out.println("Enter Notes for the Problem: ");
                    String notes = sc.nextLine();

                    Problem pn = new Problem(id, title, platform, difficulty, topic, status, notes);

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
                    System.out.println("Update the Problem");

                    System.out.println("What do you want to update?");
                    System.out.println("1. Status");
                    System.out.println("2. Notes");
                    System.out.println("3. Both[Status / Notes]");

                    int update = sc.nextInt();
                    sc.nextLine();

                    switch(update){
                        case 1:
                            System.out.println("Updation of Status is selected");

                            System.out.println("Enter the ID number of the Problem:");
                            int sid = sc.nextInt();
                            sc.nextLine();

                                Status newStatus = chooseStatus(sc);
                                sc.nextLine();

                                tracker.updateProblem(sid,newStatus);      
                                break;
                    
                        case 2:
                            System.out.println("Updation of Notes is selected");

                            System.out.println("Enter the ID number of the Problem:");
                            int nid = sc.nextInt();
                            sc.nextLine();

                            System.out.println("Enter your new updation for notes");
                            String newNotes = sc.nextLine();

                            tracker.updateNotes(nid, newNotes);
                            break;
                        
                        case 3:
                            System.out.println("Updation for Status as well as Notes is selected");

                            System.out.println("Enter the ID number of the Problem:");
                            int snid = sc.nextInt();
                            sc.nextLine();

                            Status new_Status = chooseStatus(sc);
                            sc.nextLine();
                            
                            System.out.println("Enter your new updation for notes");
                            String new_Notes = sc.nextLine();

                            tracker.updateProblem(snid, new_Status, new_Notes);
                            tracker.saveProblems();

                            break;

                        default:
                            System.out.println("Choose a correct option");
                    }
                    break;
                case 5:
                    System.out.println("Delete A Problem");

                    System.out.println("Enter the ID of the Problem you want to Delete");
                    int did = sc.nextInt();

                    Problem problem = tracker.findProblemById(did);
                    if(problem == null){
                        System.out.println("No Problem Found");
                        break;
                    }

                    problem.display();


                    System.out.println("Are you sure you want to delete ID "+did+"?");
                    System.out.println("Select:");
                    
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    int s = sc.nextInt();

                    switch (s) {
                        case 1:
                            tracker.deleteProblem(did);
                            break;
                        case 2:
                            System.out.println("Delection Suspended");
                            break;
                    
                        default:
                            System.out.println("Invalid Choice. Deletion Suspended");
                            break;
                    }
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

    public static Status chooseStatus(Scanner sc){

        System.out.println("Choose A Status for the Problem:");
        System.out.println("1. Not Started");
        System.out.println("2. Attempted");
        System.out.println("3. Solved");
        System.out.println("4. Need Revision");

        int choice = sc.nextInt();

            switch (choice){
                case 1:
                    return Status.NOT_STARTED;
                case 2:
                    return Status.ATTEMPTED;
                case 3:
                    return Status.SOLVED;
                case 4:
                    return Status.NEED_REVISION;
                default:
                    System.out.println("Invalid Choice. Defaulting to Not Started");
                    return Status.NOT_STARTED;
            }
        }
}
