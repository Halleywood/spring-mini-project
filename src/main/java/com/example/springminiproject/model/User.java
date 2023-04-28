package com.example.springminiproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String userName;
    @Column(unique = true)
    private String emailAddress;
    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    //.....................................................................CONSTRUCTORS
    public User() {}

    public User(Long id, String userName, String emailAddress, String password) {
        this.id = id;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.password = password;
    }
    //............................................................ONE USER TO ONE PROFILE
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private UserProfile userProfile;

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
    //............................................................ONE USER CAN CREATE ONE CHICKEN
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private Chicken chicken;

    public Chicken getChicken() {
        return chicken;
    }

    public void setChicken(Chicken chicken) {
        this.chicken = chicken;
    }

    //..........................................................MANY USERS CAN LIKE MANY CHICKENS
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name ="chicken_likes",
            joinColumns=
            @JoinColumn(name="user_id"),
            inverseJoinColumns=
            @JoinColumn(name="chicken_id"))
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Chicken> chickenLikes;

    public List<Chicken> getChickenLikes() {
        return chickenLikes;
    }

    public void setChickenLikes(List<Chicken> chickenLikes) {
        this.chickenLikes = chickenLikes;
    }
//..........................................................GETTERS/SETTERS/TO STRING

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
