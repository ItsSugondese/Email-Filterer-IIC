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
//    private String peopleWhoFilled(String yourMail){
//        return yourMail
//                + "\n" +
//                "np05cp4s220035@iic.edu.np\n" +
//                "np05cp4a210044@iic.edu.np\n" +
//                "np05cp4a210069@iic.edu.np\n" +
//                "np05cp4a230217@iic.edu.np\n" +
//                "np05cp4a230181@iic.edu.np\n" +
//                "np05cp4a230105@iic.edu.np\n" +
//                "np05cp4a230158@iic.edu.np\n" +
//                "np05cp4a230022@iic.edu.np\n" +
//                "np05ba4a230014@iic.edu.np\n" +
//                "np05cp4a230176@iic.edu.np\n" +
//                "np05cp4a230184@iic.edu.np\n" +
//                "np05cp4a230106@iic.edu.np\n" +
//                "np05cp4a230091@iic.edu.np\n" +
//                "np05cp4a230079@iic.edu.np\n" +
//                "np05cp4a230046@iic.edu.np\n" +
//                "np05cp4a230111@iic.edu.np\n" +
//                "np05cp4a230160@iic.edu.np\n" +
//                "np05cp4a230108@iic.edu.np\n" +
//                "np05cp4a230193@iic.edu.np\n" +
//                "np05cp4a230117@iic.edu.np\n" +
//                "np05cp4a220092@iic.edu.np\n" +
//                "np05cp4s230061@iic.edu.np\n" +
//                "np05cp4a230023@iic.edu.np\n" +
//                "np05cp4a220034@iic.edu.np\n" +
//                "np05cp4a230009@iic.edu.np\n" +
//                "np05cp4a230053@iic.edu.np\n" +
//                "np05cp4a230004@iic.edu.np\n" +
//                "np05cp4a230063@iic.edu.np\n" +
//                "np05cp4a230035@iic.edu.np\n" +
//                "np05cp4s230079@iic.edu.np\n" +
//                "np05cp4a230090@iic.edu.np\n" +
//                "np05cp4a230066@iic.edu.np\n" +
//                "np05cp4a230027@iic.edu.np\n" +
//                "np05cp4a230067@iic.edu.np\n" +
//                "np05cp4a230039@iic.edu.np\n" +
//                "np05cp4a230069@iic.edu.np\n" +
//                "np05ba4a230019@iic.edu.np\n" +
//                "np05cp4a230040@iic.edu.np\n" +
//                "np05cp4a230177@iic.edu.np\n" +
//                "np05cp4a210064@iic.edu.np\n" +
//                "np05cp4a230236@iic.edu.np\n" +
//                "np05cp4a210063@iic.edu.np\n" +
//                "np05cp4a210041@iic.edu.np\n" +
//                "np05cp4a230201@iic.edu.np\n" +
//                "np05cp4a230126@iic.edu.np\n" +
//                "np05cp4a220073@iic.edu.np";
//    }
//    private String firstYearMail(){
//        return "np05cp4a230001@iic.edu.np\n" +
//                "np05cp4a230002@iic.edu.np\n" +
//                "np05cp4a230003@iic.edu.np\n" +
//                "np05cp4a230152@iic.edu.np\n" +
//                "np05cp4a230004@iic.edu.np\n" +
//                "np05cp4a230201@iic.edu.np\n" +
//                "np05cp4a230153@iic.edu.np\n" +
//                "np05cp4a230192@iic.edu.np\n" +
//                "np05cp4a230048@iic.edu.np\n" +
//                "np05cp4a230017@iic.edu.np\n" +
//                "np05cp4a230237@iic.edu.np\n" +
//                "np05cp4a230154@iic.edu.np\n" +
//                "np05cp4a230020@iic.edu.np\n" +
//                "np05cp4a230045@iic.edu.np\n" +
//                "np05cp4a230155@iic.edu.np\n" +
//                "np05cp4a230144@iic.edu.np\n" +
//                "np05cp4a230026@iic.edu.np\n" +
//                "np05cp4a230028@iic.edu.np\n" +
//                "np05cp4a230029@iic.edu.np\n" +
//                "np05cp4a230033@iic.edu.np\n" +
//                "np05cp4a230252@iic.edu.np\n" +
//                "np05cp4a230034@iic.edu.np\n" +
//                "np05cp4a230035@iic.edu.np\n" +
//                "np05cp4a230036@iic.edu.np\n" +
//                "np05cp4a230038@iic.edu.np\n" +
//                "np05cp4a230039@iic.edu.np\n" +
//                "np05cp4a230050@iic.edu.np\n" +
//                "np05cp4a230161@iic.edu.np\n" +
//                "np05cp4a230051@iic.edu.np\n" +
//                "np05cp4a230041@iic.edu.np\n" +
//                "np05cp4a230053@iic.edu.np\n" +
//                "np05cp4a230062@iic.edu.np\n" +
//                "np05cp4a230056@iic.edu.np\n" +
//                "np05cp4a230047@iic.edu.np\n" +
//                "np05cp4a230070@iic.edu.np\n" +
//                "np05cp4a230057@iic.edu.np\n" +
//                "np05cp4a230005@iic.edu.np\n" +
//                "np05cp4a230010@iic.edu.np\n" +
//                "np05cp4a230203@iic.edu.np\n" +
//                "np05cp4a230245@iic.edu.np\n" +
//                "np05cp4a230184@iic.edu.np\n" +
//                "np05cp4a230077@iic.edu.np\n" +
//                "np05cp4a230238@iic.edu.np\n" +
//                "np05cp4a230054@iic.edu.np\n" +
//                "np05cp4a230064@iic.edu.np\n" +
//                "np05cp4a230071@iic.edu.np\n" +
//                "np05cp4a230073@iic.edu.np\n" +
//                "np05cp4a230063@iic.edu.np\n" +
//                "np05cp4a230059@iic.edu.np\n" +
//                "np05cp4a230069@iic.edu.np\n" +
//                "np05cp4a230068@iic.edu.np\n" +
//                "np05cp4a230061@iic.edu.np\n" +
//                "np05cp4a230049@iic.edu.np\n" +
//                "np05cp4a230067@iic.edu.np\n" +
//                "np05cp4a230074@iic.edu.np\n" +
//                "np05cp4a230204@iic.edu.np\n" +
//                "np05cp4a230040@iic.edu.np\n" +
//                "np05cp4a230253@iic.edu.np\n" +
//                "np05cp4a230060@iic.edu.np\n" +
//                "np05cp4a230072@iic.edu.np\n" +
//                "np05cp4a230052@iic.edu.np\n" +
//                "np05cp4a230065@iic.edu.np\n" +
//                "np05cp4a230097@iic.edu.np\n" +
//                "np05cp4a230090@iic.edu.np\n" +
//                "np05cp4a230098@iic.edu.np\n" +
//                "np05cp4a230150@iic.edu.np\n" +
//                "np05cp4a230093@iic.edu.np\n" +
//                "np05cp4a230088@iic.edu.np\n" +
//                "np05cp4a230075@iic.edu.np\n" +
//                "np05cp4a230076@iic.edu.np\n" +
//                "np05cp4a230086@iic.edu.np\n" +
//                "np05cp4a230081@iic.edu.np\n" +
//                "np05cp4a230139@iic.edu.np\n" +
//                "np05cp4a230100@iic.edu.np\n" +
//                "np05cp4a230094@iic.edu.np\n" +
//                "np05cp4a230079@iic.edu.np\n" +
//                "np05cp4a230158@iic.edu.np\n" +
//                "np05cp4a230085@iic.edu.np\n" +
//                "np05cp4a230239@iic.edu.np\n" +
//                "np05cp4a230101@iic.edu.np\n" +
//                "np05cp4a230140@iic.edu.np\n" +
//                "np05cp4a230091@iic.edu.np\n" +
//                "np05cp4a230248@iic.edu.np\n" +
//                "np05cp4a230078@iic.edu.np\n" +
//                "np05cp4a230211@iic.edu.np\n" +
//                "np05cp4a230089@iic.edu.np\n" +
//                "np05cp4a230092@iic.edu.np\n" +
//                "np05cp4a230199@iic.edu.np\n" +
//                "np05cp4a230122@iic.edu.np\n" +
//                "np05cp4a230095@iic.edu.np\n" +
//                "np05cp4a230083@iic.edu.np\n" +
//                "np05cp4a230080@iic.edu.np\n" +
//                "np05cp4a230250@iic.edu.np\n" +
//                "np05cp4a230135@iic.edu.np\n" +
//                "np05cp4a230195@iic.edu.np\n" +
//                "np05cp4a230096@iic.edu.np\n" +
//                "np05cp4a230118@iic.edu.np\n" +
//                "np05cp4a230119@iic.edu.np\n" +
//                "np05cp4a230106@iic.edu.np\n" +
//                "np05cp4a230103@iic.edu.np\n" +
//                "np05cp4a230109@iic.edu.np\n" +
//                "np05cp4a230146@iic.edu.np\n" +
//                "np05cp4a230125@iic.edu.np\n" +
//                "np05cp4a230235@iic.edu.np\n" +
//                "np05cp4a230110@iic.edu.np\n" +
//                "np05cp4a230111@iic.edu.np\n" +
//                "np05cp4a230102@iic.edu.np\n" +
//                "np05cp4a230112@iic.edu.np\n" +
//                "np05cp4a230107@iic.edu.np\n" +
//                "np05cp4a230108@iic.edu.np\n" +
//                "np05cp4a230128@iic.edu.np\n" +
//                "np05cp4a230113@iic.edu.np\n" +
//                "np05cp4a230120@iic.edu.np\n" +
//                "np05cp4a230099@iic.edu.np\n" +
//                "np05cp4a230082@iic.edu.np\n" +
//                "np05cp4a230104@iic.edu.np\n" +
//                "np05cp4a230247@iic.edu.np\n" +
//                "np05cp4a230121@iic.edu.np\n" +
//                "np05cp4a230115@iic.edu.np\n" +
//                "np05cp4a230142@iic.edu.np\n" +
//                "np05cp4a230116@iic.edu.np\n" +
//                "np05cp4a230105@iic.edu.np\n" +
//                "np05cp4a230117@iic.edu.np\n" +
//                "np05cp4a230249@iic.edu.np\n" +
//                "np05cp4a230243@iic.edu.np\n" +
//                "np05cp4a230123@iic.edu.np\n" +
//                "np05cp4a230162@iic.edu.np\n" +
//                "np05cp4a230129@iic.edu.np\n" +
//                "np05cp4a230190@iic.edu.np\n" +
//                "np05cp4a230251@iic.edu.np\n" +
//                "np05cp4a230182@iic.edu.np\n" +
//                "np05cp4a230133@iic.edu.np\n" +
//                "np05cp4a230136@iic.edu.np\n" +
//                "np05cp4a230141@iic.edu.np\n" +
//                "np05cp4a230147@iic.edu.np\n" +
//                "np05cp4a230130@iic.edu.np\n" +
//                "np05cp4a230134@iic.edu.np\n" +
//                "np05cp4a230126@iic.edu.np\n" +
//                "np05cp4a230131@iic.edu.np\n" +
//                "np05cp4a230148@iic.edu.np\n" +
//                "np05cp4a230143@iic.edu.np\n" +
//                "np05cp4a230087@iic.edu.np\n" +
//                "np05cp4a230217@iic.edu.np\n" +
//                "np05cp4a230137@iic.edu.np\n" +
//                "np05cp4a230176@iic.edu.np\n" +
//                "np05cp4a230164@iic.edu.np\n" +
//                "np05cp4a230084@iic.edu.np\n" +
//                "np05cp4a230156@iic.edu.np\n" +
//                "np05cp4a230149@iic.edu.np\n" +
//                "np05cp4a230151@iic.edu.np\n" +
//                "np05cp4a230138@iic.edu.np\n" +
//                "np05cp4a230145@iic.edu.np\n" +
//                "np05cp4a230165@iic.edu.np\n" +
//                "np05cp4a230132@iic.edu.np\n" +
//                "np05cp4a230160@iic.edu.np\n" +
//                "np05cp4a230189@iic.edu.np\n" +
//                "np05cp4a230167@iic.edu.np\n" +
//                "np05cp4a230196@iic.edu.np\n" +
//                "np05cp4a230202@iic.edu.np\n" +
//                "np05cp4a230163@iic.edu.np\n" +
//                "np05cp4a230174@iic.edu.np\n" +
//                "np05cp4a230175@iic.edu.np\n" +
//                "np05cp4a230168@iic.edu.np\n" +
//                "np05cp4a230187@iic.edu.np\n" +
//                "np05cp4a230169@iic.edu.np\n" +
//                "np05cp4a230193@iic.edu.np\n" +
//                "np05cp4a230197@iic.edu.np\n" +
//                "np05cp4a230188@iic.edu.np\n" +
//                "np05cp4a230177@iic.edu.np\n" +
//                "np05cp4a230178@iic.edu.np\n" +
//                "np05cp4a230198@iic.edu.np\n" +
//                "np05cp4a230191@iic.edu.np\n" +
//                "np05cp4a230185@iic.edu.np\n" +
//                "np05cp4a230170@iic.edu.np\n" +
//                "np05cp4a230171@iic.edu.np\n" +
//                "np05cp4a230194@iic.edu.np\n" +
//                "np05cp4a230246@iic.edu.np\n" +
//                "np05cp4a230179@iic.edu.np\n" +
//                "np05cp4a230180@iic.edu.np\n" +
//                "np05cp4a230159@iic.edu.np\n" +
//                "np05cp4a230172@iic.edu.np\n" +
//                "np05cp4a230205@iic.edu.np\n" +
//                "np05cp4a230166@iic.edu.np\n" +
//                "np05cp4a230244@iic.edu.np\n" +
//                "np05cp4a230186@iic.edu.np\n" +
//                "np05cp4a230200@iic.edu.np\n" +
//                "np05cp4a230181@iic.edu.np\n" +
//                "np05cp4a230173@iic.edu.np\n" +
//                "np05cp4a230214@iic.edu.np\n" +
//                "np05cp4a230218@iic.edu.np\n" +
//                "np05cp4a230227@iic.edu.np\n" +
//                "np05cp4a230230@iic.edu.np\n" +
//                "np05cp4a230234@iic.edu.np\n" +
//                "np05cp4a230206@iic.edu.np\n" +
//                "np05cp4a230228@iic.edu.np\n" +
//                "np05cp4a230223@iic.edu.np\n" +
//                "np05cp4a230219@iic.edu.np\n" +
//                "np05cp4a230225@iic.edu.np\n" +
//                "np05cp4a230216@iic.edu.np\n" +
//                "np05cp4a230226@iic.edu.np\n" +
//                "np05cp4a230209@iic.edu.np\n" +
//                "np05cp4a230236@iic.edu.np\n" +
//                "np05cp4a230210@iic.edu.np\n" +
//                "NP05CP4A230231@iic.edu.np\n" +
//                "np05cp4a230254@iic.edu.np\n" +
//                "np05cp4a230220@iic.edu.np\n" +
//                "np05cp4a230229@iic.edu.np\n" +
//                "np05cp4a230255@iic.edu.np\n" +
//                "np05cp4a230207@iic.edu.np\n" +
//                "np05cp4a230222@iic.edu.np\n" +
//                "np05cp4s220047@iic.edu.np\n" +
//                "np05cp4a230232@iic.edu.np\n" +
//                "np05cp4a230224@iic.edu.np\n" +
//                "np05cp4a230212@iic.edu.np\n" +
//                "np05cp4a230208@iic.edu.np\n" +
//                "np05cp4a230213@iic.edu.np\n" +
//                "np05cp4a230233@iic.edu.np\n" +
//                "np05cp4a230215@iic.edu.np\n" +
//                "np05cp4a230242@iic.edu.np\n" +
//                "np05cp4a230221@iic.edu.np\n" +
//                "np05cp4a230006@iic.edu.np\n" +
//                "np05cp4a230007@iic.edu.np\n" +
//                "np05cp4a230008@iic.edu.np\n" +
//                "np05cp4a230009@iic.edu.np\n" +
//                "np05cp4a230011@iic.edu.np\n" +
//                "np05cp4a230012@iic.edu.np\n" +
//                "np05cp4a230013@iic.edu.np\n" +
//                "np05cp4a230066@iic.edu.np\n" +
//                "np05cp4a230014@iic.edu.np\n" +
//                "np05cp4a230015@iic.edu.np\n" +
//                "np05cp4a230016@iic.edu.np\n" +
//                "np05cp4a230018@iic.edu.np\n" +
//                "np05cp4a230019@iic.edu.np\n" +
//                "np05cp4a230127@iic.edu.np\n" +
//                "np05cp4a230021@iic.edu.np\n" +
//                "np05cp4a230022@iic.edu.np\n" +
//                "np05cp4a230023@iic.edu.np\n" +
//                "np05cp4a230024@iic.edu.np\n" +
//                "np05cp4a230025@iic.edu.np\n" +
//                "np05cp4a230027@iic.edu.np\n" +
//                "np05cp4a230030@iic.edu.np\n" +
//                "np05cp4a230031@iic.edu.np\n" +
//                "np05cp4a230032@iic.edu.np\n" +
//                "np05cp4a230037@iic.edu.np\n" +
//                "np05cp4a230046@iic.edu.np\n" +
//                "np05cp4a230240@iic.edu.np\n" +
//                "np05cp4a230241@iic.edu.np\n" +
//                "np05cp4a230042@iic.edu.np\n" +
//                "np05cp4a230043@iic.edu.np\n" +
//                "np05cp4a230044@iic.edu.np\n" +
//                "np05ba4a230032@iic.edu.np\n" +
//                "np05ba4a230015@iic.edu.np\n" +
//                "np05ba4a230020@iic.edu.np\n" +
//                "np05ba4a230014@iic.edu.np\n" +
//                "np05ba4a230021@iic.edu.np\n" +
//                "NP05BA4A230034@iic.edu.np\n" +
//                "np05ba4a230009@iic.edu.np\n" +
//                "np05ba4a230006@iic.edu.np\n" +
//                "np05ba4a230017@iic.edu.np\n" +
//                "np05ba4a230011@iic.edu.np\n" +
//                "np05ba4a230018@iic.edu.np\n" +
//                "np05ba4a230010@iic.edu.np\n" +
//                "np05ba4a230028@iic.edu.np\n" +
//                "np05ba4a230026@iic.edu.np\n" +
//                "np05ba4a230008@iic.edu.np\n" +
//                "np05ba4a230031@iic.edu.np\n" +
//                "np05ba4a230019@iic.edu.np\n" +
//                "np05ba4a230023@iic.edu.np\n" +
//                "np05ba4a230001@iic.edu.np\n" +
//                "np05ba4a230030@iic.edu.np\n" +
//                "np05ba4a230002@iic.edu.np\n" +
//                "np05ba4a230027@iic.edu.np\n" +
//                "np05ba4a230024@iic.edu.np\n" +
//                "np05ba4a230033@iic.edu.np\n" +
//                "np05ba4a230025@iic.edu.np\n" +
//                "np05ba4a230003@iic.edu.np\n" +
//                "np05ba4a230007@iic.edu.np\n" +
//                "np05ba4a230022@iic.edu.np\n" +
//                "np05ba4a230012@iic.edu.np\n" +
//                "np05ba4a230005@iic.edu.np\n" +
//                "np05ba4a230029@iic.edu.np\n" +
//                "np05ba4a230013@iic.edu.np";
//    }

