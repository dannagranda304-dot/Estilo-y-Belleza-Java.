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

public class Ventas extends JFrame {

    public Ventas() {
        setTitle("Estilo y Belleza - Ventas");
        setSize(780, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel fondo = new JPanel(new BorderLayout(15, 15));
        fondo.setBackground(new Color(250, 243, 247));
        fondo.setBorder(new EmptyBorder(20, 25, 20, 25));

        JLabel titulo = new JLabel("REGISTRO DE VENTAS");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 25));
        titulo.setForeground(new Color(139, 75, 110));

        JButton agregar = new JButton("+ Nueva venta");
        agregar.setBackground(new Color(170, 105, 140));
        agregar.setForeground(Color.WHITE);

        JPanel superior = new JPanel(new BorderLayout());
        superior.setOpaque(false);
        superior.add(titulo, BorderLayout.WEST);
        superior.add(agregar, BorderLayout.EAST);

        String[] columnas = {
            "ID", "Cliente", "Producto o servicio", "Cantidad", "Total"
        };

        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        modelo.addRow(new Object[]{
            "1", "María López", "Corte de cabello", "1", "$25.000"
        });

        modelo.addRow(new Object[]{
            "2", "Laura Gómez", "Esmalte", "2", "$16.000"
        });

        JTable tabla = new JTable(modelo);
        tabla.setRowHeight(30);
        tabla.getTableHeader().setBackground(
                new Color(230, 202, 218));

        JScrollPane desplazamiento = new JScrollPane(tabla);

        agregar.addActionListener(e -> {
            JTextField cliente = new JTextField();
            JTextField concepto = new JTextField();
            JTextField cantidad = new JTextField();
            JTextField total = new JTextField();

            Object[] campos = {
                "Nombre del cliente:", cliente,
                "Producto o servicio:", concepto,
                "Cantidad:", cantidad,
                "Total de la venta:", total
            };

            int resultado = JOptionPane.showConfirmDialog(
                    this, campos, "Registrar venta",
                    JOptionPane.OK_CANCEL_OPTION);

            if (resultado == JOptionPane.OK_OPTION) {
                if (cliente.getText().trim().isEmpty()
                        || concepto.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Completa el cliente y el producto o servicio.");
                } else {
                    modelo.addRow(new Object[]{
                        modelo.getRowCount() + 1,
                        cliente.getText().trim(),
                        concepto.getText().trim(),
                        cantidad.getText().trim(),
                        total.getText().trim()
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
            new Ventas().setVisible(true);
        });
    }
}

