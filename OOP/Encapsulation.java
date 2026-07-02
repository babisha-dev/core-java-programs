package OOP;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
class Student{
    private int id;
    private String name;
    private List<Integer> grades;

    public Student(int id, String name,List<Integer> grades){
        this.id=id;
        this.name=name;
        this.grades=grades;
    }

    public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        if(name !=""){
        this.name=name;
        }
        else{
            System.out.println("Name cannot be empty");
        }
    }
    public void setGrades(List<Integer> grade){
        for(Integer g: grade){
              if(g>100 && g<0){
                System.out.println("values range must be 0 to 100");
              }
        }
        this.grades=grade;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public List<Integer> getGrade(){
        return grades;
    }
public void addGrade(Integer grade){
      grades.add(grade);
      System.out.println(grades);
}
public double getAverage(){
    double sum=0;
    for(Integer g:grades){
      sum+=g;
    }

    return sum/5;
} 
}

class Course{
    private int maxCapacity=100;
    private List<Student> enrolledStudents=new ArrayList<>();
    
    public void enrollStudent(Student s){
        if(enrolledStudents.size()<maxCapacity){
        enrolledStudents.add(s);
        System.out.println("Student Enrolled: "+s.getName());
        }
        else
            System.out.println("Slots are filled");
    }

    public void getTopPerformer(){
        double avg=0;
        for(Student s:enrolledStudents){
          if(s.getAverage()>avg){
             avg=s.getAverage();
          }
        }
        System.out.println("Top Performer Avg: "+avg);
    }
    public void classAverage(){
        double sum=0;
        for(Student s:enrolledStudents){
           sum+=s.getAverage();
        }
        System.out.println("class Average: "+ sum/enrolledStudents.size());
    }
    public void generateReport(){
        HashMap<Character,Integer> hm=new HashMap<>();
        for(Student s:enrolledStudents){
         double avg=   s.getAverage();
         if(avg>80){
            hm.put('A',hm.getOrDefault('A', 0)+1);
         }
          else if(avg>70){
            hm.put('B',hm.getOrDefault('B', 0)+1);
         }
          else if(avg>60){
            hm.put('C',hm.getOrDefault('C', 0)+1);
         }
        }
                 System.out.println(hm);

    }
}
public class Encapsulation {
    public static void main(String[] args) {
        Student s1=new Student(1, "ajay", new ArrayList<>(List.of(90,90,98,97,96))); 
        Student s2=new Student(2, "vijay", new ArrayList<>(List.of(60,50,48,53,66)));
        Student s3=new Student(3, "nijay", new ArrayList<>(List.of(90,92,93,95,77)));
        Student s4=new Student(4, "kajay", new ArrayList<>(List.of(80,81,78,87,86)));
        Student s5=new Student(1, "ajay", new ArrayList<>(List.of(67,65,78,67,77)));
       Course c1=new Course();
      c1.enrollStudent(s1);
      c1.enrollStudent(s2);
      c1.enrollStudent(s3);
      c1.enrollStudent(s4);
      c1.enrollStudent(s5);
      c1.classAverage();
     c1.generateReport();
     c1.getTopPerformer();

    }
    
}
