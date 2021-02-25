package fr.efrei.tp2;

public class App 
{
    public static void main( String[] args )
    {
        Database db = new Database();
        for(Programmer programmer : db.getProgrammers())
        {
            System.out.println(programmer);
        }

        System.out.println("----------------------------");

        for(Programmer programmer : db.getProgrammers("Simpson"))
        {
            System.out.println(programmer);
        }
    }
}
