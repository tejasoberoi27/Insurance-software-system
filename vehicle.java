package lab3;
import java.util.*;
public class vehicle {
	private final String model_name;
	private final String owner_name;
	private final String type;
	private final int num_wheels;
	private final boolean isEngine;
	private final insurance_policy policy;
	private float damageCover;
	private float damageAmount;
	


	public vehicle(String owner_name, String model_name, int num_wheels, boolean isEngine,Date expiry_Date) {
		this.owner_name = owner_name;
		this.model_name = model_name;
		this.num_wheels = num_wheels;
		this.isEngine = isEngine;
		if (this.isEngine())
		{
			if(this.num_wheels==4)
			{
				this.policy= new Comprehensive(expiry_Date);
			}
			else
			{
				this.policy= new Third_Party(expiry_Date);
			}
		}
		else
		{
			this.policy=null;
		}
		this.damageCover = 0;
		this.damageAmount=0;
		type = this.num_wheels+"-wheeler";
	}
	
	
	public String getType() {
		return type;
	}


	public float getDamageAmount() {
		return damageAmount;
	}

	public void setDamageAmount(float damageAmount) {
		this.damageAmount = damageAmount;
	}

	public void settle(vehicle oncoming)
	{
			if(this.policy.ifExpired())
			{
				System.out.println("Insurance policy of collision initiating vehicle has expired");
				this.damageCover = 10;
			}
			else
			{
				this.damageCover = 10+ policy.getCover_owner();
				oncoming.setDamageCover(policy.getCover_oncoming());
			}
			
			float cover1 = this.damageCover;
			float cover2 = oncoming.getDamageCover();
			this.setdamageAmount((float) ((100-cover1)*0.01*this.damageAmount));
			oncoming.setDamageAmount((float) ((100-cover2)*0.01*oncoming.getDamageAmount()));
			
	}

	public float getDamageCover() {
		return damageCover;
	}

	public void setDamageCover(float damageCover) {
		this.damageCover = damageCover;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public String getModel_name() {
		return model_name;
	}

	public int getNum_wheels() {
		return num_wheels;
	}

	public boolean isEngine() {
		return isEngine;
	}
	
	public float getdamageAmount() {
		return damageAmount;
	}

	protected void setdamageAmount(float damageAmount) {
		this.damageAmount = damageAmount;
	}
	
	public void resetDamage() {
		this.setDamageAmount(0);
		this.setDamageCover(0);
	}

	protected insurance_policy getPolicy() {
		return policy;
	}
	
	
	
	
}
