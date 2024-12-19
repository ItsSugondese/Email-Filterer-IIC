import emailcollection.FirstYearMailCollection;
import emailcollection.PeopleWhoFilled;
import emailcollection.SecondYearMailCollection;
import emailcollection.ThirdYearMailCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FypEmailFilterer {
    public static  String myMail = "np05cp4a210083@iic.edu.np";
    public static void main(String[] args) {
        FypEmailFilterer filterer = new FypEmailFilterer();

        List<String> peopleWhoFilled = Arrays.stream(PeopleWhoFilled.peopleWhoFilled(myMail).toLowerCase().split("\n")).toList();

        List<String> firstYearMail = Arrays.stream(FirstYearMailCollection.firstYearMail().toLowerCase().split("\n")).toList();
        List<String> secondYearMail = Arrays.stream(SecondYearMailCollection.secondYearMail().toLowerCase().split("\n")).toList();
        List<String> thirdYearMail = Arrays.stream(ThirdYearMailCollection.thirdYearMail().toLowerCase().split("\n")).toList();

        List<String> whole = new ArrayList<>();
        whole.addAll(firstYearMail);
        whole.addAll(secondYearMail);
        whole.addAll(thirdYearMail);


        filterer.printFromList(whole);
//        System.out.println(filterer.totalFilledPercentage(whole.size(), peopleWhoFilled.size()));
//        System.out.println(filterer.filledDetails(firstYearMail, secondYearMail, thirdYearMail,peopleWhoFilled));

//        filterer.printFromList(filterer.secondYearNotFiller(secondYearMail, peopleWhoFilled));
    }

    private Integer totalMail(List<String> whole){
        return whole.size();
    }

    private String filledDetails(List<String> firstYear, List<String> secondYear, List<String> thirdYear, List<String> filledPeople){
        Integer byFirstYear = (firstYear.stream().filter(e -> filledPeople.contains(e)).collect(Collectors.toList())).size();
        Integer bySecondYear = (secondYear.stream().filter(e -> filledPeople.contains(e)).collect(Collectors.toList())).size();
        Integer byThirdYear = (thirdYear.stream().filter(e -> filledPeople.contains(e)).collect(Collectors.toList())).size();
        return "First Year : " + byFirstYear + " / + " + firstYear.size() + "\nSecond Year : " + bySecondYear +
                " / " + secondYear.size() +
                "\nThird Year : " + byThirdYear +
                " / " + thirdYear.size() +
                "\nTotal : " + (byFirstYear + bySecondYear + byThirdYear) +
        " / " + (firstYear.size() + secondYear.size() + thirdYear.size());
    }

    private List<String> firstYearNotFiller(List<String> firstYear, List<String> filled){
        return firstYear.stream().filter(e -> !filled.contains(e)).collect(Collectors.toList());
    }

    private List<String> secondYearNotFiller(List<String> secondYear, List<String> filled){
        return secondYear.stream().filter(e -> !filled.contains(e)).collect(Collectors.toList());
    }

    private List<String> thirdYearNotFiller(List<String> thirdYear, List<String> filled){
        return thirdYear.stream().filter(e -> !filled.contains(e)).collect(Collectors.toList());
    }

    private List<String> everyoneNotFilled(List<String> everyone, List<String> filled){
        return everyone.stream().filter(e -> !filled.contains(e)).collect(Collectors.toList());
    }

    private void printFromListWithIndex(List<String> emails){
        int i   = 1;
        for (String s : emails){
//            System.out.println(s);
            System.out.println(i + ". " + s);
            i++;
        }

    }

    private void printFromList(List<String> emails){
        for (String s : emails){
//            System.out.println(s);
            System.out.println(s);
        }

    }

    private Double totalFilledPercentage(Integer wholePeople, Integer filledPeople){
        return  ((filledPeople.doubleValue()/wholePeople.doubleValue()) * 100);
    }
}
