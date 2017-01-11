/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gpagame;
import java.util.*;

/**
 *
 * @author s531749
 */
public class User {
    private boolean isMale;
    private String firstName;
    private String lastName;
    private double GPA;
    private int intelligence;
    private int socialSkills;
    private int athleticism;
    private int trust;
    private int populatity;
    private int tiredness;
    private int semesterNumber;
    ArrayList<Semester> semseters = new ArrayList<Semester>();

    public User(boolean gender, String firstName, String lastName){
        this.isMale = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        tiredness = 0;
        
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public int getAthleticism() {
        return athleticism;
    }

    public void setAthleticism(int athleticism) {
        this.athleticism = athleticism;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPopulatity() {
        return populatity;
    }

    public void setPopulatity(int populatity) {
        this.populatity = populatity;
    }

    public int getSemesterNumber() {
        return semesterNumber;
    }

    public void setSemesterNumber(int semesterNumber) {
        this.semesterNumber = semesterNumber;
    }

    public int getSocialSkills() {
        return socialSkills;
    }

    public void setSocialSkills(int socialSkills) {
        this.socialSkills = socialSkills;
    }

    public int getTrust() {
        return trust;
    }

    public void setTrust(int trust) {
        this.trust = trust;
    }

    public int getTiredness() {
        return tiredness;
    }

    public void setTiredness(int tiredness) {
        this.tiredness = tiredness;
    }

    public boolean isIsMale() {
        return isMale;
    }

    public void setIsMale(boolean isMale) {
        this.isMale = isMale;
    }

    
    
}
