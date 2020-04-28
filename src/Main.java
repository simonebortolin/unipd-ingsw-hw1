import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            println("no file passed, please use --help to know how to use this software and/or try again by passing the files correctly.");
        } else if(args[0].equals("--help")) {
            println("usage: ingsw-hw1 pathOfCharacterFileName [pathOfMapFileName+");
        } else {
            try {
                String characterFileName = null;
                MapDataStructure map = null;
                 if (args.length == 1) {
                    map = InputManager.generateMap();
                    characterFileName = args[0];
                } else if (args.length > 1) {
                    map = InputManager.readMap(args[1]);
                    characterFileName = args[0];
                }

                InputManager.readCharacter(characterFileName, map);

                println("1) The number of pieces on the map for each type");
                println("O: " + OutputManager.getNumberOfPices(map, Orge.class) + " E: " + OutputManager.getNumberOfPices(map, Elf.class) + " D: " + OutputManager.getNumberOfPices(map, Dwarf.class));
                println("");

                println("2) The cell with the highest defense value at day");
                println(Arrays.stream(OutputManager.getMaximumDefendeValue(map, Daytime.DAY)).map(i -> "(" + i.x + "," + i.y + ")").collect(Collectors.joining(", ")));
                println("");

                println("3) The cell with the highest defense value at night");
                println(Arrays.stream(OutputManager.getMaximumDefendeValue(map, Daytime.NIGHT)).map(i -> "(" + i.x + "," + i.y + ")").collect(Collectors.joining(", ")));
                println("");

                println("4) The cell with the highest attack value at day");
                println(Arrays.stream(OutputManager.getMaximumAttackValue(map, Daytime.DAY)).map(i -> "(" + i.x + "," + i.y + ")").collect(Collectors.joining(", ")));
                println("");

                println("5) The cell with the highest attack value at night");
                println(Arrays.stream(OutputManager.getMaximumAttackValue(map, Daytime.NIGHT)).map(i -> "(" + i.x + "," + i.y + ")").collect(Collectors.joining(", ")));
                println("");

                println("6) The cell with the largest number of pieces of the same type");
                println("O: " + Arrays.stream(OutputManager.getMaximCellOfType(map, Orge.class)).map(i -> "(" + i.x + "," + i.y + ")").collect(Collectors.joining(", ")));
                println("E: " + Arrays.stream(OutputManager.getMaximCellOfType(map, Elf.class)).map(i -> "(" + i.x + "," + i.y + ")").collect(Collectors.joining(", ")));
                println("D: " + Arrays.stream(OutputManager.getMaximCellOfType(map, Dwarf.class)).map(i -> "(" + i.x + "," + i.y + ")").collect(Collectors.joining(", ")));

            } catch (ProgramException e) {
                System.err.println("An error has occurred: " + e.getMessage());
            }
        }
    }


    static<T> void println(T arg) { System.out.println(arg); }

}
