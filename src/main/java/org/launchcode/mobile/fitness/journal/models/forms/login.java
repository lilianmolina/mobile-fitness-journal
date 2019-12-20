package org.launchcode.mobile.fitness.journal.models.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class login {
    @NotNull
    @Size(min=5, max=15)
    private String username;

    @NotNull
    @Size(min=5,max=15)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
