/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gpagame;

/**
 *
 * @author s531749
 */
public class AvailableExtraCurricular {
  private String name;
  private int requiredIntelligence;
  private int requiredSocialSkills;
  private int requiredAthleticism;
  private int classDificulty;


    public AvailableExtraCurricular(String name, int requiredIntelligence, int requiredSocialSkills, int requiredAthleticism, int classDificulty) {
        this.name = name;
        this.requiredIntelligence = requiredIntelligence;
        this.requiredSocialSkills = requiredSocialSkills;
        this.requiredAthleticism = requiredAthleticism;
        this.classDificulty = classDificulty;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRequiredAthleticism() {
        return requiredAthleticism;
    }

    public void setRequiredAthleticism(int requiredAthleticism) {
        this.requiredAthleticism = requiredAthleticism;
    }

    public int getRequiredIntelligence() {
        return requiredIntelligence;
    }

    public void setRequiredIntelligence(int requiredIntelligence) {
        this.requiredIntelligence = requiredIntelligence;
    }

    public int getRequiredSocialSkills() {
        return requiredSocialSkills;
    }

    public void setRequiredSocialSkills(int requiredSocialSkills) {
        this.requiredSocialSkills = requiredSocialSkills;
    }

    public int getClassDificulty() {
        return classDificulty;
    }

    public void setClassDificulty(int classDificulty) {
        this.classDificulty = classDificulty;
    }

    
  

}
