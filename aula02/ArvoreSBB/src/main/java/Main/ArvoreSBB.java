/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Thiago Ribeiro
 */
public class ArvoreSBB {
    
    private static class No {
        
        Item reg;
        No esq, dir;
        byte incE, incD;
        
        private No ee(No ap) {
            No ap1 = ap.esq;
            ap.esq = ap1.dir;
            ap1.dir = ap;
            ap1.incE = Vertical;
            ap.incE = Vertical;
            ap = ap1;
            return ap;
        }
 
        private No ed(No ap) {
            No ap1 = ap.esq;
            No ap2 = ap1.dir;
            ap1.incD = Vertical;
            ap.incE = Vertical;
            ap1.dir = ap2.esq;
            ap2.esq = ap1;
            ap.esq = ap2.dir;
            ap2.dir = ap;
            ap = ap2;
            return ap;
        }

        private No dd(No ap) {
            No ap1 = ap.dir;
            ap.dir = ap1.esq;
            ap1.esq = ap;
            ap1.incD = Vertical;
            ap.incD = Vertical;
            ap = ap1;
            return ap;
        }

        private No de(No ap) {
            No ap1 = ap.dir;
            No ap2 = ap1.esq;
            ap1.incE = Vertical;
            ap.incD = Vertical;
            ap1.esq = ap2.dir;
            ap2.dir = ap1;
            ap.dir = ap2.esq;
            ap2.esq = ap;
            ap = ap2;
            return ap;
        }

    }

}
