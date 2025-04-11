package Controlador.seguridad;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utilidades {
    public static String encriptarContrasena(String contrasena) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(contrasena.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }
}

