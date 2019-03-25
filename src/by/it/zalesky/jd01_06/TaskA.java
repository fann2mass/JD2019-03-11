package by.it.zalesky.jd01_06;

        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class TaskA {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        System.out.println(sb);
        Pattern word4= Pattern.compile("[a-яА-ЯёЁ] {4,}");
        Matcher matcher = word4.matcher(sb);
        while (matcher.find()){
            String word = matcher.group();
            sb.setCharAt(matcher.start()+3,'#');
            if (matcher.end()-matcher.start()>6)
                sb.setCharAt(matcher.start()+6,'#');
        }

    }
}
