import java.nio.file.attribute.AclFileAttributeView;

public class OTPGenerator {

	public static void main(String args[]) {
		
		//initialize an array that store the generated otps
		int storeOTP[] = new int[10];
		long otp = generateOTP();
		System.out.println("OTP genrated is "+otp);
	}
	
	public static long generateOTP() {
	
		int otp = (int)(Math.random() * 900000) + 100000;
		return otp;
	}
}
