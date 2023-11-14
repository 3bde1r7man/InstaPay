public class OTPService {

    OTPService(String phoneNum) {
        sendOTP(phoneNum);
    }

    private void sendOTP(String phoneNum) {
        System.out.println("OTP sent to " + phoneNum);
    }

    public boolean verifyOTP(String receivedCode) {
        return receivedCode.equals(generateOTP());
    }

    public String generateOTP() {
        return "123456";
    }


}
