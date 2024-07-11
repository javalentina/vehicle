package org.application.util;
import org.springframework.security.crypto.bcrypt.*;

public class PasswordUtil {
    public static String hashPassword(String plainPassword){
        return BCrypt.hashpw(plainPassword,BCrypt.gensalt());
    }
    public static boolean checkPassword(String plainPassword, String hashPassword){
        return BCrypt.checkpw(plainPassword,hashPassword);
    }
}
