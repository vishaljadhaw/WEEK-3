class Student {
    int rollNumber;
    String name;
    int age;
    String grade;
    Student next;

    public Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentRecordManagement {
    private Student head;

    // Add a new student record at the beginning
    public void addStudentAtBeginning(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    // Add a new student record at the end
    public void addStudentAtEnd(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
        } else {
            Student current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newStudent;
        }
    }

    // Add a new student record at a specific position
    public void addStudentAtPosition(int rollNumber, String name, int age, String grade, int position) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (position == 0) {
            newStudent.next = head;
            head = newStudent;
        } else {
            Student current = head;
            for (int i = 0; i < position - 1; i++) {
                if (current != null) {
                    current = current.next;
                } else {
                    throw new IndexOutOfBoundsException("Position out of bounds");
                }
            }
            newStudent.next = current.next;
            current.next = newStudent;
        }
    }

    // Delete a student record by Roll Number
    public void deleteStudentByRollNumber(int rollNumber) {
        if (head == null) return;
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Student current = head;
        while (current.next != null && current.next.rollNumber != rollNumber) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Search for a student record by Roll Number
    public Student searchStudentByRollNumber(int rollNumber) {
        Student current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Display all student records
    public void displayAllStudents() {
        Student current = head;
        while (current != null) {
            System.out.println("Roll Number: " + current.rollNumber + ", Name: " + current.name + 
                               ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }

    // Update a student's grade based on their Roll Number
    public void updateStudentGrade(int rollNumber, String newGrade) {
        Student student = searchStudentByRollNumber(rollNumber);
        if (student != null) {
            student.grade = newGrade;
        }
    }

    public static void main(String[] args) {
        StudentRecordManagement srm = new StudentRecordManagement();
        
        srm.addStudentAtEnd(1, "John Doe", 18, "A");
        srm.addStudentAtBeginning(2, "Jane Smith", 19, "B");
        srm.addStudentAtPosition(3, "Alice Johnson", 20, "C", 1);

        System.out.println("All Students:");
        srm.displayAllStudents();

        System.out.println("\nSearching for Student with Roll Number 2:");
        Student student = srm.searchStudentByRollNumber(2);
        if (student != null) {
            System.out.println("Found: Roll Number: " + student.rollNumber + ", Name: " + student.name + 
                               ", Age: " + student.age + ", Grade: " + student.grade);
        } else {
            System.out.println("Student not found");
        }

        System.out.println("\nUpdating Grade for Roll Number 3:");
        srm.updateStudentGrade(3, "A+");
        srm.displayAllStudents();

        System.out.println("\nDeleting Student with Roll Number 1:");
        srm.deleteStudentByRollNumber(1);
        srm.displayAllStudents();
    }
}
