package com.epam.mjc.nio;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {


        Profile profile = new Profile();

        BufferedReader reader = null;
        try {
            FileInputStream inputStream = new FileInputStream(file);
            reader = new BufferedReader(new InputStreamReader(inputStream));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            var name = reader.readLine();
            profile.setName(name.split(": ")[1]);

            var age = reader.readLine();
            profile.setAge(Integer.parseInt(age.split(": ")[1]));

            var email = reader.readLine();
            profile.setEmail(email.split(": ")[1]);

            var phone = reader.readLine();
            profile.setPhone(Long.parseLong(phone.split(": ")[1]));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return profile;
    }
}
