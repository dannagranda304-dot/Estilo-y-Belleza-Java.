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

public class Citas extends JFrame {

    public Citas() {
        setTitle("Estilo y Belleza - Citas");
        setSize(800, 460);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel fondo = new JPanel(new BorderLayout(15, 15));
        fondo.setBackground(new Color(250, 243, 247));
        fondo.setBorder(new EmptyBorder(20, 25, 20, 25));

        JLabel titulo = new JLabel("GESTIÓN DE CITAS");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 25));
        titulo.setForeground(new Color(139, 75, 110));

        JButton agregar = new JButton("+ Nueva cita");
        agregar.setBackground(new Color(170, 105, 140));
        agregar.setForeground(Color.WHITE);

        JPanel superior = new JPanel(new BorderLayout());
        superior.setOpaque(false);
        superior.add(titulo, BorderLayout.WEST);
        superior.add(agregar, BorderLayout.EAST);

        String[] columnas = {
            "ID", "Cliente", "Servicio", "Fecha", "Hora"
        };

        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        modelo.addRow(new Object[]{
            "1", "María López", "Corte de cabello",
            "20/10/2026", "10:00 a. m."
        });

        modelo.addRow(new Object[]{
            "2", "Laura Gómez", "Manicure",
            "21/10/2026", "2:00 p. m."
        });

        JTable tabla = new JTable(modelo);
        tabla.setRowHeight(30);
        tabla.getTableHeader().setBackground(
                new Color(230, 202, 218));

        JScrollPane desplazamiento = new JScrollPane(tabla);

        agregar.addActionListener(e -> {
            JTextField cliente = new JTextField();
            JTextField servicio = new JTextField();
            JTextField fecha = new JTextField();
            JTextField hora = new JTextField();

            Object[] campos = {
                "Nombre del cliente:", cliente,
                "Servicio:", servicio,
                "Fecha (DD/MM/AAAA):", fecha,
                "Hora:", hora
            };

            int resultado = JOptionPane.showConfirmDialog(
                    this, campos, "Registrar cita",
                    JOptionPane.OK_CANCEL_OPTION);

            if (resultado == JOptionPane.OK_OPTION) {
                if (cliente.getText().trim().isEmpty()
                        || fecha.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Completa como mínimo el cliente y la fecha.");
                } else {
                    modelo.addRow(new Object[]{
                        modelo.getRowCount() + 1,
                        cliente.getText().trim(),
                        servicio.getText().trim(),
                        fecha.getText().trim(),
                        hora.getText().trim()
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
            new Citas().setVisible(true);
        });
    }
}

