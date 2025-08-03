public class MVCTest {
    public static void main(String[] args) {
        // Create model
        Student student = new Student("Arhan Dasmunshi", "22053146", "A");

        // Create view
        StudentView view = new StudentView();

        // Create controller
        StudentController controller = new StudentController(student, view);

        // Initial display
        controller.updateView();

        // Update student details
        controller.setStudentName("Arhan D.");
        controller.setStudentGrade("A+");

        // Display updated student info
        controller.updateView();
    }
}
