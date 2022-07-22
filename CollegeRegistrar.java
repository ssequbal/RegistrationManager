package assgn_2_group_13;

import java.util.ArrayList;
/**
 * A class CollegeRegistrar that keeps and accesses all the informations on
 * different enrollment records.
 *
 * @author Jubaer Ahmed Bhuiyan, Fatiha Islam Nowrin and Saad Equbal Syed.
 * @version October 13,2021
 */
public class CollegeRegistrar
{
    private ArrayList<Registration> courseRegistrations;

    /**
     * Constructor for objects of class CollegeRegistrar
     */
    public CollegeRegistrar()
    {
        // initialise instance variables
        courseRegistrations = new ArrayList<>();

    }

    /**
     * Add the enrollment records in the given registrations to the current list.
     *
     * @ param  newRegistration A new record of registration informations.
     */
    public void addRegistration(Registration newRegistration)
    {
        // put your code here
        courseRegistrations = new ArrayList<Registration>();
        courseRegistrations.add(newRegistration);
    }
    
    /**
    *prints for all registrations the corresponding info.
    */
    public void printAllRegistrations()
    {
        courseRegistrations.forEach(Registration ->
        {Registration.printInfo();}
        );
    }
    
    /**
    * prints all classes (course number and professor) in which the
    * student is enrolled
    * @param student The name of the student.
    * @return course number and name of the professor teaching the course.
    */
    public void printClassesForStudent(String student)
    {
        courseRegistrations.stream()
                .filter(Registration -> student.equals(Registration.getStudent()))
                .forEach(Registration -> System.out.println(Registration.getCourse() + Registration.getProfessor()));
    }
    
    /**
    * prints all classes (course number and section) taught
    * by professor and taken by student.
    */
    public void printClassesForStudentByProfessor(String student, String professor)
    {
        courseRegistrations.stream()
                .filter(Registration -> student.equals(Registration.getStudent()) && professor.equals(Registration.getProfessor()))
                .forEach(Registration -> System.out.println("Course Number: " + Registration.getCourse()+ "\nSection: " + Registration.getSection()));

    }
    
    /**
    * prints all classes (course number and section) taken
    * by student in timeSlot.
    */
    public void printClassesForStudentInSlot(String student, int timeSlot)
    {
        courseRegistrations.stream()
                .filter(Registration -> student.equals(Registration.getStudent()) && timeSlot == Registration.getSlot())
                .forEach(Registration -> System.out.println("Course Number: " + Registration.getCourse() + "\nASection: " + Registration.getSection()));
    }

    /**
    * get the number of students registered in classNumber.
    */
    public int getRegistrationsInClass(String classNumber)
    {
        long counts = courseRegistrations.stream()
                .filter(Registration -> classNumber.equals(Registration.getCourse()))
                .count();
        int num = Math.toIntExact(counts);

        return num;
    }

    /**
    * get the number of students enrolled in classNumber and slot.
    */
    public int getRegistrationsInClass(String classNumber, int timeSlot)
    {
        long counts = courseRegistrations.stream()
                .filter(Registration -> classNumber.equals(Registration.getCourse()) && timeSlot == Registration.getSlot())
                .count();
        int num = Math.toIntExact(counts);

        return num;
    }

    /**
    * get the number of students taking classes in timeSlot.
    */
    public int studentsTakingClassesInSlot(int timeSlot)
    {
        long counts = courseRegistrations.stream()
                .filter(Registration -> timeSlot == Registration.getSlot())
                .count();
        int num = Math.toIntExact(counts);

        return num;
    }

    /**
    * drops class classNumber for student.
    */
    public void dropClassForStudent(String classNumber, String student)
    {
        courseRegistrations.removeIf(Registration ->
                student.equals(Registration.getStudent()) && classNumber.equals(Registration.getCourse()));
    }
    
    /**
    * drops all classes for the given student.
    */
    public void dropAllClassesForStudent(String student)
    {
         courseRegistrations.removeIf(Registration -> student.equals(Registration.getStudent()));
    }
    
    /** This method creates 30 arbitrary registrations for testing
    *
    */
    public void populateRegistrations() throws Exception
    {
        List<String> List1 = new ArrayList<String>();
        Collections.addAll(List1,"COMP 1501", "ENGL 2201", "CHEM 3060", "PHYS 2344", "ENGL 2005", "COMP 2704", "PHYS 2377", "CHEM 4927", "COMP 3444");
        int index=0;
        while(index<30){
            String course = List1.get(index%List1.size());
            int slot = index%9 + 12;
            int section = index%2;
            String student = "student" + index%10; // 10 students
            String professor = "professor" + index%3; //3 professors
            courseRegistrations.add(new Registration(course,section,slot,student,professor));
            index++;
        }
    }
}
