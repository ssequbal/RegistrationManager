package assgn_2_group_13;


/**
 * Registration details of a student in course.
 *
 * @author Jubaer Ahmed Bhuiyan
 * @version October 12, 2021
 */
public class Registration
{
    // instance variables.
    private final String course;
    private final int section;
    private final int slot;
    private final String student;
    private final String professor;

    /**
     * A record of student enrollment.
     * @param course Name of the course.
     * @param section The section of the given course.
     * @param slot The time slot of the course.
     * @param student The name of the student.
     * @param professor The name of the professor of the course.
     */
    public Registration(String course, int section, int slot,
                        String student,String professor)
    {
        
        this.section = section;
        this.slot = slot;
        this.course = course;
        this.student = student;
        this.professor = professor;

    }
    
    /**
    * Return the name of the course.
    */
    public String getCourse()
    {return course;}
    
    /**
    * Return the section.
    */
    public int getSection()
    {return section;}
    
    /**
    * Return the time slot.
    */
    public int getSlot()
    {return slot;}
    
    /**
    * Return the student's name.
    */
    public String getStudent()
    {return student;}
    
    /**
    * Return the professor's name.
    */
    public String getProfessor()
    {return professor;}
    
    /**
    * Verify if the courses are the courses are same as required.
    * @return true if matches, false if don't.
    */
    private boolean verifyCourseNumber(String course)
    { if (course.equals("COMP 1501") || course.equals("ENGL 2201") || course.equals("CHEM 3060") || course.equals("PHYS 2344") || course.equals("ENGL 2005") || course.equals("COMP 2704") || course.equals("PHYS 2377") || course.equals("CHEM 4927") || course.equals("COMP 3444")) {
        return true;
    } return false;
    }
    
    /**
    * Verify if the sections are between 0 to 2.
    * @return true if < 0, false otherwise.
    */
    private boolean verifySection(int section)
    { if (section < 3) {
        return true;}
        return false;
    }
    
    /**
    * Verify if the time slot is valid.
    * @return true if slot is between 12 to 25, false otherwise.
    */
    private boolean verifySlot (int slot)
    { if ((slot < 26) && (slot > 11)) {
        return true;}
        return false;
    }
    
    /**
    * Print all the information about the enrollment record.
    * @return A string of each details in separate lines.
    */
    public void printInfo()
    {
        
        Registration person = new Registration(course, section, slot, student, professor);
        System.out.println(person.student);
        System.out.println(person.course);
        System.out.println(person.section);
        System.out.println(person.slot);
        System.out.println(person.professor);
    }

}
