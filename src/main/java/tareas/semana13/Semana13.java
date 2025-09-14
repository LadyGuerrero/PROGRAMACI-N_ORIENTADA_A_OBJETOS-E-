/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package tareas.semana13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Aplicación GUI simple para gestión de tareas - Semana 13
 * @author Tu Nombre
 */
public class Semana13 extends JFrame {
    
    private JTextField campoTexto;
    private DefaultListModel<String> modelo;
    private JList<String> lista;
    
    public Semana13() {
        // Configurar ventana
        setTitle("Lista de Tareas - Semana 13");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Crear componentes
        JLabel etiqueta = new JLabel("Ingrese tarea:");
        campoTexto = new JTextField(20);
        JButton btnAgregar = new JButton("Agregar");
        JButton btnLimpiar = new JButton("Limpiar");
        
        modelo = new DefaultListModel<>();
        lista = new JList<>(modelo);
        
        // Panel superior con entrada
        JPanel panelEntrada = new JPanel(new FlowLayout());
        panelEntrada.add(etiqueta);
        panelEntrada.add(campoTexto);
        panelEntrada.add(btnAgregar);
        panelEntrada.add(btnLimpiar);
        
        // Agregar componentes a la ventana
        add(panelEntrada, BorderLayout.NORTH);
        add(new JScrollPane(lista), BorderLayout.CENTER);
        
        // Eventos de botones
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String texto = campoTexto.getText().trim();
                // Validar entrada vacía
                if (!texto.isEmpty()) {
                    modelo.addElement(texto);
                    campoTexto.setText("");
                    campoTexto.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese una tarea válida");
                    campoTexto.requestFocus();
                }
            }
        });
        
        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modelo.clear();
                campoTexto.setText("");
                campoTexto.requestFocus();
            }
        });
        
        // Permitir agregar con Enter
        campoTexto.addActionListener(e -> btnAgregar.doClick());
        
        // Configurar ventana
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    /**
     * Método main para ejecutar la aplicación
     */
    public static void main(String[] args) {
        // Ejecutar aplicación en Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new Semana13());
    }
}