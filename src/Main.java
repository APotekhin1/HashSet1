import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class Main {
    public static final String TEXT =
            "Lorem ipsum dolor sit amet, consectetur" +
                    " adipiscing elit, sed do eiusmod tempor " +
                    "incididunt ut labore et dolore magna aliqua." +
                    " Ut enim ad minim veniam, quis nostrud " +
                    "exercitation ullamco laboris nisi ut aliquip" +
                    " ex ea commodo consequat. Duis aute irure dolor" +
                    " in reprehenderit in voluptate velit esse cillum " +
                    "dolore eu fugiat nulla pariatur. Excepteur sint " +
                    "occaecat cupidatat non proident, sunt in culpa qui" +
                    " officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {
        char[] tSymbols = TEXT
                .toLowerCase(Locale.ROOT)
                .toCharArray();
        Map<Character, Integer> symbols = new HashMap<>();
        for (Character currentSimbols : tSymbols) {
            if (currentSimbols != ' ') {
                symbols.merge(currentSimbols, 1,
                        (currentValue, defaultValue) -> ++currentValue);
            }
        }
        Map.Entry<Character, Integer> maxSymbol = getMaxSymbol(symbols);
        Map.Entry<Character, Integer> minSymbol = getMinSymbol(symbols);
        System.out.printf("Чаще всего встречается символ %c в количестве %d\n ",
                maxSymbol.getKey(), maxSymbol.getValue());
        System.out.printf("Реже всего встречается символ %c в количестве %d\n ",
                minSymbol.getKey(), minSymbol.getValue());
    }

    public static Map.Entry<Character, Integer> getMaxSymbol(Map<Character, Integer> symbols) {
        int maxCount = -1;
        Map.Entry<Character, Integer> resultEntry = null;
        for (Map.Entry<Character, Integer> currentEntry : symbols.entrySet()) {
            if (currentEntry.getValue() > maxCount) {
                resultEntry = currentEntry;
                maxCount = currentEntry.getValue();
            }
        }
        return resultEntry;
    }

    public static Map.Entry<Character, Integer> getMinSymbol(Map<Character, Integer> symbols) {
        int minCount = Integer.MAX_VALUE;
        Map.Entry<Character, Integer> resultEntry = null;
        for (Map.Entry<Character, Integer> currentEntry : symbols.entrySet()) {
            if (currentEntry.getValue() < minCount) {
                resultEntry = currentEntry;
                minCount = currentEntry.getValue();
            }
        }
        return resultEntry;
    }
}
