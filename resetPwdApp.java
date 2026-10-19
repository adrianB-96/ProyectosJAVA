/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PassReset;

/**
 *
 * @author justh
 */
public class resetPwdApp {
    private String username;
    private String login_pwd;
    private String is_superuser;
    private Dispositivos devices;

    public resetPwdApp(String username) {
        this.username = username;
    }

    public String getIs_superuser() {
        return is_superuser;
    }

    public void setIs_superuser(String is_superuser) {
        this.is_superuser = is_superuser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLogin_pwd() {
        return login_pwd;
    }

    public void setLogin_pwd(String login_pwd) {
        this.login_pwd = login_pwd;
    }

    @Override
    public String toString() {
        return "Usuario{" + "username=" + username + ", login_pwd=" + login_pwd + ", is_superuser=" + is_superuser + ", devices=" + devices + '}';
    }

    public Dispositivos getDevices() {
        return devices;
    }

    public void setDevices(Dispositivos devices) {
        this.devices = devices;
    }
}
