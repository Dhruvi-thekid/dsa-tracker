import java.util.Scanner;

// user interaction
public class Main {
    public static void main(String[] args) {

        ProblemRepository repository = new ProblemRepository();
        ProblemService service = new ProblemService(repository);


        Scanner sc = new Scanner(System.in);

        int choice = 0;
        while(choice != 9){

            System.out.println("========== DSA TRACKER ==========");
            System.out.println();
            System.out.println("1. Add Problem");
            System.out.println("2. View Problems");
            System.out.println("3. Search Problem");
            System.out.println("4. Update Problem");
            System.out.println("5. Delete Problem");
            System.out.println("6. View Progress");
            System.out.println("7. View Topic Progress");
            System.out.println("8. View Solved By Topic Problems");
            System.out.println("9. Exit");

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

                    service.addProblem(pn);
                    break;

                    
                case 2:
                    System.out.println("View All the Problmes");

                    service.viewProblems();

                    break;
                case 3:
                    System.out.println("Search A Problem");
                    sc.nextLine();

                    System.out.println("Enter the problem you want to search:");
                    String keyword = sc.nextLine();

                    service.serachProblems(keyword);
                    break;
                
                case 4:
                    System.out.println("Update Problem");

                    System.out.println("Enter Problem ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    Problem problem = repository.findProblemById(uid);

                    if(problem == null){
                        System.out.println("No ID found under that ID");
                        break;
                    }

                    problem.display();

                    System.out.println("\nWhat do you want to update?");
                    System.out.println("1. Title");
                    System.out.println("2. Platform");
                    System.out.println("3. Difficulty");
                    System.out.println("4. Topic");
                    System.out.println("5. Status");
                    System.out.println("6. Notes");
                    System.out.println("7. Cancel");

                    int updateChoice = sc.nextInt();
                    sc.nextLine();

                    switch(updateChoice){
                         case 1:
                            System.out.println("Enter new title:");
                            String newTitle = sc.nextLine();
                            problem.setTitle(newTitle);
                            break;

                        case 2:
                            System.out.println("Enter new platform:");
                            String newPlatform = sc.nextLine();
                            problem.setPlatform(newPlatform);
                            break;

                        case 3:
                            System.out.println("Choose new difficulty:");
                            Difficulty newDifficulty = chooseDifficulty(sc);
                            problem.setDifficulty(newDifficulty);
                            break;
                        
                        case 4:
                            System.out.println("Enter new topic:");
                            String newTopic = sc.nextLine();
                            problem.setTopic(newTopic);
                            break;

                        case 5:
                            Status updateStatus = chooseStatus(sc);
                            problem.setStatus(updateStatus);
                            break;

                        case 6:
                            System.out.println("Enter new notes:");
                            String updateNotes = sc.nextLine();
                            problem.setNotes(updateNotes);
                            break;

                        case 7:
                            System.out.println("Update cancelled.");
                            break;

                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                    repository.saveProblems();
                    System.out.println("Updated Successfully");
                    break; 

                case 5:
                    System.out.println("Delete A Problem");

                    System.out.println("Enter the ID of the Problem you want to Delete");
                    int did = sc.nextInt();

                    Problem deleteProblem = repository.findProblemById(did);
                    if(deleteProblem == null){
                        System.out.println("No Problem Found");
                        break;
                    }


                    System.out.println("Are you sure you want to delete ID "+did+"?");
                    System.out.println("Select:");
                    
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    int s = sc.nextInt();

                    switch (s) {
                        case 1:
                            service.deleteProblem(did);
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
                    System.out.println("Your DSA Progress:");
                    service.viewProgress();
                    break;

                case 7:
                    System.out.println("Your Topic-Wise Progress");
                    service.viewTopicProgress();
                    break;

                case 8:
                    System.out.println("Your Topic-Wise Solved Problems");
                    service.viewSolvedByTopic();
                    break;

                case 9:
                    System.out.println("Exit DSA Tracker");
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

    public static Difficulty chooseDifficulty(Scanner sc){
        System.out.println("Choose Difficulty:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");

         int choice = sc.nextInt();

    switch (choice){
        case 1:
            return Difficulty.EASY;

        case 2:
            return Difficulty.MEDIUM;

        case 3:
            return Difficulty.HARD;

        default:
            System.out.println("Invalid choice. Defaulting to Easy");
            return Difficulty.EASY;
        }
    }
}
