import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class Task3 {
    public static void main(String[] args){
        Scanner obj=new Scanner(System.in);
        List<Double> marks=new ArrayList<>();
        int a ;
        a=1;
        System.out.println("Enter your marks obtained(out of 100):");
        while(a==1){
            System.out.print("Mark=>");
            Double note=obj.nextDouble();
            marks.add(note);
            System.out.println("do you want to add another mark? type 1 if yes and 0 if no:");
            a=obj.nextInt();
        }
        double averageP;
        double sum=0;
        for(int i=0;i<marks.size();i++){
            sum=sum+marks.get(i);
        }
        averageP=sum/marks.size();
        char grad;
        if(averageP>=90){
            grad='A';
        }
        else{
            if(averageP>=80 && averageP<=89){
                grad='B';
            }
            else{
                if(averageP>=70 && averageP<=79)
                    grad='C';
                else{
                    if(averageP>=60 && averageP<=79){
                        grad='D';
                    }
                    else{
                        grad='F';
                    }
                }
            }
        }
        System.out.println("Your marks:");
        marks.forEach(mark->{
            System.out.print(mark+"% , ");
        });
        System.out.println("your average pourcentage :"+averageP+"%");
        System.out.println("your grad :"+grad);
    }
}
