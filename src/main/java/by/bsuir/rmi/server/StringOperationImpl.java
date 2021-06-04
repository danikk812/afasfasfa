package by.bsuir.rmi.server;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringOperationImpl implements StringOperation {

    @Override
    public String sumDigit(String inputString) {
        int sum = 0;
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(inputString);
        while(matcher.find()) {
            sum += Integer.parseInt(matcher.group());
        }
        return String.valueOf(sum);
    }

    @Override
    public String formWord(String inputString) {
        StringBuilder resultWord = new StringBuilder();
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(inputString);
        while(matcher.find()) {
            resultWord.append(matcher.group());
        }
        return resultWord.toString();
    }
}
