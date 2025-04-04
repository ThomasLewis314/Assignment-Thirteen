import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;
import java.util.HashSet;

class Main
{
    static public void main(String[] args)
    {
        File file = new File("inputText.txt");
        try 
        {
            Scanner scnr = new Scanner(file);
            int i = 0;
            String[] textFile = new String[15];
            while (scnr.hasNextLine())
            {
               textFile[i] = scnr.nextLine();
                ++i;
            }

            Set<String> processedWords = new HashSet<>();
            for (String s : textFile)
            {
                if ((processedWords.contains(s)) || (s == null))
                {
                    continue;
                }
                
                processedWords.add(s);
                
                Set<Integer> excludedStrings = new HashSet<>();
                
                for (int j = 0; j < textFile.length; ++j)
                {
                    if (excludedStrings.contains(j))
                    {
                        continue;
                    }
                    else
                    {
                        if (s.equals(textFile[j]))
                        {
                            excludedStrings.add(j);
                            continue;
                        }
                    }
                    
                }
                System.out.println("Number of instances of \"" + s + "\" : " + excludedStrings.size());
            }

        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }

        

    } 
}