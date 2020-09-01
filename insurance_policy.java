package lab3;
import java.util.*;
public class insurance_policy {
	private final float cover_owner;
	private final float cover_oncoming;
	private final Date expiry_date;
	private final String type;
	private final boolean valid;


	public insurance_policy(float cover_owner, float cover_oncoming, Date expiry_date,String type) {
		this.cover_owner = cover_owner;
		this.cover_oncoming = cover_oncoming;
		this.expiry_date = expiry_date;
		if(this.ifExpired())
		{
		this.valid=false;
		}
		else
		{
		this.valid=true;
		}
		this.type=type;
	}

	public final boolean ifExpired()
	{
		if( this.expiry_date.after( new Date() ) )
		{
			return false;
		}
		else
		{	
			return true; 
		}
	}

	//	public Date getExpiry_date() {
	//		return expiry_date;
	//	}

	//	public void setExpiry_date(Date expiry_date) {
	//		this.expiry_date = expiry_date;
	//	}

	public final float getCover_owner() {
		return cover_owner;
	}

	public final float getCover_oncoming() {
		return cover_oncoming;
	}

//	@Override
//	public String toString() {
//		return "insurance_policy [type=" + type + ", valid=" + valid + "]";
//	}


	public final boolean isValid() {
		return valid;
	}


	public final String getType() {
		return type;
	}	

	


}
