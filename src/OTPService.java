public class OTPService {

    OTPService(String phoneNum) {
        sendOTP(phoneNum);
    }

    private void sendOTP(String phoneNum) {
        System.out.println("OTP sent to " + phoneNum);
    }

    public boolean verifyOTP(String receivedCode, String phoneNum) {
        return receivedCode.equals(generateOTP(phoneNum));
    }

    public String generateOTP(String phoneNum) {
        return "123456";
    }


}
