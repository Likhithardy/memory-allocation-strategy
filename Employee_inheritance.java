
class Employee {

    String name;
    int id;
    float salary;

    Employee(String name, int id, float salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void Displaydetails() {
        System.out.println(" Id: " + id + " Name: " + name + " Salary: " + salary);
    }

    float calculateBonus() {
        return salary * 0.05f;
    }

    void generateReport() {
        Displaydetails();
        System.out.println("Bonus:" + calculateBonus());

    }
}

class Manager extends Employee {

    int teamsize;

    Manager(String name, int id, float salary, int teamsize) {
        super(name, id, salary);
        this.teamsize = teamsize;

    }

    @Override
    void Displaydetails() {
        super.Displaydetails();
        System.out.println("Team size:  " + teamsize);
    }

    @Override
    float calculateBonus() {
        return salary * 0.05f + teamsize * 1000;
    }

}

class Developer extends Employee {

    String Programming_lang;

    Developer(String name, int id, float salary, String Programming_lang) {
        super(name, id, salary);
        this.Programming_lang = Programming_lang;
    }

    @Override
    void Displaydetails() {
        super.Displaydetails();
        System.out.println("Language:" + Programming_lang);
    }

}

class intern extends Employee {

    int duration;

    intern(String name, int id, float salary, int duration) {
        super(name, id, salary);
        this.duration = duration;
    }

    @Override
    void Displaydetails() {
        super.Displaydetails();
        System.out.println("Duration :" + duration + "Months");
    }
}

public class Employee_inheritance {

    public static void main(String[] args) {
        Manager m = new Manager("Pavan", 7109, 90000, 5);
        Developer d = new Developer("Sai", 7110, 7000, "java");
        m.generateReport();
        System.out.println("-----------");
        d.generateReport();
        System.out.println("-----------");

    }
}
