/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package semana16;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * Demostración de captura de tecla 'C' en Java Swing
 * Implementa tres enfoques diferentes: KeyListener, KeyAdapter y Key Bindings
 * 
 * @author Tu Nombre
 * @version 1.0
 */
public class KeyCaptureDemo extends JFrame {
    
    // Componentes de la interfaz
    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    private JTextArea logArea;
    private JButton actionButton;
    
    public KeyCaptureDemo() {
        initializeUI();
        setupKeyListeners();
    }
    
    /**
     * Inicializa los componentes de la interfaz gráfica
     */
    private void initializeUI() {
        setTitle("Captura de Tecla 'C' - Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setSize(700, 500);
        
        // Panel principal con padding
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Crear y configurar la lista
        createTaskList();
        
        // Crear panel de log
        createLogPanel();
        
        // Crear botón de acción
        createActionButton();
        
        // Agregar componentes al panel principal
        mainPanel.add(createListPanel(), BorderLayout.WEST);
        mainPanel.add(createLogPanel(), BorderLayout.CENTER);
        mainPanel.add(actionButton, BorderLayout.SOUTH);
        
        add(mainPanel);
        
        // Instrucciones
        JLabel instructions = new JLabel(
            "<html><b>Instrucciones:</b> Selecciona un elemento de la lista y presiona 'C' " +
            "para alternar su estado | Presiona 'C' en el botón para acción especial</html>"
        );
        instructions.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        add(instructions, BorderLayout.NORTH);
        
        setLocationRelativeTo(null);
    }
    
    /**
     * Crea y configura la lista de tareas
     */
    private void createTaskList() {
        listModel = new DefaultListModel<>();
        listModel.addElement("☐ Tarea 1: Estudiar Java Swing");
        listModel.addElement("☐ Tarea 2: Implementar KeyListener");
        listModel.addElement("☐ Tarea 3: Probar Key Bindings");
        listModel.addElement("☐ Tarea 4: Documentar código");
        listModel.addElement("☐ Tarea 5: Subir a GitHub");
        
        taskList = new JList<>(listModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        taskList.setSelectedIndex(0);
        taskList.setFont(new Font("Monospaced", Font.PLAIN, 14));
    }
    
    /**
     * Crea el panel que contiene la lista
     */
    private JScrollPane createListPanel() {
        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setPreferredSize(new Dimension(300, 0));
        scrollPane.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(),
            "Lista de Tareas (presiona 'C' para alternar)",
            TitledBorder.LEFT,
            TitledBorder.TOP
        ));
        return scrollPane;
    }
    
    /**
     * Crea el panel de log para mostrar eventos
     */
    private JScrollPane createLogPanel() {
        logArea = new JTextArea();
        logArea.setEditable(false);
        logArea.setFont(new Font("Consolas", Font.PLAIN, 12));
        logArea.setLineWrap(true);
        logArea.setWrapStyleWord(true);
        
        JScrollPane scrollPane = new JScrollPane(logArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(),
            "Registro de Eventos",
            TitledBorder.LEFT,
            TitledBorder.TOP
        ));
        
        log("Aplicación iniciada. Esperando eventos de teclado...\n");
        
        return scrollPane;
    }
    
    /**
     * Crea el botón de acción
     */
    private void createActionButton() {
        actionButton = new JButton("Botón de Acción (también responde a 'C')");
        actionButton.setFont(new Font("Arial", Font.BOLD, 12));
        actionButton.addActionListener(e -> {
            log("Botón clickeado manualmente");
        });
    }
    
    /**
     * Configura los diferentes listeners de teclado
     * Demuestra tres enfoques: KeyListener, KeyAdapter y Key Bindings
     */
    private void setupKeyListeners() {
        
        // ENFOQUE 1: Usando KeyAdapter (más limpio que KeyListener)
        // Se aplica a la lista de tareas
        taskList.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Detectar si se presionó la tecla 'C'
                if (e.getKeyCode() == KeyEvent.VK_C) {
                    handleCKeyOnList();
                }
            }
        });
        
        // ENFOQUE 2: Usando Key Bindings (recomendado para Swing)
        // Se aplica al botón de acción
        setupKeyBindings();
        
        // ENFOQUE 3: KeyListener completo (ejemplo educativo)
        // Se aplica al área de log
        logArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // No usado en este ejemplo
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_C) {
                    log("Tecla 'C' presionada en el área de log (usando KeyListener)");
                }
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                // No usado en este ejemplo
            }
        });
    }
    
    /**
     * Configura Key Bindings para el botón
     * Este es el enfoque recomendado en Swing moderno
     */
    private void setupKeyBindings() {
        // Obtener el InputMap y ActionMap del botón
        InputMap inputMap = actionButton.getInputMap(JComponent.WHEN_FOCUSED);
        ActionMap actionMap = actionButton.getActionMap();
        
        // Mapear la tecla 'C' a una acción
        KeyStroke cKeyStroke = KeyStroke.getKeyStroke('C');
        inputMap.put(cKeyStroke, "cKeyAction");
        
        // Definir la acción a ejecutar
        actionMap.put("cKeyAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log("Tecla 'C' capturada en el botón usando Key Bindings");
                log("Ejecutando acción especial del botón...");
                JOptionPane.showMessageDialog(
                    KeyCaptureDemo.this,
                    "¡Acción especial ejecutada con tecla 'C'!",
                    "Key Binding Activado",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
        
        // También mapear 'c' minúscula
        KeyStroke cLowerKeyStroke = KeyStroke.getKeyStroke('c');
        inputMap.put(cLowerKeyStroke, "cKeyAction");
    }
    
    /**
     * Maneja el evento de presionar 'C' en la lista
     * Alterna el estado de la tarea seleccionada
     */
    private void handleCKeyOnList() {
        int selectedIndex = taskList.getSelectedIndex();
        
        if (selectedIndex != -1) {
            String currentItem = listModel.getElementAt(selectedIndex);
            String newItem;
            
            // Alternar entre completado y no completado
            if (currentItem.startsWith("☐")) {
                newItem = currentItem.replace("☐", "☑");
                log("Tarea marcada como COMPLETADA: " + currentItem.substring(2));
            } else {
                newItem = currentItem.replace("☑", "☐");
                log("Tarea marcada como PENDIENTE: " + currentItem.substring(2));
            }
            
            // Actualizar el elemento en la lista
            listModel.setElementAt(newItem, selectedIndex);
            
            // Mantener la selección
            taskList.setSelectedIndex(selectedIndex);
            
        } else {
            log("No hay ninguna tarea seleccionada");
        }
    }
    
    /**
     * Agrega un mensaje al área de log con timestamp
     */
    private void log(String message) {
        String timestamp = String.format("[%tT] ", System.currentTimeMillis());
        logArea.append(timestamp + message + "\n");
        
        // Auto-scroll al final
        logArea.setCaretPosition(logArea.getDocument().getLength());
        
        // También imprimir en consola
        System.out.println(timestamp + message);
    }
    
    /**
     * Método principal para ejecutar la aplicación
     */
    public static void main(String[] args) {
        // Usar el Look and Feel del sistema
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Crear y mostrar la interfaz en el Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            KeyCaptureDemo demo = new KeyCaptureDemo();
            demo.setVisible(true);
        });
    }
}