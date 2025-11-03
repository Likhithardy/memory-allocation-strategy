 
import java.util.Scanner;

class InvalidExperienceException extends  Exception{

    InvalidExperienceException(String message){
        super(message);
    }
    
}
class InvalidSkillException extends Exception{

    InvalidSkillException(String message){
        super(message);
    }
}

public class User_defined_execption{
    static void checkExperiance(int years) throws InvalidExperienceException {
        if(years<15){
            throw new InvalidExperienceException("Less Experiance");
        }
    }

    static void checkSkill(String skill) throws InvalidSkillException {
        if(skill.equalsIgnoreCase("Programmer")!=true){
            throw  new InvalidSkillException("Invalid Skill set");
        }
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter Your skill");
        String skill=input.nextLine();
        System.out.println("Enter your experiacne");
        int years = input.nextInt();
        try{
            checkExperiance(years);
            System.out.println(years+"Years of experiacne");
        }
        catch(Exception e){
            System.out.println("Execption "+e.getMessage());

        }
        try{
            checkSkill(skill);
            System.out.println(skill+"Skills you have");
        }
        catch(Exception e){
            System.out.println("Execption:"+e.getMessage());

        }
    }
}