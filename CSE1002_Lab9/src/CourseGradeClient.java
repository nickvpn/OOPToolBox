public class CourseGradeClient {
    /**
     * Main method for testing CourseGrade class
     */
    public static void main(String[] args) {
        System.out.println("Test suite 1");
        CourseGrade cgrade1 = new CourseGrade();
        cgrade1.addQuiz(.5,100);
        cgrade1.addQuiz(.75,80);
        System.out.printf("Testing computing the weighted average (should be 88.0000): %.4f\n",cgrade1.computeWtdAvg());
        cgrade1.addQuiz(1.0, 80);
        System.out.printf("Testing computing the weighted average (should be 84.4444): %.4f\n", cgrade1.computeWtdAvg());
        cgrade1.removeLowest();
        System.out.printf("Testing computing the weighted average (should be 88.0000): %.4f\n", cgrade1.computeWtdAvg());
        System.out.println();

        System.out.println("Test suite 2");
        CourseGrade cgrade2 = new CourseGrade();
        cgrade2.addQuiz(.75,100);
        cgrade2.addQuiz(1.0,75);
        System.out.printf("Testing computing the weighted average (should be 85.7143): %.4f\n" , cgrade2.computeWtdAvg());
        cgrade2.addQuiz(.9, 75);
        System.out.printf("Testing computing the weighted average (should be 82.0755): %.4f\n", cgrade2.computeWtdAvg());
        cgrade2.addQuiz(1.0, 80);
        System.out.printf("Testing computing the weighted average (should be 81.5068): %.4f\n", cgrade2.computeWtdAvg());
        cgrade2.removeLowest();
        System.out.printf("Testing computing the weighted average (should be 83.9623): %.4f\n", cgrade2.computeWtdAvg());
        System.out.println();
    }
}