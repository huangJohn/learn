package regex_test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BackRefTest {

    public static void main(String[] args) throws MalformedURLException {


        String s = "http://www.baidu.com";
        String s1 = "http://www.kaola.com/login.html?target=https%3A%2F%2F@www.baidu.com%23@www.kaola.com%2F1";
        String s2 = "http://@www.baidu.com#@www.kaola.com.hk%/1";
        String s3 = "http://global.163.com/urscookiekey/set163Cookie.html?dataKey=cookie_login_c98369f4b15d40fca481bb2c7d6cde70&redirect=yes&target=http%3A%2F%2F%40www.baidu.com%23%40www.kaola.com%2F1";
        String s4 = "http://global.163.com/urscookiekey/set163Cookie.html?dataKey=cookie_login_c98369f4b15d40fca481bb2c7d6cde70&redirect=yes&target=http%3A%2F%2F%40%23%4%2F1";

        String s5 = "http://@www.baidu.com#@www.kaola.com.hk%/1";

        URL url = new URL(s5);
        String host = url.getHost();
        System.out.println(host);
        System.out.println("--------------------");

        Pattern pattern = Pattern.compile("http://.*(?<host>www.\\w+.(com|com.hk)).*");//后向引用
//        Pattern pattern = Pattern.compile("http://.*((www.\\w+.com)|(www.\\w+.com.hk)).*");
        Matcher matcher = pattern.matcher(s2);
        while (matcher.find()) {
            String group = matcher.group("host");
            System.out.println(group);
//            System.out.println(matcher.group());
        }

        System.out.println("----------------------");

        String str = "1云2未3归4来";
        String pattern1 = "\\d{1,}";
        String[] res = GetRegResult(pattern1, str);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    private static String[] GetRegResult(String pattern, String Sourcecode) {

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(Sourcecode);
        ArrayList<String> tempList = new ArrayList<String>();
        while (m.find()) {
            tempList.add(m.group());
        }
        String[] res = new String[tempList.size()];
        int i = 0;
        for (String temp : tempList) {
            res[i] = temp;
            i++;
        }
        return res;
    }


}
