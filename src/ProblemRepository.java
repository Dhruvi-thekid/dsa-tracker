import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


// storage/access data
public class ProblemRepository {

    private final ArrayList<Problem> problems = new ArrayList<>();

    //to give the access of this arraylist to the "service" methods
    //and to avoid handling two arraylist or making two copies
    public ArrayList<Problem> getProblems(){
        return problems;
    }
    
    //to find problem by ID 
    public Problem findProblemById(int id){
        for(Problem problem: problems){
            if(problem.getId() == id){
                return problem;
            }
        }
        return null;
    }

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
    //to load the exisiting data first
    public ProblemRepository(){
        loadProblems();  
    }
    
}
