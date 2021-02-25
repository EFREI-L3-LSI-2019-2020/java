package fr.efrei.tp1;

import java.util.Random;

public class Programmer extends Person implements IProgrammer
{
	private final String occupation = "programmer";
	private float salary;
	private float bonus;
	private String pseudo;

	public Programmer()
	{
		this(0f, 0f);
	}

	public Programmer(float salary, float bonus)
	{
		this(salary, bonus, null);
	}

	public Programmer(float salary, float bonus, String pseudo)
	{
		this(null, null, 0, salary, bonus, pseudo);
	}

	public Programmer(String name, String firstName, int yearOfBirth, float salary, float bonus, String pseudo)
	{
		super(name, firstName, yearOfBirth);
		this.salary = salary;
		this.bonus = bonus;
		this.pseudo = pseudo;
	}

	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString() + "\n");
		sb.append("Occupation : " + occupation + "\n");
		sb.append(String.format("Salaire : %f\nPrime : %f\nPseudo : %s", salary, bonus, pseudo));

		return sb.toString();
	}

	@Override
	public void updateBonus()
	{
		bonus = new Random().nextInt(5000);
	}

	/**
	 * @return the salary
	 */
	public float getSalary() {
		return salary;
	}
}