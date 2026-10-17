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

public class Servicios extends JFrame {

    public Servicios() {
        setTitle("Estilo y Belleza - Servicios");
        setSize(780, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel fondo = new JPanel(new BorderLayout(15, 15));
        fondo.setBackground(new Color(250, 243, 247));
        fondo.setBorder(new EmptyBorder(20, 25, 20, 25));

        JLabel titulo = new JLabel("GESTIÓN DE SERVICIOS");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 25));
        titulo.setForeground(new Color(139, 75, 110));

        JButton agregar = new JButton("+ Nuevo servicio");
        agregar.setBackground(new Color(170, 105, 140));
        agregar.setForeground(Color.WHITE);

        JPanel superior = new JPanel(new BorderLayout());
        superior.setOpaque(false);
        superior.add(titulo, BorderLayout.WEST);
        superior.add(agregar, BorderLayout.EAST);

        String[] columnas = {
            "ID", "Servicio", "Descripción", "Precio", "Duración"
        };

        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        modelo.addRow(new Object[]{
            "1", "Corte de cabello", "Corte y peinado",
            "$25.000", "30 min"
        });

        modelo.addRow(new Object[]{
            "2", "Manicure", "Arreglo y esmaltado de uñas",
            "$20.000", "45 min"
        });

        modelo.addRow(new Object[]{
            "3", "Tinte", "Coloración del cabello",
            "$80.000", "120 min"
        });

        JTable tabla = new JTable(modelo);
        tabla.setRowHeight(30);
        tabla.getTableHeader().setBackground(
                new Color(230, 202, 218));

        JScrollPane desplazamiento = new JScrollPane(tabla);

        agregar.addActionListener(e -> {
            JTextField nombre = new JTextField();
            JTextField descripcion = new JTextField();
            JTextField precio = new JTextField();
            JTextField duracion = new JTextField();

            Object[] campos = {
                "Nombre del servicio:", nombre,
                "Descripción:", descripcion,
                "Precio:", precio,
                "Duración (minutos):", duracion
            };

            int resultado = JOptionPane.showConfirmDialog(
                    this, campos, "Registrar servicio",
                    JOptionPane.OK_CANCEL_OPTION);

            if (resultado == JOptionPane.OK_OPTION) {
                if (nombre.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(
                            this, "Escribe el nombre del servicio.");
                } else {
                    modelo.addRow(new Object[]{
                        modelo.getRowCount() + 1,
                        nombre.getText().trim(),
                        descripcion.getText().trim(),
                        precio.getText().trim(),
                        duracion.getText().trim() + " min"
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
            new Servicios().setVisible(true);
        });
    }
}

