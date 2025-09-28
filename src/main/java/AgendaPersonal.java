/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package tareas.agendapersonal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AgendaPersonal extends JFrame {
    
    private JTable tabla;
    private DefaultTableModel modelo;
    private JSpinner spinnerFecha, spinnerHora;
    private JTextField txtDescripcion;
    
    public AgendaPersonal() {
        // Configurar ventana
        setTitle("Agenda Personal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Crear tabla
        modelo = new DefaultTableModel(new String[]{"Fecha", "Hora", "Descripción"}, 0);
        tabla = new JTable(modelo);
        
        // Crear spinners
        spinnerFecha = new JSpinner(new SpinnerDateModel());
        spinnerFecha.setEditor(new JSpinner.DateEditor(spinnerFecha, "dd/MM/yyyy"));
        
        spinnerHora = new JSpinner(new SpinnerDateModel());
        spinnerHora.setEditor(new JSpinner.DateEditor(spinnerHora, "HH:mm"));
        
        // Campo descripción
        txtDescripcion = new JTextField(15);
        
        // Panel entrada
        JPanel panelEntrada = new JPanel();
        panelEntrada.add(new JLabel("Fecha:"));
        panelEntrada.add(spinnerFecha);
        panelEntrada.add(new JLabel("Hora:"));
        panelEntrada.add(spinnerHora);
        panelEntrada.add(new JLabel("Descripción:"));
        panelEntrada.add(txtDescripcion);
        
        // Botones
        JPanel panelBotones = new JPanel();
        JButton btnAgregar = new JButton("Agregar");
        JButton btnEliminar = new JButton("Eliminar Seleccionado");
        JButton btnSalir = new JButton("Salir");
        
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnSalir);
        
        // Eventos
        btnAgregar.addActionListener(e -> agregarEvento());
        btnEliminar.addActionListener(e -> eliminarEvento());
        btnSalir.addActionListener(e -> dispose());
        
        // Agregar componentes
        add(panelEntrada, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void agregarEvento() {
        String descripcion = txtDescripcion.getText().trim();
        
        if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "La descripción no puede estar vacía", 
                "Validación", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
        
        String fecha = formatoFecha.format((Date) spinnerFecha.getValue());
        String hora = formatoHora.format((Date) spinnerHora.getValue());
        
        modelo.addRow(new Object[]{fecha, hora, descripcion});
        txtDescripcion.setText("");
        txtDescripcion.requestFocus();
    }
    
    private void eliminarEvento() {
        int fila = tabla.getSelectedRow();
        
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un evento primero");
            return;
        }
        
        int respuesta = JOptionPane.showConfirmDialog(this,
            "¿Eliminar el evento seleccionado?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION);
            
        if (respuesta == JOptionPane.YES_OPTION) {
            modelo.removeRow(fila);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AgendaPersonal());
    }
}