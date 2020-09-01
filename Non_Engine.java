package lab3;

public class Non_Engine extends vehicle{

	public Non_Engine(String owner_name, String model_name, int num_wheels) {
		super(owner_name, model_name, num_wheels, false, null);
		
	}

	@Override
	public void settle(vehicle oncoming) {
		System.out.println("Settlement denied as collision initiating vehicle is a Non-Engine vehicle");
	}
	
}

