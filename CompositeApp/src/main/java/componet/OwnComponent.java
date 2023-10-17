/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/FacesComponent.java to edit this template
 */
package componet;

import java.io.IOException;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

/**
 *
 * @author root
 */
@FacesComponent(createTag = true, tagName = "uppers", namespace = "http://example.com/tags" )
public class OwnComponent extends UIComponentBase {

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        super.encodeBegin(context); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    
        String val = (String) this.getAttributes().get("value");
        
        ResponseWriter writer = context.getResponseWriter();
        
        writer.write(val.toUpperCase());
    
    
    }
    
    
    
    
    
    @Override
    public String getFamily() {
        return "componet";
    }
    
}
