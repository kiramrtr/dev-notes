import java.util.function.*;

public class PredicateExamples {

    public static boolean isPalindrome(String s) {
        return s.isEmpty();
    }

    public static void main(String[] args) {
        Function<String, Boolean> bp1 = PredicateExamples::isPalindrome;

        Predicate<String> bp2 = PredicateExamples::isPalindrome;

        BiPredicate<String, Boolean> bp = PredicateExamples::isPalindrome;
    }
}