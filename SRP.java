/*
Bad Example (SRP Violation)

class Student {

    String name;

    public Student(String name) {
        this.name = name;
    }

    void saveToDatabase() {
        System.out.println("Saving student...");
    }

    void generateReport() {
        System.out.println("Generating report...");
    }

    void sendEmail() {
        System.out.println("Sending email...");
    }
}
*/

// Followed by SRP
// Student class
class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

// Student data to DB
class StudentRepo {

    void save(Student student) {
        System.out.println(student.getName() + " saved to database");
    }
}

// Report generator
class ReportGenerator {

    void generate(Student student) {
        System.out.println("Report generated for " + student.getName());
    }
}

// Email
class SendEmail {

    void email(Student student) {
        System.out.println("Email sent to " + student.getName());
    }
}

// main
public class SRP {
    public static void main(String[] args) {

        Student student = new Student("Mahi");

        StudentRepo repo = new StudentRepo();

        ReportGenerator report = new ReportGenerator();

        SendEmail send = new SendEmail();

        repo.save(student);
        report.generate(student);
        send.email(student);
    }
}
