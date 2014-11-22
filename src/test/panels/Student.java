package test.panels;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Created by Asus on 16.11.2014.
 */
@Entity
@Table(name="Student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="id")
    private BigInteger id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="email")
    private String email;
    
    @Column(name="course")
    private Integer course;

    @Column(name="grnum")
    private String grnum;
    
    @Column(name="faculty")
    private String faculty;
    
    @OneToOne(mappedBy="log")
    private LogStudent log;
    
    public Student() {}
    
    public Student(BigInteger id, String name, String email, Integer course, String grnum, String faculty) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
        this.grnum = grnum;
        this.faculty = faculty;
    }
    
    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public void setGrnum(String grnum) {
        this.grnum = grnum;
    }

    public String getGrnump() {
        return grnum;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty;
    }
    
    public void setLogStudent(LogStudent faculty) {
        this.log = log;
    }

    public LogStudent getLogStudent() {
        return log;
    }
}
