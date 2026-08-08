import java.util.ArrayList;

public class DSATracker {
    private final ArrayList<Problem> problems = new ArrayList<>();

    public void addProblem(Problem problem) {
    problems.add(problem);
    System.out.println("Problem added Successfully");
    }

    public void viewProblem(){

        System.out.println("Number of problems: " + problems.size());

        for(Problem problem: problems){
            System.out.println("ID:" +problem.getId());
            System.out.println("Title:"+problem.getTitle());
            System.out.println("Platform:"+problem.getPlatform());
            System.out.println("Difficulty:"+problem.getDifficulty());
            System.out.println("Topic:"+problem.getTopic());
            System.out.println("Status:"+problem.getStatus());

            System.out.println("-------------------------");

        }
    }

    public void searchProblem(String keyword){
        for(Problem problem : problems){
                if(problem.getTopic().contains(keyword)){
                System.out.println("ID:" +problem.getId());
                System.out.println("Title:"+problem.getTitle());
                System.out.println("Platform:"+problem.getPlatform());
                System.out.println("Difficulty:"+problem.getDifficulty());
                System.out.println("Topic:"+problem.getTopic());
                System.out.println("Status:"+problem.getStatus());
            }
        }
    }

    public void updateProblem(int id, String newStatus){
        for(Problem problem : problems){
            if(problem.getId() == id){
                System.out.println("ID:" + problem.getId());
                System.out.println("Old Status:"+problem.getStatus());
                problem.setStatus(newStatus);
            }
        }
        System.out.println("Updated Successfully");

    }

    public void deleteProblem(int id){
        for(int i = 0; i<problems.size(); i++){
            Problem problem = problems.get(i);

            if(problem.getId() == id){
                problems.remove(i);
            }
        }
        System.out.println("Deleted Successfully");

    }

    public void menu(){

    }
}
