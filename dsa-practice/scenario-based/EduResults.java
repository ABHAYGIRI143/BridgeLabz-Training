
class Student {
    int rollNo;
    String name;
    int marks;

    public Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }
}


public class EduResults {
    public static void main(String[] args) {

        Student[] students = {
            new Student(101, "Amit", 450),
            new Student(102, "Neha", 480),
            new Student(103, "Rahul", 450),
            new Student(104, "Sneha", 500),
            new Student(105, "Vikas", 480)
        };

        mergeSort(students, 0, students.length - 1);

        System.out.println("State-wise Rank List:");
        for (Student s : students) {
            System.out.println(s.rollNo + " " + s.name + " " + s.marks);
        }
    }
    
    public static void mergeSort(Student[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }
    
    public static void merge(Student[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        Student[] L = new Student[n1];
        Student[] R = new Student[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i].marks <= R[j].marks) {   // ⭐ stability line
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1)
            arr[k++] = L[i++];

        while (j < n2)
            arr[k++] = R[j++];
    }

}
