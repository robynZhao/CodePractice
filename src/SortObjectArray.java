import java.util.*;

//Gives an array of object and asks to order based on different keys.
// with using Lambda expression
// without using Lambda expression

public class SortObjectArray {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student("Jon", 22, 1001));
        studentList.add(new Student("Steve", 19, 1003));
        studentList.add(new Student("Kevin", 23, 1005));
        studentList.add(new Student("Ron", 20, 1010));
        studentList.add(new Student("Lucy", 18, 1111));

        System.out.println("Before Sorting the student data:");
        studentList.forEach((s)->System.out.println(s));
        System.out.println("----------------------");

        lambdaExpression(studentList);
        System.out.println("After Sorting the student data:");
        studentList.forEach((s)->System.out.println(s));
        System.out.println("----------------------");
    }

    public static void lambdaExpression (List<Student> input) {
        //Lambda expression for sorting by age
        input.sort((Student s1, Student s2)->s1.getAge()-s2.getAge());
        //java 8 forEach for printing the list
//        System.out.println("Lambda expression for sorting by age:");
//        input.forEach((s)->System.out.println(s));
//        System.out.println("======================");

        //Lambda expression for sorting the list by student name
//        input.sort((Student s1, Student s2)->s1.getName().compareTo(s2.getName()));
//        System.out.println("Lambda expression for sorting the list by student name:");
//        input.forEach((s)->System.out.println(s));
//        System.out.println("======================");


        //Lambda expression for sorting the list by student id
//        input.sort((Student s1, Student s2)->s1.getId()-s2.getId());
//        System.out.println("Lambda expression for sorting the list by student id:");
//        input.forEach((s)->System.out.println(s));
//        System.out.println("*********************");
    }


    public void noLambdaExpression (List<Student> input) {
        //Lambda expression for sorting by age
        input.sort((Student s1, Student s2)->s1.getAge()-s2.getAge());
        //java 8 forEach for printing the list
        System.out.println("No Lambda expression for sorting by age:");
        input.forEach((s)->System.out.println(s));
        System.out.println("----------------------");


        //Lambda expression for sorting the list by student name
        input.sort((Student s1, Student s2)->s1.getName().compareTo(s2.getName()));
        System.out.println("No Lambda expression for sorting the list by student name:");
        input.forEach((s)->System.out.println(s));
        System.out.println("----------------------");


        //Lambda expression for sorting the list by student id
        input.sort((Student s1, Student s2)->s1.getId()-s2.getId());
        System.out.println("No Lambda expression for sorting the list by student id:");
        input.forEach((s)->System.out.println(s));
        System.out.println("*********************");
    }
}

class Student {
    String name;
    int age;
    int id;

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getId() {
        return id;
    }
    Student(String n, int a, int i){
        name = n;
        age = a;
        id = i;
    }
    @Override public String toString() {
        return ("Student[ "+"Name:"+this.getName()+
                " Age: "+ this.getAge() +
                " Id: "+ this.getId()+"]");
    }
}
