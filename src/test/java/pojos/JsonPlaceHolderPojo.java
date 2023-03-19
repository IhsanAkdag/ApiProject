package pojos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)  // gelen veride id var ama bu class ta olmadigi zaman kullaniyoruz

public class JsonPlaceHolderPojo {

    private Integer userId;
    private String title;
    private Boolean completed;

    public JsonPlaceHolderPojo() { // bos olan cunstr lazim olmazsa de-serilazition yapamayiz arka planda calisir
    }

    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) { // dolu const.
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}