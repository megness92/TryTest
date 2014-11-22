package test.panels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

/**
 * Created by Asus on 16.11.2014.
 */
@Entity
@Table(name="Answer")
public class Answer implements Serializable {
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="id")
    private BigInteger id;
    
    @Column(name="isRight")
    private Integer isRight;
    
    @Column(name="text")
    private String text;
    
    @ManyToOne
    @JoinColumn(name="question_id", nullable = false, insertable = true, updatable = true)
    private Question question;
    
    public Answer() {}
    
    public Answer(BigInteger id, Integer isRight, String text) {
        this.id = id;
        this.isRight = isRight;
        this.text = text;
    }    

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getId() {
        return id;
    }    
    
    public void setIsRight(Integer isRight) {
        this.isRight = isRight;
    }
    
    public Integer getIsRight() {
        return isRight;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public String getText() {
        return text;
    }
    
    public void setQuestion(Question question) {
        this.question = question;
    }
    
    public Question getQuestion() {
        return question;
    }
}
