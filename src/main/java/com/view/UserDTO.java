package com.view;


import com.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String password;
    private Boolean enabled;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.enabled = user.isEnabled();
    }


    public User toEntity() {
        return toEntity(new User());
    }

    private User toEntity(User user) {
        user.setName(this.name);
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setEnabled(this.enabled);
        return user;
    }
}
