package net.jayzen.springframeworkbasic.domain.dto;

public class MemberRegisterResponse {
    private Long id;
    private String username;
    private String nickname;

    public MemberRegisterResponse() {
    }

    public MemberRegisterResponse(Long id, String username, String nickname) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
