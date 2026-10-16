package util;

public class Funcoes {

    public static String gerarHashSHA256(String senha) {

        try{
            MessageDigest digest = MessageDigest.getInstamce("SHA-256");
            byte[] hasBytes = digest.digest(senha.getBytes("UTF-8"));

            StringBuilder sb = new StringBuilder();
            for (byte b : hasBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
