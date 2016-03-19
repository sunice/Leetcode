import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yan on 12/20/15.
 */
public class GenerateParentheses {
    //TODO
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        if (n == 0)
            return result;
        result.add("()");
        for (int i = 1; i < n; i++) {
            temp.clear();
            for (String s : result) {
                temp.add("()" + s);
                temp.add("(" + s + ")");
            }
            result.clear();
            for (String s : temp)
                result.add(s);
        }
        return result;
    }

    public static void main(String[] args) {
        GenerateParentheses test = new GenerateParentheses();
        List<String> result = test.generateParenthesis(4);
        for (String s : result)
            System.out.println(s);
    }
}
