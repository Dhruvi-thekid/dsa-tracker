public class Problem{
    private int id;
    private String title;
    private String platform;
    private Difficulty difficulty;
    private String topic;
    private Status status;

    public Problem(int id, String title, 
        String platform, Difficulty difficulty, 
        String topic, Status status){

            this.id = id;
            this.title = title;
            this.platform = platform;
            this.difficulty = difficulty;
            this.topic = topic;
            this.status = status;
    }
    // all getter methods from the user
    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    } 

    public String getPlatform(){
        return platform;
    } 

    public Difficulty getDifficulty(){
        return difficulty;
    }

    public String getTopic(){
        return topic;
    }

    public Status getStatus(){
        return status;
    }

    //all setter methods to set the data given by users
    public void setId(int id){
        this.id = id;
    }
    
    public void setTitle(String title){
        this.title = title;
    }

    public void setPlatform(String platform){
        this.platform = platform;
    }

    public void setDifficulty(Difficulty difficulty){
        this.difficulty = difficulty;
    }

    public void setTopic(String topic){
        this.topic = topic;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public void display(){
        System.out.println("------------------------------");
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Platform: " + platform);
        System.out.println("Difficulty: " + difficulty);
        System.out.println("Topic: " + topic);
        System.out.println("Status: " + status);
        System.out.println("------------------------------");
    }
}