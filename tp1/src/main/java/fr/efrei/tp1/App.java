package fr.efrei.tp1;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez votre nom : ");
        String name = scanner.nextLine();
        System.out.print("Entrez votre prénom : ");
        String firstName = scanner.nextLine();
        System.out.print("Entrez votre année de naissance : ");
        int yearOfBirth = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez votre salaire : ");
        float salary = Float.parseFloat(scanner.nextLine());
        System.out.print("Entrez votre prime : ");
        float bonus = Float.parseFloat(scanner.nextLine());
        
        String pseudo = "";
        while(!pseudo.equals("lsidev"))
        {
            System.out.print("Entrez votre pseudo : ");
            pseudo = scanner.nextLine();
        }

        scanner.close();

        System.out.println("");

        Person pg1 = new Programmer(name, firstName, yearOfBirth, salary, bonus, pseudo);
        System.out.println(pg1.toString());
    }
}
