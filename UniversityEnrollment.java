import java.util.*;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

public class UniversityEnrollment {
    private static final int COURSE_CAPACITY = 2;
    private static int enrolledStudents = 0;

    public static void enroll(String course, String prerequisite, boolean prerequisiteCompleted)
            throws CourseFullException, PrerequisiteNotMetException {

        if (enrolledStudents >= COURSE_CAPACITY) {
            throw new CourseFullException("CourseFullException - No seats available in " + course + ".");
        }

        if (!prerequisiteCompleted) {
            throw new PrerequisiteNotMetException(
                    "PrerequisiteNotMetException - Complete " + prerequisite + " before enrolling in " + course + ".");
        }

        enrolledStudents++;
        System.out.println("Enrolled in " + course + " successfully!");
    }

    public static void main(String[] args) {
        try {
            enroll("Advanced Java", "Core Java", false);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
