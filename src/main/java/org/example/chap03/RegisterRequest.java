package org.example.chap03;

// 회원가입을 처리할 떄 필요한 이메일, 암호, 이름 데이터를 담고있는 클래스
public class RegisterRequest {
    private String email;
    private String password;
    private String confirmPassword;
    private String name;
    
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPasswordEqualToConfirmPassword(){
        return password.equals(confirmPassword);
    }
}
