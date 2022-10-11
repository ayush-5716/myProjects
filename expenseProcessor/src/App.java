import java.util.stream.Stream;
import java.util.stream.*;
import java.io.File.*;
import java.nio.file.*;
class vars{
    int sum=0;
    int min= Integer.MAX_VALUE;
    int max=0;
    int counter=0;
}

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Hello, World!");
        Stream<String> st = Files.lines(Paths.get("C:/codes/expenseProcessor/dataFile.txt"));
        System.out.println(calcMean(st));
        st.close();

    }

    public static int sumAll(Stream<String> st){
        vars vars = new vars();
        st
        .map((x) -> x.split(" "))
        .map((x) -> Integer.parseInt(x[0].trim()))
        .forEach((x) -> vars.sum = vars.sum + x);

        return vars.sum;
    }

    public static double calcAverage(Stream<String> st){
        
        double avg = st
        .map((x) -> x.split(" "))
        .map((x) -> Integer.parseInt(x[0].trim()))
        .collect(Collectors.averagingInt(Integer::intValue));


        return avg;

    }

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
