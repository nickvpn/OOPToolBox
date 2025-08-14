import java.util.ArrayList;
/**
 * Represents a student's grade in a course
 *
 * @author (CSE 1002)
 * @version (2/11/2025)
 */
public class CourseGrade
{
    // instance variable - list of weighted quiz grades
    private ArrayList<Assignment> quizzes;
    /**
     * Constructor for objects of class CourseGrade
     */
    public CourseGrade()
    {
        // initialize the ArrayList quizzes
        this.quizzes = new ArrayList<Assignment>();
    }

    /**
     * Add a quiz grade
     *
     */
    public void addQuiz(double wt, double grd)
    {
        // added method here
        Assignment assignment = new Assignment(wt, grd);
        quizzes.add(assignment);

    }

    /**
     * Compute the weighted average of quizzes
     *
     * @return weighted average of quizzes
     */
    public double computeWtdAvg() {
        // added method here
        double weightAverage = 0;
        double weights = 0;
        for(int i = 0; i < quizzes.size(); i++){
            weightAverage += quizzes.get(i).getWeightedGrade();
            weights += quizzes.get(i).getWeight();
        }
        double computeWtdAvg = weightAverage / weights;
        return computeWtdAvg;

    }

    /**
     * Remove lowest grade in quiz list
     */
    public void removeLowest() {
        // added method here
        int temp = 0;
        for(int i = 0; i < quizzes.size()-1; i++){
            if(quizzes.get(i).getGrade() < quizzes.get(i+1).getGrade()){
                temp = i;
            }
            if(quizzes.get(i).getGrade() == quizzes.get(i+1).getGrade()) {
                if (quizzes.get(i).getWeight() > quizzes.get(i + 1).getWeight()) {
                    quizzes.remove(i);
                } else {
                    quizzes.remove(i + 1);
                }
            }
        }
        quizzes.remove(temp);
    }
}