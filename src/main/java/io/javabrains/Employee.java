package io.javabrains;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name= "EMPLOYEE_DATA")
public class Employee {
    @Id
    @GeneratedValue
    private  int id;
    private String Name;
    private int age;
    // primary relation
    @OneToOne
    private AccessCard accessCard;
    @ManyToMany
    @JoinTable(name = "Email_Group_Subscriptions", joinColumns= @JoinColumn(name = "Employee_ID"),
    inverseJoinColumns = @JoinColumn(name = "Subscription_ID"))
    private List<EmailGroup> emailGroups= new ArrayList<>();

    public List<EmailGroup> getEmailGroups() {
        return emailGroups;
    }

//    public void setEmailGroups(List<EmailGroup> emailGroups) {
//        this.emailGroups = emailGroups;
//    }

    public void addEmailSubscription(EmailGroup emailGroup){
        this.emailGroups.add(emailGroup);
    }
    // lazy fetching by default
    @OneToMany (mappedBy = "employee", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<PayStub> payStub = new ArrayList<PayStub>();

    public List<PayStub> getPayStub() {
        return payStub;
    }

    public void addPayStub(PayStub payStub) {
        this.payStub.add(payStub);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", age=" + age +
                ", accessCard=" + accessCard +
                '}';
    }

    public AccessCard getAccessCard() {
        return accessCard;
    }

    public void setAccessCard(AccessCard accessCard) {
        this.accessCard = accessCard;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
