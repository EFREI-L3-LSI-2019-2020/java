package fr.efrei.tp1;

import java.util.Calendar;

public class Person
{
	private String name;
	private String firstName;
	private int yearOfBirth;

	private static int numberOfPerson = 0;

	public Person(String name, String firstName, int yearOfBirth)
	{
		this.name = name;
		this.firstName = firstName;
		this.yearOfBirth = yearOfBirth;

		numberOfPerson++;
	}

	public int caculateAge()
	{
		return Calendar.getInstance().get(Calendar.YEAR) - yearOfBirth;
	}

	@Override
	public String toString()
	{
		return String.format("Nom : %s\nPrénom : %s\nAge : %d", name, firstName, caculateAge());
	}

	public static void displayAmountOfPerson()
	{
		System.out.println(String.format("Number of person : %d", numberOfPerson));
	}
}