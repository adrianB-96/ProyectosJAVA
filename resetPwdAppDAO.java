/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PassReset;

/**
 *
 * @author justh
 */
import java.util.*;
public interface resetPwdAppDAO {
    
    public String getPwdUser(String username) throws Exception;
    public int setPwdUser(String username) throws Exception;
    public String getSuperuser(String username) throws Exception;
    public List<Dispositivos> getDevices() throws Exception;
    public void updateDeviceEnabled(String id, boolean estado) throws Exception;
    public String updateAppEmpleados() throws Exception;
}
