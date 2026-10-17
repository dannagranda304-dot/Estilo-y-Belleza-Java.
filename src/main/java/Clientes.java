/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gisel
 */

package com.mycompany.estiloybellezajava;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Clientes extends JFrame {

    public Clientes() {
        setTitle("Estilo y Belleza - Clientes");
        setSize(750, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel fondo = new JPanel(new BorderLayout(15, 15));
        fondo.setBackground(new Color(250, 243, 247));
        fondo.setBorder(new EmptyBorder(20, 25, 20, 25));

        JLabel titulo = new JLabel("GESTIÓN DE CLIENTES");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 25));
        titulo.setForeground(new Color(139, 75, 110));

        JButton agregar = new JButton("+ Nuevo cliente");
        agregar.setBackground(new Color(170, 105, 140));
        agregar.setForeground(Color.WHITE);

        JPanel superior = new JPanel(new BorderLayout());
        superior.setOpaque(false);
        superior.add(titulo, BorderLayout.WEST);
        superior.add(agregar, BorderLayout.EAST);

        String[] columnas = {
            "ID", "Nombre", "Teléfono", "Correo"
        };

        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        modelo.addRow(new Object[]{
            "1", "María López", "3001234567", "maria@email.com"
        });
        modelo.addRow(new Object[]{
            "2", "Laura Gómez", "3107654321", "laura@email.com"
        });

        JTable tabla = new JTable(modelo);
        tabla.setRowHeight(28);
        tabla.getTableHeader().setBackground(
                new Color(230, 202, 218));

        JScrollPane desplazamiento = new JScrollPane(tabla);

        agregar.addActionListener(e -> {
            JTextField nombre = new JTextField();
            JTextField telefono = new JTextField();
            JTextField correo = new JTextField();

            Object[] campos = {
                "Nombre:", nombre,
                "Teléfono:", telefono,
                "Correo:", correo
            };

            int resultado = JOptionPane.showConfirmDialog(
                    this, campos, "Registrar cliente",
                    JOptionPane.OK_CANCEL_OPTION);

            if (resultado == JOptionPane.OK_OPTION) {
                if (nombre.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(
                            this, "Escribe el nombre del cliente.");
                } else {
                    modelo.addRow(new Object[]{
                        modelo.getRowCount() + 1,
                        nombre.getText().trim(),
                        telefono.getText().trim(),
                        correo.getText().trim()
                    });
                }
            }
        });

        fondo.add(superior, BorderLayout.NORTH);
        fondo.add(desplazamiento, BorderLayout.CENTER);

        setContentPane(fondo);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Clientes().setVisible(true);
        });
    }
}

