package com.FuzionSW.UdeA.ProyectoCiclo3.services.userprofile;

import com.FuzionSW.UdeA.ProyectoCiclo3.entities.UserProfile;
import com.FuzionSW.UdeA.ProyectoCiclo3.repositories.UserProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserProfileService {
    UserProfileRepository userProfileRepository;

    public UserProfileService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    public  UserProfile findUserByEmail(String email){
        return this.userProfileRepository.findByEmail(email);
    }

    public UserProfile createUser(UserProfile userProfile){
        return  userProfileRepository.save(userProfile);
    }

    public UserProfile GetorCreateUser(Map<String, Object> userData){
        String email = (String) userData.get("email");
        UserProfile userProfile= findUserByEmail(email);

        if(userProfile == null){
            String name = (String) userData.get("name");
            String given_name = (String) userData.get("given_name");
            String nickname = (String) userData.get("nickname");
            String image = (String) userData.get("picture");
            String auth0Id = (String) userData.get("sub");

            UserProfile newUserProfile = new UserProfile(auth0Id,email,image,name,given_name,nickname);
            return createUser(newUserProfile);
        }

        return userProfile;
    }
}
