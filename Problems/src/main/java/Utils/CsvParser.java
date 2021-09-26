package Utils;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CsvParser {

    public static List<String> getList(String line) {
        return Arrays.stream(line.split(",")).collect(Collectors.toList());
    }
}
