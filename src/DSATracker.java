import java.util.ArrayList;

public class DSATracker {
    private final ArrayList<Problem> problems = new ArrayList<>();

    //to add a new problem in the ArrayList
    public void addProblem(Problem problem) {
        if(findProblemById(problem.getId()) != null){
            System.out.println("A problem with this ID already exist");
            return;
        }
        problems.add(problem);
        System.out.println("Problem added Successfully");
    }


    //To view the number of problems in the ArrayList
    public void viewProblem(){

        System.out.println("Number of problems: " + problems.size());

        for(Problem problem: problems){
            problem.display();
        }
    }

    //To serach a specific problem
    public void searchProblem(String keyword){

        Boolean found = false;

        keyword = keyword.toLowerCase();
        for(Problem problem : problems){
                //all these conditions to search when any of the other fields enetered
                if(problem.getTopic().toLowerCase().contains(keyword) ||
                    problem.getTitle().toLowerCase().contains(keyword)||
                    problem.getPlatform().toLowerCase().contains(keyword)||
                    problem.getStatus().toString().toLowerCase().contains(keyword)||
                    problem.getDifficulty().toString().toLowerCase().contains(keyword)){

                        found = true;

                    System.out.println("ID:" +problem.getId());
                    System.out.println("Title:"+problem.getTitle());
                    System.out.println("Platform:"+problem.getPlatform());
                    System.out.println("Difficulty:"+problem.getDifficulty());
                    System.out.println("Topic:"+problem.getTopic());
                    System.out.println("Status:"+problem.getStatus());
                }

                if(found == false){
                    System.out.println("No Problems found matching " +keyword);
                }
        }
    }

    //To update the status of the problem
    public void updateProblem(int id, Status newStatus){

        Problem problem = findProblemById(id);
        if(problem == null){
            System.out.println("Problem not found");
            return;
        }
        else{

            System.out.println("ID: " + problem.getId());
            System.out.println("Old Status: " + problem.getStatus());

            problem.setStatus(newStatus);

            System.out.println("New Status: " + problem.getStatus());

            System.out.println("Updated Successfully");
        }
    }

    //to delete the problem
    public void deleteProblem(int id){

        Problem problem = findProblemById(id);

        if(problem == null){
            System.out.println("Problem not found");
            return;
        }
        problems.remove(problem);

        System.out.println("Deleted Successfully");

    }

    //to find if a problem already exist of that ID or not
    public Problem findProblemById(int id){
        for(Problem problem : problems){
            if(problem.getId() == id){
                return problem;
            }
        }
        return null;
    }

    public void menu(){

    }
}
