import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class InputManager {
    public static MapDataStructure readMap(String path) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()) {
                arrayList.add(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            throw new ProgramException(e);
        }

        try {
            if (!arrayList.stream().allMatch(n -> n.length() == arrayList.get(0).length())) {
                throw new ProgramException("This is not a regular matrix! Is Jagged array");
            }
            if (!arrayList.stream().allMatch(n -> n.matches("[PMFpmf]"))) {
                throw new ProgramException("This matrix contains a not regular character");
            }
        } catch (Exception e) {
            throw new ProgramException(e);
        }

        MapDataStructure.Item[][] matrix = new MapDataStructure.Item[arrayList.size()][arrayList.get(0).length()];
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.get(0).length(); j++) {
                final String first = String.valueOf(arrayList.get(i).charAt(j));
                matrix[i][j] = new MapDataStructure.Item(Arrays.stream(Land.values()).filter(n -> n.toString().equals(first)).findFirst().get());
            }
        }
        MapDataStructure mapDataStructure = new MapDataStructure(matrix);
        return mapDataStructure;
    }

    public static MapDataStructure generateMap() {
        Random ran = new Random();
        MapDataStructure.Item[][] matrix = new MapDataStructure.Item[8][8];
        for (MapDataStructure.Item[] items : matrix) {
            for (int i = 0; i < items.length; i++) {
                int next = Math.abs(ran.nextInt() % 3);
                items[i] = new MapDataStructure.Item(Land.values()[next]);
            }
        }
        MapDataStructure mapDataStructure = new MapDataStructure(matrix);

        return mapDataStructure;
    }
}
