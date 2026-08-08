public class Problem{
    private int id;
    private String title;
    private String platform;
    private String difficulty;
    private String topic;
    private String status;

    public Problem(int id, String title, 
        String platform, String difficulty, 
        String topic, String status){

            this.id = id;
            this.title = title;
            this.platform = platform;
            this.difficulty = difficulty;
            this.topic = topic;
            this.status = status;
    }

    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    } 

    public String getPlatform(){
        return platform;
    } 

    public String getDifficulty(){
        return difficulty;
    }

    public String getTopic(){
        return topic;
    }

    public String getStatus(){
        return status;
    }

    public void setId(int id){
        this.id = id;
    }
    
    public void setTitle(String title){
        this.title = title;
    }

    public void setPlatform(String platform){
        this.platform = platform;
    }

    public void setDifficulty(String difficulty){
        this.difficulty = difficulty;
    }

    public void setTopic(String topic){
        this.topic = topic;
    }

    public void setStatus(String status){
        this.status = status;
    }
}