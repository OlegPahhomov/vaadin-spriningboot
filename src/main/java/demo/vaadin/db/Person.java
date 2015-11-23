package demo.vaadin.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @NotNull(message = "Name is required")
    @Size(min = 3, max = 40, message = "name must be longer than 3 and less than 40 characters")
    private String fullName;
    @NotNull(message = "Exam name is required")
    private String examName;
    @NotNull(message = "Enter code: xxx-zzz")
    @Size(min = 7, max = 7)
    private String examCode;
    @NotNull(message = "Score is required")
    @Size(max = 3)
    private String score;

    public Person() {
    }

    public Person(String fullName, String examName, String examCode, String score) {
        this.fullName = fullName;
        this.examName = examName;
        this.examCode = examCode;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamCode() {
        return examCode;
    }

    public void setExamCode(String examCode) {
        this.examCode = examCode;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", examName='" + examName + '\'' +
                ", examCode='" + examCode + '\'' +
                ", score=" + score +
                '}';
    }
}
