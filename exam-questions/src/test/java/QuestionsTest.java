import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class QuestionsTest {
    private Questions questions = new Questions();


    @Test
    void divide() {
        questions.setFirstPart(new ArrayList<String>(){{
            add("111");
            add("222");
            add("333");
        }});

        questions.setSecondPart(new ArrayList<String>(){{
                add("444");
                add("555");
                add("666"); }});

        questions.setThirdPart(new ArrayList<String>(){{
            add("777");
            add("888");
            add("999"); }});
        questions.divide();
        assertEquals(3, questions.arrayLists.size());

    }




    @org.junit.jupiter.api.Test
    void getFirstPart() {
        ArrayList<String > expected = new ArrayList<String>(){{
            add("111");
            add("222");
            add("333");
        }};
        questions.setFirstPart(new ArrayList<String>(){{

            add("111");
            add("222");
            add("333");
        }

        });


        ArrayList<String >actual  =  questions.getFirstPart();
        assertEquals(expected,actual);

    }

    @org.junit.jupiter.api.Test
    void setFirstPart() {
        questions.setFirstPart(new ArrayList<String>(){{

            add("111");
            add("222");
            add("333");
        }

        });

        ArrayList<String > expected = new ArrayList<String>(){{
            add("111");
            add("222");
            add("333");
        }};

        ArrayList <String> actual = questions.getFirstPart();
        assertEquals(expected,actual);


    }

    @org.junit.jupiter.api.Test
    void getNumsOfQuestions() {
        questions.setNumsOfQuestions( 12);
        int expected = 12;
        int actual = questions.getNumsOfQuestions();
        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void setNumsOfQuestions() {
        questions.setNumsOfQuestions( 12);
        int expected = 12;
        int actual = questions.getNumsOfQuestions();
        assertEquals(expected,actual);

    }
}