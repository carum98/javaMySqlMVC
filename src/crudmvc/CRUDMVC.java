
package crudmvc;

import controlador.CtrlProducto;
import modelo.consultaProducto;
import modelo.producto;
import vista.frmProducto;

public class CRUDMVC {


    public static void main(String[] args) {
        producto mod = new producto();
        consultaProducto modC = new consultaProducto();
        frmProducto frm = new frmProducto();
        
        CtrlProducto ctrl = new CtrlProducto(mod,modC,frm);
        
        ctrl.iniciar();
        
        frm.setVisible(true);
    }
    
}
