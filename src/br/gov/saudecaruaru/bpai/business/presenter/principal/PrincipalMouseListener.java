/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.principal;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Albuquerque
 */
public class PrincipalMouseListener {

    public static class BPAIMouseListener implements MouseListener {

        private PrincipalPresenter presenter;

        public BPAIMouseListener(PrincipalPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            this.presenter.abrirBPAI();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    public static class SIABMouseListener implements MouseListener {

        private PrincipalPresenter presenter;

        public SIABMouseListener(PrincipalPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            this.presenter.abrirSIAB();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    public static class ContatoMouseListener implements MouseListener {

        private PrincipalPresenter presenter;

        public ContatoMouseListener(PrincipalPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    public static class SobreMouseListener implements MouseListener {

        private PrincipalPresenter presenter;

        public SobreMouseListener(PrincipalPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
}
