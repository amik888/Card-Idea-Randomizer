import java.util.ArrayList; 
import java.util.List; 
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Main {
  public static List<String> readFileInList(String fileName) throws FileNotFoundException
  {
    List<String> lines = new ArrayList<String>();
    File file = new File(fileName);
    try
    {
      Scanner scanner = new Scanner(file);
      while(scanner.hasNextLine())
      {
        lines.add(scanner.nextLine());
      }
    scanner.close();
    }
    catch(FileNotFoundException ex)
    {
      //do something
    }


    
    return lines;
  }
  
  public static void main(String[] args) throws FileNotFoundException
  {
    List<String> events = readFileInList("events.txt");
    int numberOfEvents = 1;
    
    System.out.print("Type of card: " );
    listRandomElements(events, numberOfEvents, new Main());

    List<String> colors = readFileInList("colors.txt");
    //choose 3-5 random colors
    int numberOfColors = 3;
    System.out.print("With the colors: " );
    listRandomElements(colors, numberOfColors, new Main());

    List<String> themes = readFileInList("themes.txt");
    int numberOfThemes = 3;
    System.out.print("With themes of: ");
    listRandomElements(themes, numberOfThemes, new Main());

    List<String> elements = readFileInList("elements.txt");
    int numberOfElements = 3;
    System.out.print("With artistic elements: ");
    listRandomElements(elements, numberOfElements, new Main());
  }

  public static void listRandomElements(List<String> list, int totalItems, Main obj)
  {
    System.out.println(obj.getRandomElement(list, totalItems));
    obj.getRandomElement(list, totalItems);
  }

      // Function select an element base on index and return 
    // an element 
    public List<String> getRandomElement(List<String> list, int totalItems) 
    { 
        Random rand = new Random(); 
  
        // create a temporary list for storing 
        // selected element 
        List<String> newList = new ArrayList<>(); 
        for (int i = 0; i < totalItems; i++) { 
  
            // take a raundom index between 0 to size  
            // of given List 
            int randomIndex = rand.nextInt(list.size()); 
  
            // add element in temporary list 
            newList.add(list.get(randomIndex)); 
  
            // Remove selected element from orginal list 
            list.remove(randomIndex); 
        } 
        return newList; 
    } 
}