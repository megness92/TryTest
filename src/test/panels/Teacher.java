package test.panels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;

import org.hibernate.annotations.GenericGenerator;

/**
 * Created by Asus on 16.11.2014.
 */
@Entity
@Table(name="Teacher")
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="id")
    private BigInteger id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="email")
    private String email;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "teacher")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private List<Test> tests = new ArrayList<Test>();
    
    @OneToOne(mappedBy="log")
    private LogTeacher log;

    public Teacher() { }
    
    public Teacher(BigInteger id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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
    
    public void setLogTeacher(LogTeacher faculty) {
        this.log = log;
    }

    public LogTeacher getLogTeacher() {
        return log;
    }
}
