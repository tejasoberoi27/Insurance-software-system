package lab3;

import java.util.*;
//import java.lang.*;


public final class InsuranceSystem {

	ArrayList<vehicle> vehicles = new ArrayList<vehicle>();
	public final float assignDamage()
	{
		int min = 1000;
		int max = 15000;
		return (float) ((Math.random() * ((max - min) + 1)) + min);
	}


	public void display()
	{
		// Print the list objects in tabular format.
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%20s %20s %20s %20s %25s", "MODEL", "OWNER NAME", "TYPE", "INSURANCE POLICY", "POLICY VALIDITY STATUS");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		for(vehicle Vehicle: vehicles){
			if(Vehicle.getPolicy()!=null)
				{if(Vehicle.getPolicy().isValid())
			System.out.format("%20s %20s %20s %20s %25s", Vehicle.getModel_name(), Vehicle.getOwner_name(), Vehicle.getType(), Vehicle.getPolicy().getType(), "Valid");
			else
			{
				System.out.format("%20s %20s %20s %20s %25s", Vehicle.getModel_name(), Vehicle.getOwner_name(), Vehicle.getType(), Vehicle.getPolicy().getType(), "Expired");
			}
				}
			else
			{
				System.out.format("%20s %20s %20s %20s %25s", Vehicle.getModel_name(), Vehicle.getOwner_name(), Vehicle.getType(), "-----N/A-----", "-----N/A-----");				
			}
			System.out.println();
		}
	}

	public final void collide(vehicle owner,vehicle oncoming)
	{
		if(owner==oncoming)
		{
			System.out.println("Invalid collision");
		}
		else
		{
		System.out.println("vehicle1 <"+owner.getModel_name()+","+owner.getOwner_name()+"> collided with vehicle2 <"+oncoming.getModel_name()+","+oncoming.getOwner_name()+">");
		float damage1 = this.assignDamage();
		float damage2 = this.assignDamage();
		owner.setDamageAmount(damage1);
		oncoming.setdamageAmount(damage2);
		System.out.println("Damages awarded to vehicle1: "+damage1);
		System.out.println("Damages awarded to vehicle2: "+damage2);
		owner.settle(oncoming);

		if(owner.isEngine()==true)
		{
			System.out.println("Settlement details");
			System.out.println("vehicle1 damage status, after settlement: "+owner.getdamageAmount());
			System.out.println("vehicle2 damage status, after settlement: "+oncoming.getdamageAmount());
		}
		owner.resetDamage();
		oncoming.resetDamage();
	}
	}

	

	@SuppressWarnings("deprecation")
	public void simulation()
	{

		vehicles.add(new engine("John Cena","Honda Civic",4,new Date(2019-1900,12,27)));
		vehicles.add(new engine("Ric Flair","Ferrari Spider",4,new Date(2017-1900,5,16)));
		vehicles.add(new engine("Tejas Oberoi","Ducati Ninja",2,new Date(2020-1900,11,4)));
		vehicles.add(new engine("Rahul Dravid","Yamaha Hayabusa", 2, new Date(2016-1900,12,9)));
		vehicles.add(new Non_Engine("Raghav Rathi", "Rickshaw", 3));
		vehicles.add(new Non_Engine("Nivedit Mishra", "Bicycle", 2));
		display();
		System.out.println();
		System.out.println("Simulation begins");
		System.out.println();
//		int cnt=0;
		for(int i=0;i<vehicles.size();i++)
		{

			for(int j=0;j<vehicles.size();j++)
			{
				if(i!=j)
				{
//					cnt+=1;
//					System.err.println("Collision Number "+cnt);
					vehicle v1 = vehicles.get(i);
					vehicle v2 = vehicles.get(j);
					collide(v1,v2);
					System.out.println();
				}
			}
		}

	}

	public static void main(String[] args) {
		InsuranceSystem Run = new InsuranceSystem();
		Run.simulation();

	}

}
