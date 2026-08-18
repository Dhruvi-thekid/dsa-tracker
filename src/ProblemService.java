import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProblemService {

    //logic 
    private final ProblemRepository repository;

    public ProblemService(ProblemRepository repository){
        this.repository = repository;
    }

    public void addProblem(Problem problem){
        Problem problems = repository.findProblemById(problem.getId());

        if(problems != null){
            System.out.println("A Problem already exist with this ID");
            return;
        }
        repository.getProblems().add(problem);
        repository.saveProblems();

        System.out.println("Problem Added Successfully");
    }

    public void update(int id){
        Problem problem = repository.findProblemById(id);

        if(problem == null){
            System.out.println("No problem found under this ID");
            return;
        }
        problem.display();
    }

    public void deleteProblem(int id){
        Problem problem = repository.findProblemById(id);

        if(problem == null){
            System.out.println("No ID found");
            return;
        }

        repository.getProblems().remove(problem);
        repository.saveProblems();

        System.out.println("Problem Deleted Successfully");
    }

    public void viewProblems(){
        
        ArrayList<Problem> problems = repository.getProblems();

        if(problems.isEmpty()){
            System.out.println("No ID found");
            return;
        }

        for(Problem problem : problems){
            problem.display();
        }

    }
    
    public void serachProblems(String keyword){
        boolean found = false;
        keyword = keyword.toLowerCase();

        for(Problem problem : repository.getProblems()){
            if(problem.getTopic().toLowerCase().contains(keyword)
                || problem.getTitle().toLowerCase().contains(keyword)
                || problem.getPlatform().toLowerCase().contains(keyword)
                || problem.getStatus().toString().toLowerCase().contains(keyword)
                || problem.getDifficulty().toString().toLowerCase().contains(keyword)){

                found = true;
                problem.display();
            }
        }

        if(!found){
            System.out.println("No problem found matching "+keyword);
        }

    }

    public void viewProgress(){
        System.out.println("========== DSA PROGRESS ==========");

        int solved = 0;
        int notstarted = 0;
        int needrevision = 0;
        int attempted = 0;

        ArrayList<Problem> problems = repository.getProblems();

        int total = problems.size();

        System.out.println("Total Problems:  " + total);

        System.out.println();

        for(Problem problem : problems){
            if(problem.getStatus() == Status.SOLVED){
            solved++;
            }
            else if(problem.getStatus() == Status.ATTEMPTED){
                attempted++;
            }
            else if(problem.getStatus() == Status.NEED_REVISION){
                needrevision++;
            }
            else if(problem.getStatus() == Status.NOT_STARTED){
                notstarted++;
            }
        }
        System.out.println("Solved Problems:  "+solved);
        System.out.println("Attempted Problems:  "+ attempted);
        System.out.println("Need Revision Problems:  "+ needrevision);
        System.out.println("Not Started Problems:  "+ notstarted);

        System.out.println();

        double percentage = 0;
        if(total != 0){
            percentage = ((double)solved/total) * 100;
        }

        System.out.println("Progress: " + percentage + "%");

        System.out.println("===================================");
    }

    public void viewTopicProgress(){
        System.out.println("========== TOPIC PROGRESS ==========");

        HashMap<String, Integer> topicCount = new HashMap<>();

        ArrayList<Problem> problems = repository.getProblems();


        for(Problem problem : problems){
            String topic = problem.getTopic();
            if(topicCount.containsKey(topic)){
                topicCount.put(topic, topicCount.get(topic)+1);
            }
            else{
                topicCount.put(topic,1);
            }
        }

        for(Map.Entry<String, Integer> entry : topicCount.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }

        System.out.println("=====================================");
    }

    public void viewSolvedByTopic(){
        System.out.println("========== SOLVED BY TOPIC ==========");

        HashMap<String, Integer> solvedTopicCount = new HashMap<>();
        ArrayList<Problem> problems = repository.getProblems();

        for(Problem problem : problems){
            String topic = problem.getTopic();

            if(problem.getStatus() == Status.SOLVED){
                if(solvedTopicCount.containsKey(topic)){
                    solvedTopicCount.put(topic, solvedTopicCount.get(topic)+1);
                }
                else{
                    solvedTopicCount.put(topic,1);
                }
            }
        }

        for(Map.Entry<String, Integer> entry : solvedTopicCount.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }

        System.out.println("=====================================");
    }
}
