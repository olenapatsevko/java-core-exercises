import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Questions {

    ArrayList <String> firstPart = new ArrayList<String>();
    ArrayList<String> secondPart= new ArrayList<String>();
    ArrayList <String> thirdPart = new ArrayList<String>();
    ArrayList<ArrayList<String>> arrayLists =  new ArrayList<ArrayList<String>>();
    int numsOfQuestions;


    public Questions() {}

    public void init(){
        Scanner in = new Scanner(System.in);
        System.out.println("Put the number of questions each list");
        this.numsOfQuestions = in.nextInt();


        for(int i = 0; i< this.getNumsOfQuestions(); i++ ){

            System.out.println("Put the question from the first part ");
            this.firstPart.add(in.next());
        }
        for(int i = 0; i< this.getNumsOfQuestions(); i++ ){

            System.out.println("Put the question from the second part ");
            this.secondPart.add(in.next());
        }
        for(int i = 0; i< this.getNumsOfQuestions(); i++ ){

            System.out.println("Put the question from the third part ");
            this.thirdPart.add(in.next());
        }
        this.divide();
    }


    public void divide (){

        final Random random = new Random();
        for (int i = 0 ; i < this.getNumsOfQuestions(); i++){
            this.arrayLists.add(new ArrayList<String>(){
                {
                    add(firstPart.remove(random.nextInt(firstPart.size())));
                    add(secondPart.remove(random.nextInt(secondPart.size())));
                    add(thirdPart.remove(random.nextInt(thirdPart.size())));
                } });

        }

     //   System.out.println(arrayLists);
    }

    public String getRandomElement(List<String> list)
    {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }



    public ArrayList<String> getThirdPart() {
        return thirdPart;
    }

    public void setThirdPart(ArrayList<String> thirdPart) {
        this.thirdPart = thirdPart;
    }

    public ArrayList<String> getSecondPart() {
        return secondPart;
    }

    public void setSecondPart(ArrayList<String> secondPart) {
        this.secondPart = secondPart;
    }

    public ArrayList<String> getFirstPart() {
        return firstPart;
    }

    public void setFirstPart(ArrayList<String> firstPart) {
        this.firstPart = firstPart;
    }

    public int getNumsOfQuestions() {
        return numsOfQuestions;
    }

    public void setNumsOfQuestions(int numsOfQuestions) {
        this.numsOfQuestions = numsOfQuestions;
    }
}
