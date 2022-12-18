package org.celsoaquino.view;

import javax.swing.*;

public class ProceedView {
    public ProceedView() {
        this.init();
    }

    public void init() {
      int input =  JOptionPane.showConfirmDialog(null, "Deseja continuar?" );
      switch (input) {
          case 0 -> new Menu();
          case 1 -> JOptionPane.showMessageDialog(null, "Programa finalizado");
          case 2 -> JOptionPane.showMessageDialog(null, "Programa Concluído");
      }
    }
}
