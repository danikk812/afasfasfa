package by.bsuir.jsf;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

@Named
@SessionScoped
public class NumbersSorter implements Serializable {
    @Inject
    private Numbers numbers;

    public void sort() {
       String[] strings = numbers.getNumbers().split(" ");
        Stream<Integer> stream = Arrays.stream(strings)
                .map(Integer::parseInt);
        stream = sort(stream, numbers.getCommand());
        Stream<String> chars = stream.map(String::valueOf);
        StringBuilder builder = new StringBuilder();
        chars.forEach(el -> builder.append(el).append(" "));

        numbers.setNumbers(builder.toString());
    }

    private Stream<Integer> sort(Stream<Integer> stream, String command) {
        if ("DESC".equals(command)) {
            return stream.sorted(Comparator.reverseOrder());
        }
        return stream.sorted();
    }
}
