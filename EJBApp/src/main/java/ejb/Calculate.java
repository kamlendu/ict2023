/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ejb;

import javax.ejb.Remote;

/**
 *
 * @author root
 */
@Remote
public interface Calculate {
    
    int multiply(int x, int y);
}
