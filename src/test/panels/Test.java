package test.panels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigInteger;

import org.hibernate.annotations.GenericGenerator;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;

/**
 * Created by Asus on 16.11.2014.
 */
@Entity
@Table(name="Test")
public class Test implements Serializable {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="id")
    private BigInteger id;    
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "test")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private List<Question> questions = new ArrayList<Question>();
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "author")
    private String author;
    
    @Column(name = "theme")
    private String theme;
    
    @Column(name = "repeatPass")
    private Integer repeatPass;
    
    @Column(name = "passScore")
    private Integer passScore;
    
    @Column(name = "date")
    private String date;
    
    @ManyToOne
    @JoinColumn(name="teacher_id", nullable = false, insertable = true, updatable = true)
    private Teacher teacher;
    
    @OneToOne(mappedBy="test")
    private Statistics stat;
        
    public Test() {}
    
    public Test(BigInteger id, List<Question> questions, String title, String author, String theme, Integer repeatPass, Integer passScore, String date) {
        this.id = id;
        this.questions = questions;
        this.title = title;
        this.theme = theme;
        this.repeatPass = repeatPass;
        this.passScore = passScore;
        this.date = date;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getId() {
        return id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getNumberOfQuestions() {
        return questions.size();
    }

    public Question getQuestion(int index) {
        return questions.get(index);
    }

    public void setQuestion(int index, Question question) {
        questions.set(index, question);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Integer getRepeatPass() {
        return repeatPass;
    }

    public void setRepeatPass(Integer repeatPass) {
        this.repeatPass = repeatPass;
    }

    public Integer getPassScore() {
        return passScore;
    }

    public void setPassScore(Integer passScore) {
        this.passScore = passScore;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public Statistics getStatistics() {
        return stat;
    }

    public void setStatistics(Statistics stat) {
        this.stat = stat;
    }
    
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
