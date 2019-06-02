package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.consultaProducto;
import modelo.producto;
import vista.frmProducto;

public class CtrlProducto implements ActionListener{
    
    private producto mod;
    private consultaProducto modC;
    private frmProducto frm;
    
    public CtrlProducto (producto mod, consultaProducto modC, frmProducto frm){
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnEdit.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);     
    }
    
    public void iniciar(){
        frm.setTitle("Productos");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==frm.btnGuardar){
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
            
            if (modC.registrar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo Guardar");
                limpiar();
            }
        }
        
        if(e.getSource()==frm.btnEdit){
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
            
            if (modC.modificar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo Modificar");
                limpiar();
            }
        }
        
        if(e.getSource()==frm.btnEliminar){
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            
            if (modC.eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo Eliminar");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnBuscar) {
            mod.setCodigo(frm.txtCodigo.getText());
            
            if(modC.buscar(mod))
            {
                frm.txtId.setText(String.valueOf(mod.getId()));
                frm.txtCodigo.setText(mod.getCodigo());
                frm.txtNombre.setText(mod.getNombre());
                frm.txtPrecio.setText(String.valueOf(mod.getPrecio()));
                frm.txtCantidad.setText(String.valueOf(mod.getCantidad()));

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();
            }
        }
        
        if(e.getSource()==frm.btnLimpiar){
            limpiar();
        }
    }
    
    public void limpiar(){
        frm.txtCodigo.setText(null);
        frm.txtNombre.setText(null);
        frm.txtPrecio.setText(null);
        frm.txtCantidad.setText(null);
    }
}
