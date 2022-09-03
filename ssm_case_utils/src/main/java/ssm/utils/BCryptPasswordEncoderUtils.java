package ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password="123";
        String pwd = encodePassword(password);
        //$2a$10$VC.fz8aZJ8IjJPad.R5D/OeG6cIGbzTBMKKZnumHtNEsftvVhBhb.
        //$2a$10$v6qCrIarXIVX7wiU1Mip3.kAPVyT72A6KJpTFC2Sl70lmjKCe1CEC
        System.out.println(pwd);
        System.out.print(pwd.length());
    }
}
