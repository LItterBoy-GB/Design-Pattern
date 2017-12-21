package FactoryPattern;

public class Main {
    public static void main(String args[]){
        //制造一名学生
        People student = FactoryPeople.buidlerPeople(Student.class);
        student.say();
        //制造一名教师
        People teacher = FactoryPeople.buidlerPeople(Teacher.class);
        teacher.say();
    }
}
