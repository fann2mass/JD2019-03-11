package by.it.narushevich.jd01_06;

public class TaskC1 {

    public static void main(String[] args) {

        String[] rows = Poem.text.split("\n");

        int max = 0;
        for (String row : rows) {
            int charsInRow = row.length();
            if (max < charsInRow)
                max = charsInRow;
        }

        for (String row : rows) replaceRow(row, max);
    }

    private static void replaceRow(String row, int max) {
        StringBuilder replacedRow = new StringBuilder(row);
        for (int index = 0; index < replacedRow.length(); index++) {
            if (replacedRow.charAt(index) == ' ') {
                replacedRow.insert(index, " ");
                index += 2;
            }
            if (replacedRow.length() == max) {
                System.out.println(replacedRow);
                return;
            }
            if ((index == replacedRow.length()-1) && (replacedRow.length() != max))
                index = 0;
        }
    }
}

