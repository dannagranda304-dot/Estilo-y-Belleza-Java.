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

public class Productos extends JFrame {

    public Productos() {
        setTitle("Estilo y Belleza - Productos");
        setSize(780, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel fondo = new JPanel(new BorderLayout(15, 15));
        fondo.setBackground(new Color(250, 243, 247));
        fondo.setBorder(new EmptyBorder(20, 25, 20, 25));

        JLabel titulo = new JLabel("GESTIÓN DE PRODUCTOS");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 25));
        titulo.setForeground(new Color(139, 75, 110));

        JButton agregar = new JButton("+ Nuevo producto");
        agregar.setBackground(new Color(170, 105, 140));
        agregar.setForeground(Color.WHITE);

        JPanel superior = new JPanel(new BorderLayout());
        superior.setOpaque(false);
        superior.add(titulo, BorderLayout.WEST);
        superior.add(agregar, BorderLayout.EAST);

        String[] columnas = {
            "ID", "Producto", "Categoría", "Precio", "Cantidad"
        };

        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        modelo.addRow(new Object[]{
            "1", "Champú", "Cabello", "$25.000", "15"
        });

        modelo.addRow(new Object[]{
            "2", "Esmalte", "Uñas", "$8.000", "20"
        });

        modelo.addRow(new Object[]{
            "3", "Crema hidratante", "Piel", "$30.000", "10"
        });

        JTable tabla = new JTable(modelo);
        tabla.setRowHeight(30);
        tabla.getTableHeader().setBackground(
                new Color(230, 202, 218));

        JScrollPane desplazamiento = new JScrollPane(tabla);

        agregar.addActionListener(e -> {
            JTextField nombre = new JTextField();
            JTextField categoria = new JTextField();
            JTextField precio = new JTextField();
            JTextField cantidad = new JTextField();

            Object[] campos = {
                "Nombre del producto:", nombre,
                "Categoría:", categoria,
                "Precio:", precio,
                "Cantidad disponible:", cantidad
            };

            int resultado = JOptionPane.showConfirmDialog(
                    this, campos, "Registrar producto",
                    JOptionPane.OK_CANCEL_OPTION);

            if (resultado == JOptionPane.OK_OPTION) {
                if (nombre.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(
                            this, "Escribe el nombre del producto.");
                } else {
                    modelo.addRow(new Object[]{
                        modelo.getRowCount() + 1,
                        nombre.getText().trim(),
                        categoria.getText().trim(),
                        precio.getText().trim(),
                        cantidad.getText().trim()
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
            new Productos().setVisible(true);
        });
    }
}

