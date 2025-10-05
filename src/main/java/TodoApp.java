/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author Asus
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Aplicación simple de Lista de Tareas
 * @author Tu Nombre
 */
public class TodoApp extends JFrame {
    
    private JTextField inputField;
    private DefaultListModel<Task> listModel;
    private JList<Task> taskList;
    private JButton addBtn, completeBtn, deleteBtn;
    
    public TodoApp() {
        initComponents();
        setupEvents();
        setupWindow();
    }
    
    private void initComponents() {
        inputField = new JTextField(20);
        addBtn = new JButton("Añadir");
        completeBtn = new JButton("Completar");
        deleteBtn = new JButton("Eliminar");
        
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskList.setCellRenderer(new TaskRenderer());
        
        completeBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
    }
    
    private void setupEvents() {
        // Añadir tarea
        ActionListener addTask = e -> addTask();
        addBtn.addActionListener(addTask);
        inputField.addActionListener(addTask);
        
        // Completar tarea
        completeBtn.addActionListener(e -> toggleComplete());
        
        // Eliminar tarea
        deleteBtn.addActionListener(e -> deleteTask());
        
        // Doble clic para completar
        taskList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) toggleComplete();
            }
        });
        
        // Habilitar botones según selección
        taskList.addListSelectionListener(e -> {
            boolean selected = !taskList.isSelectionEmpty();
            completeBtn.setEnabled(selected);
            deleteBtn.setEnabled(selected);
        });
    }
    
    private void setupWindow() {
        setTitle("Lista de Tareas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Panel superior
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Tarea:"));
        topPanel.add(inputField);
        topPanel.add(addBtn);
        
        // Panel inferior
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(completeBtn);
        bottomPanel.add(deleteBtn);
        
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(taskList), BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        
        pack();
        setLocationRelativeTo(null);
    }
    
    private void addTask() {
        String text = inputField.getText().trim();
        if (!text.isEmpty()) {
            listModel.addElement(new Task(text));
            inputField.setText("");
            inputField.requestFocus();
        }
    }
    
    private void toggleComplete() {
        int index = taskList.getSelectedIndex();
        if (index >= 0) {
            Task task = listModel.getElementAt(index);
            task.toggleCompleted();
            taskList.repaint();
        }
    }
    
    private void deleteTask() {
        int index = taskList.getSelectedIndex();
        if (index >= 0) {
            listModel.removeElementAt(index);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TodoApp().setVisible(true));
    }
}

/**
 * Clase Task para representar una tarea
 */
class Task {
    private String text;
    private boolean completed;
    
    public Task(String text) {
        this.text = text;
        this.completed = false;
    }
    
    public String getText() { return text; }
    public boolean isCompleted() { return completed; }
    public void toggleCompleted() { completed = !completed; }
    
    @Override
    public String toString() { return text; }
}

/**
 * Renderer para mostrar tareas completadas tachadas
 */
class TaskRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, 
            int index, boolean isSelected, boolean cellHasFocus) {
        
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        
        if (value instanceof Task) {
            Task task = (Task) value;
            if (task.isCompleted()) {
                setText("<html><strike>" + task.getText() + "</strike></html>");
                if (!isSelected) setForeground(Color.GRAY);
            }
        }
        return this;
    }
}