//    private String secondYearMail(){
//        return "np05cp4s230001@iic.edu.np\n" +
//                "np05cp4a220001@iic.edu.np\n" +
//                "np05cp4a220002@iic.edu.np\n" +
//                "np05cp4s230002@iic.edu.np\n" +
//                "np05cp4a220004@iic.edu.np\n" +
//                "np05cp4a220005@iic.edu.np\n" +
//                "np05cp4a220006@iic.edu.np\n" +
//                "np05cp4a220007@iic.edu.np\n" +
//                "np05cp4a220008@iic.edu.np\n" +
//                "np05cp4a220009@iic.edu.np\n" +
//                "np05cp4s230003@iic.edu.np\n" +
//                "np05cp4a220010@iic.edu.np\n" +
//                "np05cp4s230070@iic.edu.np\n" +
//                "np05cp4s230004@iic.edu.np\n" +
//                "np05cp4a220011@iic.edu.np\n" +
//                "np05cp4s230074@iic.edu.np\n" +
//                "np05cp4a220012@iic.edu.np\n" +
//                "np05cp4s230005@iic.edu.np\n" +
//                "np05cp4s230006@iic.edu.np\n" +
//                "np05cp4a220014@iic.edu.np\n" +
//                "np05cp4a220015@iic.edu.np\n" +
//                "np05cp4s230007@iic.edu.np\n" +
//                "np05cp4s230008@iic.edu.np\n" +
//                "np05cp4s230009@iic.edu.np\n" +
//                "np05cp4s230010@iic.edu.np\n" +
//                "np05cp4s230011@iic.edu.np\n" +
//                "np05cp4a220016@iic.edu.np\n" +
//                "np05cp4a220017@iic.edu.np\n" +
//                "np05cp4a220018@iic.edu.np\n" +
//                "np05cp4a220019@iic.edu.np\n" +
//                "np05cp4a220020@iic.edu.np\n" +
//                "np05cp4a220021@iic.edu.np\n" +
//                "np05cp4s230012@iic.edu.np\n" +
//                "np05cp4s230013@iic.edu.np\n" +
//                "np05cp4s230071@iic.edu.np\n" +
//                "np05cp4a220022@iic.edu.np\n" +
//                "np05cp4a220023@iic.edu.np\n" +
//                "np05cp4s230014@iic.edu.np\n" +
//                "np05cp4s230015@iic.edu.np\n" +
//                "np05cp4a220024@iic.edu.np\n" +
//                "np05cp4s230078@iic.edu.np\n" +
//                "np05cp4a220025@iic.edu.np\n" +
//                "np05cp4a220026@iic.edu.np\n" +
//                "np05cp4a220027@iic.edu.np\n" +
//                "np05cp4s230016@iic.edu.np\n" +
//                "np05cp4s230017@iic.edu.np\n" +
//                "np05cp4a220028@iic.edu.np\n" +
//                "np05cp4a220029@iic.edu.np\n" +
//                "np05cp4a220030@iic.edu.np\n" +
//                "np05cp4a220031@iic.edu.np\n" +
//                "np05cp4s230077@iic.edu.np\n" +
//                "np05cp4a220033@iic.edu.np\n" +
//                "np05cp4a220034@iic.edu.np\n" +
//                "np05cp4s230019@iic.edu.np\n" +
//                "np05cp4a220035@iic.edu.np\n" +
//                "np05cp4a220036@iic.edu.np\n" +
//                "np05cp4s230020@iic.edu.np\n" +
//                "np05cp4s230021@iic.edu.np\n" +
//                "np05cp4s230022@iic.edu.np\n" +
//                "np05cp4a220037@iic.edu.np\n" +
//                "np05cp4s230023@iic.edu.np\n" +
//                "np05cp4s230024@iic.edu.np\n" +
//                "np05cp4s230025@iic.edu.np\n" +
//                "np05cp4s230026@iic.edu.np\n" +
//                "np05cp4a220039@iic.edu.np\n" +
//                "np05cp4s230027@iic.edu.np\n" +
//                "np05cp4a220040@iic.edu.np\n" +
//                "np05cp4a220041@iic.edu.np\n" +
//                "np05cp4s230029@iic.edu.np\n" +
//                "np05cp4s230079@iic.edu.np\n" +
//                "np05cp4a220043@iic.edu.np\n" +
//                "np05cp4a220044@iic.edu.np\n" +
//                "np05cp4a220045@iic.edu.np\n" +
//                "np05cp4a220046@iic.edu.np\n" +
//                "np05cp4s230030@iic.edu.np\n" +
//                "np05cp4a220047@iic.edu.np\n" +
//                "np05cp4s230031@iic.edu.np\n" +
//                "np05cp4s230072@iic.edu.np\n" +
//                "np05cp4s230032@iic.edu.np\n" +
//                "np05cp4a220048@iic.edu.np\n" +
//                "np05cp4a220049@iic.edu.np\n" +
//                "np05cp4a220050@iic.edu.np\n" +
//                "np05cp4a220051@iic.edu.np\n" +
//                "np05cp4a220052@iic.edu.np\n" +
//                "np05cp4s230033@iic.edu.np\n" +
//                "np05cp4s230034@iic.edu.np\n" +
//                "np05cp4s230035@iic.edu.np\n" +
//                "np05cp4s230036@iic.edu.np\n" +
//                "np05cp4s230037@iic.edu.np\n" +
//                "np05cp4a220053@iic.edu.np\n" +
//                "np05cp4a220054@iic.edu.np\n" +
//                "np05cp4s230038@iic.edu.np\n" +
//                "np05cp4s230041@iic.edu.np\n" +
//                "np05cp4a220141@iic.edu.np\n" +
//                "np05cp4a220056@iic.edu.np\n" +
//                "np05cp4a220061@iic.edu.np\n" +
//                "np05cp4s230042@iic.edu.np\n" +
//                "np05cp4a220062@iic.edu.np\n" +
//                "np05cp4a220063@iic.edu.np\n" +
//                "np05cp4s230043@iic.edu.np\n" +
//                "np05cp4a220064@iic.edu.np\n" +
//                "np05cp4a220065@iic.edu.np\n" +
//                "np05cp4a220066@iic.edu.np\n" +
//                "np05cp4a220067@iic.edu.np\n" +
//                "np05cp4a220068@iic.edu.np\n" +
//                "np05cp4s230075@iic.edu.np\n" +
//                "np05cp4a220069@iic.edu.np\n" +
//                "np05cp4a220070@iic.edu.np\n" +
//                "np05cp4s230044@iic.edu.np\n" +
//                "np05cp4s230045@iic.edu.np\n" +
//                "np05cp4a220071@iic.edu.np\n" +
//                "np05cp4a220072@iic.edu.np\n" +
//                "np05cp4a220073@iic.edu.np\n" +
//                "np05cp4s230046@iic.edu.np\n" +
//                "np05cp4a220074@iic.edu.np\n" +
//                "np05cp4a220075@iic.edu.np\n" +
//                "np05cp4a220076@iic.edu.np\n" +
//                "np05cp4a220077@iic.edu.np\n" +
//                "np05cp4a220078@iic.edu.np\n" +
//                "np05cp4a220079@iic.edu.np\n" +
//                "np05cp4a220080@iic.edu.np\n" +
//                "np05cp4a220081@iic.edu.np\n" +
//                "np05cp4a220140@iic.edu.np\n" +
//                "np05cp4a220082@iic.edu.np\n" +
//                "np05cp4s230047@iic.edu.np\n" +
//                "np05cp4a220083@iic.edu.np\n" +
//                "np05cp4a220084@iic.edu.np\n" +
//                "np05cp4s230048@iic.edu.np\n" +
//                "np05cp4a220085@iic.edu.np\n" +
//                "np05cp4s230049@iic.edu.np\n" +
//                "np05cp4s230069@iic.edu.np\n" +
//                "np05cp4a220086@iic.edu.np\n" +
//                "np05cp4s230050@iic.edu.np\n" +
//                "np05cp4s230051@iic.edu.np\n" +
//                "np05cp4a220087@iic.edu.np\n" +
//                "np05cp4s230052@iic.edu.np\n" +
//                "np05cp4a220088@iic.edu.np\n" +
//                "np05cp4s230053@iic.edu.np\n" +
//                "np05cp4a220089@iic.edu.np\n" +
//                "np05cp4a220090@iic.edu.np\n" +
//                "np05cp4a220091@iic.edu.np\n" +
//                "np05cp4a220092@iic.edu.np\n" +
//                "np05cp4s230054@iic.edu.np\n" +
//                "np05cp4a220093@iic.edu.np\n" +
//                "np05cp4a220094@iic.edu.np\n" +
//                "np05cp4a220095@iic.edu.np\n" +
//                "np05cp4a220096@iic.edu.np\n" +
//                "np05cp4a220097@iic.edu.np\n" +
//                "np05cp4a220098@iic.edu.np\n" +
//                "np05cp4a220099@iic.edu.np\n" +
//                "np05cp4a220100@iic.edu.np\n" +
//                "np05cp4s230055@iic.edu.np\n" +
//                "np05cp4a220101@iic.edu.np\n" +
//                "np05cp4a220102@iic.edu.np\n" +
//                "np05cp4a220103@iic.edu.np\n" +
//                "np05cp4s230056@iic.edu.np\n" +
//                "np05cp4a220104@iic.edu.np\n" +
//                "np05cp4s230057@iic.edu.np\n" +
//                "np05cp4s230058@iic.edu.np\n" +
//                "np05cp4a220105@iic.edu.np\n" +
//                "np05cp4a220106@iic.edu.np\n" +
//                "np05cp4a220107@iic.edu.np\n" +
//                "np05cp4s230059@iic.edu.np\n" +
//                "np05cp4s230060@iic.edu.np\n" +
//                "np05cp4a220108@iic.edu.np\n" +
//                "np05cp4s230076@iic.edu.np\n" +
//                "np05cp4a220109@iic.edu.np\n" +
//                "np05cp4a220110@iic.edu.np\n" +
//                "np05cp4s230073@iic.edu.np\n" +
//                "np05cp4a220111@iic.edu.np\n" +
//                "np05cp4s230061@iic.edu.np\n" +
//                "np05cp4a220112@iic.edu.np\n" +
//                "np05cp4s230062@iic.edu.np\n" +
//                "np05cp4a220113@iic.edu.np\n" +
//                "np05cp4s230063@iic.edu.np\n" +
//                "np05cp4a220114@iic.edu.np\n" +
//                "np05cp4a220115@iic.edu.np\n" +
//                "np05cp4a220116@iic.edu.np\n" +
//                "np05cp4a220117@iic.edu.np\n" +
//                "np05cp4a220118@iic.edu.np\n" +
//                "np05cp4a220119@iic.edu.np\n" +
//                "np05cp4a220120@iic.edu.np\n" +
//                "np05cp4a220121@iic.edu.np\n" +
//                "np05cp4a220122@iic.edu.np\n" +
//                "np05cp4s230064@iic.edu.np\n" +
//                "np05cp4a220123@iic.edu.np\n" +
//                "np05cp4a220124@iic.edu.np\n" +
//                "np05cp4a220125@iic.edu.np\n" +
//                "np05cp4s230065@iic.edu.np\n" +
//                "np05cp4a220126@iic.edu.np\n" +
//                "np05cp4a220127@iic.edu.np\n" +
//                "np05cp4s230066@iic.edu.np\n" +
//                "np05cp4a220128@iic.edu.np\n" +
//                "np05cp4a220129@iic.edu.np\n" +
//                "np05cp4a220132@iic.edu.np\n" +
//                "np05cp4a220130@iic.edu.np\n" +
//                "np05cp4a220131@iic.edu.np\n" +
//                "np05cp4a220133@iic.edu.np\n" +
//                "np05cp4a220134@iic.edu.np\n" +
//                "np05cp4a220135@iic.edu.np\n" +
//                "np05cp4a220136@iic.edu.np\n" +
//                "np05cp4s230067@iic.edu.np\n" +
//                "np05cp4s230068@iic.edu.np\n" +
//                "np05cp4a220137@iic.edu.np\n" +
//                "np05cp4a220138@iic.edu.np\n" +
//                "np05cp4a220057@iic.edu.np\n" +
//                "np05cp4a220058@iic.edu.np\n" +
//                "np05cp4a220059@iic.edu.np\n" +
//                "np05cp4a220060@iic.edu.np";
//    }

