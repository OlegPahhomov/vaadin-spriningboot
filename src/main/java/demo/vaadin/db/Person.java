package demo.vaadin.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String fullName;
    private String examName;
    private String examCode;
    private int score;

    public Person() {
    }

    public Person(String fullName, String examName, String examCode, int score) {
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
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
