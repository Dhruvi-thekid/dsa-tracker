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

                    System.out.println("Enter Difficulty Level:");
                    String difficulty = sc.nextLine();

                    System.out.println("Enter Topic Name:");
                    String topic = sc.nextLine();

                    System.out.println("Enter Status of the Problem:");
                    String status = sc.nextLine();

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
                    System.out.println("Update A Problem");

                    System.out.println("Enter the ID number of the Problem:");
                    int sid = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Update Status of the Problem");
                    String newStatus = sc.nextLine();

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
