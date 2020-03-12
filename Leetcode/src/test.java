import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class test {
  public static void main(String[] args) {

    String[] lastName = {"Diggory", "Chang", "Malfoy", "Weasley", "Weasley", "Goyle", "Potter", "Granger", "Patil", "Weasley"};
    String[] firstName = {"Cedric", "Cho", "Draco", "George", "Fred", "Gregory", "Harry", "Hermione", "Padma", "Ron"};

    Map<String, String> names = new HashMap<String, String>();
    for (int i = 0; i < lastName.length; i++) {
      names.put(firstName[i], lastName[i]);
    }

    List<Map.Entry<String, String>> output = names.entrySet().stream().sorted(new Comparator<Map.Entry<String, String>>() {
      @Override
      public int compare(Map.Entry<String, String> stringStringEntry, Map.Entry<String, String> t1) {
        if (stringStringEntry.getValue().equals(t1.getValue()))
          return stringStringEntry.getKey().compareTo(t1.getKey());
        else
          return stringStringEntry.getValue().compareTo(t1.getValue());
      }
    }).collect(Collectors.toList());

    for (Map.Entry<String, String> input : output) {
      System.out.println(input.getKey() + " " + input.getValue());
    }
  }
}
