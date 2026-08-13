import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DSATracker {
    private final ArrayList<Problem> problems = new ArrayList<>();
    

    //to add a new problem in the ArrayList
    public void addProblem(Problem problem) {
        if(findProblemById(problem.getId()) != null){
            System.out.println("A problem with this ID already exist");
            return;
        }
        problems.add(problem);
        saveProblems();
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

        boolean found = false;

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
        }
        if(found == false){
            System.out.println("No Problems found matching " +keyword);
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
            saveProblems();

            //System.out.println("New Status: " + problem.getStatus());

            System.out.println(" Status Updated Successfully");
        }
    }

    //@overloading-to fix "saveProblem() twice"
    public void updateProblem(int id, Status newStatus, String newNotes){
        Problem problem = findProblemById(id);

        if(problem == null){
            System.out.println("Problem not found");
            return;
        }
        System.out.println("ID: "+problem.getId());
        System.out.println("Old Status: "+problem.getStatus());
        System.out.println("Note: "+problem.getNotes());

        problem.setNotes(newNotes);
        problem.setStatus(newStatus);
        saveProblems();

        System.out.println("Updated Status as well as Notes");
    }

    //to delete the problem
    public void deleteProblem(int id){

        Problem problem = findProblemById(id);

        if(problem == null){
            System.out.println("Problem not found");
            return;
        }
        problems.remove(problem);

        System.out.println("Problems remaining after deletion:");
        viewProblem();

        saveProblems();

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

    //to keep the data persistent
    public void saveProblems(){

        try{

            FileWriter writer = new FileWriter("data.txt");

            for(Problem problem : problems){
                String line = 
                problem.getId() +"|"+
                problem.getTitle() +"|"+
                problem.getPlatform() +"|"+
                problem.getDifficulty() +"|"+
                problem.getTopic()+"|"+
                problem.getStatus()+"|"+
                problem.getNotes();

                writer.write(line);
                writer.write('\n');
            }
            writer.close();
        }
        catch(IOException e){
            System.out.println("Error, saving problem");
        }
    }

    //to load the data from the file back to ArrayList to keep the data consistency
    public void loadProblems(){

        File file= new File("data.txt");

        if(!file.exists()){
            System.out.println("No existing data found. Starting with an empty Tracker.");
            return;
        }
        try{
            BufferedReader reader = new BufferedReader(new FileReader("data.txt"));

            String line;
            while((line = reader.readLine()) != null){
                String data[] = line.split("\\|",-1);

                int id = Integer.parseInt(data[0]);
                String title = data[1];
                String platform = data[2];
                Difficulty difficulty = Difficulty.valueOf(data[3].toUpperCase());
                String topic = data[4];
                Status status = Status.valueOf(data[5].trim().toUpperCase().replace(" ", "_"));
                String notes = data[6];

                Problem problem = new Problem(
                id,
                title,
                platform,
                difficulty,
                topic,
                status,
                notes);

                problems.add(problem);

            }
                reader.close();
        }
        catch(IOException e){
            System.out.println("Error loading data");
        }
    }

    //constructor that loads all the problems first from the file
    public DSATracker(){
        loadProblems();
    }

    //to update the notes feature
    public void updateNotes(int id, String newNotes){
        Problem problem = findProblemById(id);
        if(problem == null){
            System.out.println("Problem notfound");
            return;
        }
        else{
            System.out.println("ID:"+ problem.getId());
            System.out.println("Note: "+problem.getNotes());

            problem.setNotes(newNotes);
            saveProblems();
        }

    }

    //to estimate the overall DSA progress
    public void viewProgress(){

        System.out.println("========== DSA PROGRESS ==========");
        int solved = 0;
        int notstarted = 0;
        int needrevision = 0;
        int attempted = 0;

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
            else{
                System.out.println("Error Loading Progress");
            }
        }
        System.out.println("Solved Problems:  "+solved);
        System.out.println("Attempted Problems:  "+ attempted);
        System.out.println("Need Revision Problems:  "+ needrevision);
        System.out.println("Not Started Problems:  "+ notstarted);

        System.out.println();
        System.out.println();


        double percentage = 0;
        if(total == 0){
            percentage = 0;
        }
        else{
            percentage = ((double)solved/total) * 100;
            System.out.println("Progress:  "+ percentage+"%");
        }

        System.out.println("===================================");
    }

    //to estimate topic vise Progress
    //used HasMap here
    public void viewTopicProgress(){

        System.out.println("========== TOPIC PROGRESS ==========");
        HashMap<String, Integer> topicCount = new HashMap<>();

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


    //to analize progess by cal. topic-wise solved problem
    //used HashMap here as well
    public void viewSolvedByTopic(){

        System.out.println("========== SOLVED BY TOPIC ==========");
        HashMap<String, Integer> solvedTopicCount = new HashMap<>();

        

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

    public void menu(){

    }
}
