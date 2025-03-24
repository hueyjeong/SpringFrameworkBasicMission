package net.jayzen.springframeworkbasic.domain.dto;

public class MemberRegisterRequest {
    private String username;
    private String password;
    private String passwordRepeat;
    private String nickname;

    public MemberRegisterRequest() {
    }

    public MemberRegisterRequest(String username, String password, String passwordRepeat, String nickname) {
        this.username = username;
        this.password = password;
        this.passwordRepeat = passwordRepeat;
        this.nickname = nickname;
    }

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

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
