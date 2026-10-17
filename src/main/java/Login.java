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

public class Login extends JFrame {

    private JTextField campoUsuario;
    private JPasswordField campoContrasena;

    public Login() {
        setTitle("Estilo y Belleza - Inicio de sesión");
        setSize(480, 540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel fondo = new JPanel(new BorderLayout());
        fondo.setBackground(new Color(250, 243, 247));
        fondo.setBorder(new EmptyBorder(25, 35, 30, 35));

        JLabel titulo = new JLabel("Estilo y Belleza", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 30));
        titulo.setForeground(new Color(139, 75, 110));

        JLabel subtitulo = new JLabel(
                "Sistema de gestión para salón de belleza",
                SwingConstants.CENTER
        );
        subtitulo.setFont(new Font("SansSerif", Font.PLAIN, 13));
        subtitulo.setForeground(new Color(100, 85, 95));

        JPanel encabezado = new JPanel(new GridLayout(2, 1, 5, 5));
        encabezado.setOpaque(false);
        encabezado.add(titulo);
        encabezado.add(subtitulo);

        JPanel formulario = new JPanel(new GridLayout(5, 1, 8, 8));
        formulario.setOpaque(false);
        formulario.setBorder(new EmptyBorder(35, 10, 20, 10));

        JLabel etiquetaUsuario = new JLabel("Usuario");
        etiquetaUsuario.setFont(new Font("SansSerif", Font.BOLD, 14));

        campoUsuario = new JTextField();
        campoUsuario.setFont(new Font("SansSerif", Font.PLAIN, 15));

        JLabel etiquetaContrasena = new JLabel("Contraseña");
        etiquetaContrasena.setFont(new Font("SansSerif", Font.BOLD, 14));

        campoContrasena = new JPasswordField();
        campoContrasena.setFont(new Font("SansSerif", Font.PLAIN, 15));

        JButton botonIngresar = new JButton("Ingresar");
        botonIngresar.setFont(new Font("SansSerif", Font.BOLD, 15));
        botonIngresar.setBackground(new Color(170, 105, 140));
        botonIngresar.setForeground(Color.WHITE);
        botonIngresar.setFocusPainted(false);
        botonIngresar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        botonIngresar.addActionListener(e -> {
            String usuario = campoUsuario.getText().trim();
            String contrasena =
                    new String(campoContrasena.getPassword());

            if (usuario.isEmpty() || contrasena.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Por favor, completa el usuario y la contraseña.",
                        "Campos pendientes",
                        JOptionPane.WARNING_MESSAGE
                );
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Los campos se ingresaron correctamente.\n"
                        + "El acceso real se conectará en una etapa posterior.",
                        "Estilo y Belleza",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        formulario.add(etiquetaUsuario);
        formulario.add(campoUsuario);
        formulario.add(etiquetaContrasena);
        formulario.add(campoContrasena);
        formulario.add(botonIngresar);

        JLabel pie = new JLabel(
                "Bienvenida a nuestro espacio de belleza",
                SwingConstants.CENTER
        );
        pie.setFont(new Font("SansSerif", Font.ITALIC, 12));
        pie.setForeground(new Color(120, 100, 115));

        fondo.add(encabezado, BorderLayout.NORTH);
        fondo.add(formulario, BorderLayout.CENTER);
        fondo.add(pie, BorderLayout.SOUTH);

        setContentPane(fondo);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}