//    private String thirdYearMail(){
//        return "np05cp4a210040@iic.edu.np\n" +
//                "np05cp4s220001@iic.edu.np\n" +
//                "np05cp4a210041@iic.edu.np\n" +
//                "np05cp4s220002@iic.edu.np\n" +
//                "np05cp4s220004@iic.edu.np\n" +
//                "np05cp4a210007@iic.edu.np\n" +
//                "np05cp4a210042@iic.edu.np\n" +
//                "np05cp4s220005@iic.edu.np\n" +
//                "np05cp4s220007@iic.edu.np\n" +
//                "np05cp4s220006@iic.edu.np\n" +
//                "np05cp4a210044@iic.edu.np\n" +
//                "np05cp4a210046@iic.edu.np\n" +
//                "np05cp4a210045@iic.edu.np\n" +
//                "np05cp4a210048@iic.edu.np\n" +
//                "np05cp4a210047@iic.edu.np\n" +
//                "np05cp4s220012@iic.edu.np\n" +
//                "np05cp4a210033@iic.edu.np\n" +
//                "np05cp4a210049@iic.edu.np\n" +
//                "np05cp4s220013@iic.edu.np\n" +
//                "np05cp4s220071@iic.edu.np\n" +
//                "np05cp4a210050@iic.edu.np\n" +
//                "np05cp4s220014@iic.edu.np\n" +
//                "np05cp4a210052@iic.edu.np\n" +
//                "np05cp4a210008@iic.edu.np\n" +
//                "np05cp4a210053@iic.edu.np\n" +
//                "np05cp4a210054@iic.edu.np\n" +
//                "np05cp4s220016@iic.edu.np\n" +
//                "np05cp4s220015@iic.edu.np\n" +
//                "np05cp4s220017@iic.edu.np\n" +
//                "np05cp4s220018@iic.edu.np\n" +
//                "np05cp4a210009@iic.edu.np\n" +
//                "np05cp4a210055@iic.edu.np\n" +
//                "np05cp4s220019@iic.edu.np\n" +
//                "np05cp4a210031@iic.edu.np\n" +
//                "np05cp4a210024@iic.edu.np\n" +
//                "np05cp4s220020@iic.edu.np\n" +
//                "np05cp4a210023@iic.edu.np\n" +
//                "np05cp4a210030@iic.edu.np\n" +
//                "np05cp4s220021@iic.edu.np\n" +
//                "np05cp4a210056@iic.edu.np\n" +
//                "np05cp4s220022@iic.edu.np\n" +
//                "np05cp4a210012@iic.edu.np\n" +
//                "np05cp4a210022@iic.edu.np\n" +
//                "np05cp4s220023@iic.edu.np\n" +
//                "np05cp4s220024@iic.edu.np\n" +
//                "np05cp4a210039@iic.edu.np\n" +
//                "np05cp4s220025@iic.edu.np\n" +
//                "np05cp4s220026@iic.edu.np\n" +
//                "np05cp4a210059@iic.edu.np\n" +
//                "np05cp4s220027@iic.edu.np\n" +
//                "np05cp4s220072@iic.edu.np\n" +
//                "np05cp4a210060@iic.edu.np\n" +
//                "np05cp4a210061@iic.edu.np\n" +
//                "np05cp4s220028@iic.edu.np\n" +
//                "np05cp4a210062@iic.edu.np\n" +
//                "np05cp4a210063@iic.edu.np\n" +
//                "np05cp4a210064@iic.edu.np\n" +
//                "np05cp4a210066@iic.edu.np\n" +
//                "np05cp4a210067@iic.edu.np\n" +
//                "np05cp4s220029@iic.edu.np\n" +
//                "np05cp4a210068@iic.edu.np\n" +
//                "np05cp4a210006@iic.edu.np\n" +
//                "np05cp4a210069@iic.edu.np\n" +
//                "np05cp4s220030@iic.edu.np\n" +
//                "np05cp5a220001@iic.edu.np\n" +
//                "np05cp4s220033@iic.edu.np\n" +
//                "np05cp4s220034@iic.edu.np\n" +
//                "np05cp4s220068@iic.edu.np\n" +
//                "np05cp4a210020@iic.edu.np\n" +
//                "np05cp4a210070@iic.edu.np\n" +
//                "np05cp4a210010@iic.edu.np\n" +
//                "np05cp4a210071@iic.edu.np\n" +
//                "np05cp4a210072@iic.edu.np\n" +
//                "np05cp4a210028@iic.edu.np\n" +
//                "np05cp4s220067@iic.edu.np\n" +
//                "np05cp4s220035@iic.edu.np\n" +
//                "np05cp4s220036@iic.edu.np\n" +
//                "np05cp4a210073@iic.edu.np\n" +
//                "np05cp4s220037@iic.edu.np\n" +
//                "np05cp4s220038@iic.edu.np\n" +
//                "np05cp4s220039@iic.edu.np\n" +
//                "np05cp4a210036@iic.edu.np\n" +
//                "np05cp4a210075@iic.edu.np\n" +
//                "np05cp4a210032@iic.edu.np\n" +
//                "np05cp4s220040@iic.edu.np\n" +
//                "np05cp4a210029@iic.edu.np\n" +
//                "np05cp4a210011@iic.edu.np\n" +
//                "np05cp4a210004@iic.edu.np\n" +
//                "np05cp4s220041@iic.edu.np\n" +
//                "np05cp4a210077@iic.edu.np\n" +
//                "np05cp4a210079@iic.edu.np\n" +
//                "np05cp4s220065@iic.edu.np\n" +
//                "np05cp4a210080@iic.edu.np\n" +
//                "np05cp4s220042@iic.edu.np\n" +
//                "np05cp4s210112@iic.edu.np\n" +
//                "np05cp4s220043@iic.edu.np\n" +
//                "np05cp4a210082@iic.edu.np\n" +
//                "np05cp4s220044@iic.edu.np\n" +
//                "np05cp4a210003@iic.edu.np\n" +
//                "np05cp4a210083@iic.edu.np\n" +
//                "np05cp4a210084@iic.edu.np\n" +
//                "np05cp4a210085@iic.edu.np\n" +
//                "np05cp4a210086@iic.edu.np\n" +
//                "np05cp4s220045@iic.edu.np\n" +
//                "np05cp4a210087@iic.edu.np\n" +
//                "np05cp4a210021@iic.edu.np\n" +
//                "np05cp4a210088@iic.edu.np\n" +
//                "np05cp4a210037@iic.edu.np\n" +
//                "np05cp4a210090@iic.edu.np\n" +
//                "np05cp4a210091@iic.edu.np\n" +
//                "np05cp4a210002@iic.edu.np\n" +
//                "np05cp4a210092@iic.edu.np\n" +
//                "np05cp4a210014@iic.edu.np\n" +
//                "np05cp4s220049@iic.edu.np\n" +
//                "np05cp4s220050@iic.edu.np\n" +
//                "np05cp4s220051@iic.edu.np\n" +
//                "np05cp4a210093@iic.edu.np\n" +
//                "np05cp4s220052@iic.edu.np\n" +
//                "np05cp4a210094@iic.edu.np\n" +
//                "np05cp4s220053@iic.edu.np\n" +
//                "np05cp4s220054@iic.edu.np\n" +
//                "np05cp4a210095@iic.edu.np\n" +
//                "np05cp4a210096@iic.edu.np\n" +
//                "np05cp4a210097@iic.edu.np\n" +
//                "np05cp4s220055@iic.edu.np\n" +
//                "np05cp4a210099@iic.edu.np\n" +
//                "np05cp4a210100@iic.edu.np\n" +
//                "np05cp4a210101@iic.edu.np\n" +
//                "np05cp4a210102@iic.edu.np\n" +
//                "np05cp4a210013@iic.edu.np\n" +
//                "np05cp4a210034@iic.edu.np\n" +
//                "np05cp4a210001@iic.edu.np\n" +
//                "np05cp4a210103@iic.edu.np\n" +
//                "np05cp4s220057@iic.edu.np\n" +
//                "np05cp4s210106@iic.edu.np\n" +
//                "np05cp4a210104@iic.edu.np\n" +
//                "np05cp4s220066@iic.edu.np\n" +
//                "np05cp4a210105@iic.edu.np\n" +
//                "np05cp4s220058@iic.edu.np\n" +
//                "np05cp4s220059@iic.edu.np\n" +
//                "np05cp4s220060@iic.edu.np\n" +
//                "np05cp4a210107@iic.edu.np\n" +
//                "np05cp4a210108@iic.edu.np\n" +
//                "np05cp4s220061@iic.edu.np\n" +
//                "np05cp4a210109@iic.edu.np\n" +
//                "np05cp4a210110@iic.edu.np\n" +
//                "np05cp4s210095@iic.edu.np\n" +
//                "np05cp4a210111@iic.edu.np\n" +
//                "np05cp4s220063@iic.edu.np\n" +
//                "np05cp4a210112@iic.edu.np\n" +
//                "np05cp4a210038@iic.edu.np\n" +
//                "np05cp4a210113@iic.edu.np\n" +
//                "np05cp4a210114@iic.edu.np\n" +
//                "np05cp4a210005@iic.edu.np\n" +
//                "np05cp4a210115@iic.edu.np\n" +
//                "np05cp4s220073@iic.edu.np";
//    }
}
