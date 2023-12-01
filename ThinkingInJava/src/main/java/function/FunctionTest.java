package function;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @Author chen bo
 * @Date 2024/5
 * @Des
 */
public class FunctionTest {
    public static void main(String[] args) {
//        Consumer<String> animalRun = s -> System.out.println(s + "在跑步");
//        animalRun.accept("dog");
//        animalRun.accept("cat");
//        List<Integer> oddList = new ArrayList<>();
//        List<Integer> evenList = new ArrayList<>();
//        Consumer<Integer> storeNumber = n ->{
//            if(n % 2 == 0){
//                evenList.add(n);
//            }else{
//                oddList.add(n);
//            }
//        };
//
//        Consumer<List<Integer>> printList = list -> list.forEach( n -> System.out.println(n));
//        storeNumber.accept(10);
//        storeNumber.accept(15);
//        storeNumber.accept(25);
//        storeNumber.accept(30);
//        System.out.println("-----odd number------");
//        printList.accept(oddList);
//        System.out.println("-----even number------");
//        printList.accept(evenList);
//        Consumer<Citizen>  electionConsumer = c ->{
//            if(c.getAge() < 18){
//                System.out.println(c.getName() + "is not eligible to vote.");
//            }else{
//                System.out.println(c.getName() + " can vote.");
//            }
//        };
//
//        electionConsumer.accept(new Citizen("Ritesh", 15));
//        electionConsumer.accept(new Citizen("Shreya", 20));
//        Map<Integer, String> persons = new HashMap<>();
//        persons.put(101, "Mahesh");
//        persons.put(102, "Krishna");
//        Consumer<Map<Integer, String>> updatePersons = Utility::updateData;
//        Consumer<Map<Integer, String>> displayPersons = Utility::displayData;
//        updatePersons.accept(persons);
//        displayPersons.accept(persons);
//        List<Integer> numList = Arrays.asList(3,4,5,6);
//        Consumer<List<Integer>> squareConsumer = list ->{
//            for(int i = 0; i < list.size(); i++){
//                list.set(i, list.get(i) * list.get(i));
//            }
//        };
//
//        Consumer<List<Integer>> printConsumer = list -> list.forEach(n -> System.out.println(n));
//        squareConsumer.andThen(printConsumer).accept(numList);
//        List<Integer> list = Arrays.asList(12,13,14,15,16,17);
//        Consumer<List<Integer>> oddNumConsumer = MyNumber :: printOddNum;
//        Consumer<List<Integer>> evenNumConsumer = MyNumber :: printEvenNum;
//        Consumer<List<Integer>> taskFinishConsumer = MyNumber :: taskFinishMsg;
//        oddNumConsumer.andThen(evenNumConsumer).andThen(taskFinishConsumer).accept(list);
//        Supplier<String> supplier = () -> "你好，世界！";
//        String result = supplier.get();
//        System.out.println(result);
//        Supplier<Integer> randomGenerator = () -> new Random().nextInt();
//        int number = randomGenerator.get();
//        System.out.println(number);
//
//        Supplier<String> supplierResult = new Supplier<String>() {
//            @Override
//            public String get() {
//                // 可以加点逻辑
//                return "你好，世界！";
//            }
//        };
//
//        System.out.println(supplierResult.get());
//        Predicate<Integer> predicate = new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                if(integer > 5){
//                    return true;
//                }else{
//                    return false;
//                }
//            }
//        };
//        System.out.println(predicate.test(6)); // true
//        Predicate<Integer> predicate2 = (t) -> t > 5;
//        System.out.println(predicate2.test(1)); // false
//        Predicate<String> isUserNameValid = u -> u != null && u.length() > 5 && u.length() < 10;
//        System.out.println(isUserNameValid.test("Mahesh")); // true
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();//获取每个字符串的长度，并且返回
            }
        };

        Stream<String> stream = Stream.of("qqq", "wwwww", "eeeeee");
        Stream<Integer> stream1 = stream.map(function);
        stream1.forEach(System.out::println);
    }
}

class MyNumber{
    static void printOddNum(List<Integer> myNumbers){
        System.out.println("----- odd numbers -----");
        myNumbers.forEach(n -> {
            if(n % 2 == 1){
                System.out.println( n + " ");
            }
        });
    }

    static void printEvenNum(List<Integer> myNumbers){
        System.out.println("\n----- even numbers -----");
        myNumbers.forEach(n -> {
            if(n % 2 == 0){
                System.out.println( n + " ");
            }
        });
    }

    static void taskFinishMsg(List<Integer> myNumers){
        System.out.println("\n Total " + myNumers.size() + " number processed.");
    }
}

class Citizen{
    private String name;
    private int age;

    public Citizen(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Utility{
    static void updateData(Map<Integer, String> persons){
        persons.replaceAll((k,v) -> "Shree".concat(v));
    }

    static void displayData(Map<Integer, String> persons){
        for(Map.Entry<Integer, String> entry : persons.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
