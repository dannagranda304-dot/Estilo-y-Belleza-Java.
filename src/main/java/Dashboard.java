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

public class Dashboard extends JFrame {

    public Dashboard() {
        setTitle("Estilo y Belleza - Menú principal");
        setSize(750, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel fondo = new JPanel(new BorderLayout(15, 15));
        fondo.setBackground(new Color(250, 243, 247));
        fondo.setBorder(new EmptyBorder(25, 30, 25, 30));

        JLabel titulo = new JLabel(
                "ESTILO Y BELLEZA", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 28));
        titulo.setForeground(new Color(139, 75, 110));

        JLabel subtitulo = new JLabel(
                "Sistema de gestión para salón de belleza",
                SwingConstants.CENTER);
        subtitulo.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JPanel encabezado = new JPanel(new GridLayout(2, 1, 5, 5));
        encabezado.setOpaque(false);
        encabezado.add(titulo);
        encabezado.add(subtitulo);

        JPanel menu = new JPanel(new GridLayout(2, 3, 15, 15));
        menu.setOpaque(false);

        String[] opciones = {
            "Clientes", "Empleados", "Servicios",
            "Productos", "Citas", "Ventas"
        };

        for (String opcion : opciones) {
            JButton boton = new JButton(opcion);
            boton.setFont(new Font("SansSerif", Font.BOLD, 16));
            boton.setBackground(new Color(230, 202, 218));
            boton.setForeground(new Color(90, 55, 75));
            boton.setFocusPainted(false);
            menu.add(boton);
        }

        JLabel pie = new JLabel(
                "Bienvenida al menú principal",
                SwingConstants.CENTER);
        pie.setFont(new Font("SansSerif", Font.ITALIC, 12));

        fondo.add(encabezado, BorderLayout.NORTH);
        fondo.add(menu, BorderLayout.CENTER);
        fondo.add(pie, BorderLayout.SOUTH);

        setContentPane(fondo);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Dashboard().setVisible(true);
        });
    }
}

