//Imports
import java.util.stream.Stream;
import java.util.stream.*;
import java.io.File.*;
import java.nio.file.*;

//Value storage class, because using streams
class vars{
    int sum=0;
    int min= Integer.MAX_VALUE;
    int max=0;
    int counter=0;
}


public class App {
    
    //Main function
    public static void main(String[] args) throws Exception {

        System.out.println("Hello, World!");
        Stream<String> st = Files.lines(Paths.get("C:/codes/expenseProcessor/dataFile.txt"));
        System.out.println(calcMean(st));               //can change method call here
        st.close();

    }

    //Function to calculate total expenditure
    public static int sumAll(Stream<String> st){
        
        vars vars = new vars();
        st
        .map((x) -> x.split(" "))
        .map((x) -> Integer.parseInt(x[0].trim()))
        .forEach((x) -> vars.sum = vars.sum + x);

        return vars.sum;
    }

    //Function to calculate Average expenditure
    public static double calcAverage(Stream<String> st){
        
        double avg = st
        .map((x) -> x.split(" "))
        .map((x) -> Integer.parseInt(x[0].trim()))
        .collect(Collectors.averagingInt(Integer::intValue));


        return avg;

    }

    //Function to calculate the mean of all the expenditues
    public static float calcMean(Stream<String> st){
        
        vars sum = new vars();
        st
        .map((x) -> x.split(" "))
        .map((x) -> Integer.parseInt(x[0].trim()))
        .forEach((x) -> {
            sum.counter++;
            if(x<sum.min){
                sum.min = x;
            }
            if(x>sum.max) sum.max = x; 
        });

        float mean = (sum.min + sum.max)/sum.counter;
        return mean;    
    }

    
}
