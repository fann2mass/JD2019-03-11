package by.it.khlystunova.jd01_12;

import java.util.Deque;
import java.util.LinkedList;

/*TaskC3.В консоль вводится строка,
состоящая из выражений и символов «(», «)», «[», «]», «{», «}».
Проверьте и выведите в консоль корректность расстановки скобок(true или false)
с помощью коллекций.*/

public class TaskC3 {
    public static void main(String[] args) {
        String expr="[1,1,1],{2,2,2},((2+2)*2)";
        System.out.println(expr+" "+TaskC3.isBracketsCorrect(expr));
        expr="[1,1,1],{{2,2,2},(2+2)*2)";
        System.out.println(expr+" "+TaskC3.isBracketsCorrect(expr));
    }

    private static boolean isBracketsCorrect(String expr) {
        StringBuilder s = new StringBuilder(expr);
        Deque<Character> bracketsRound = new LinkedList<>();
        Deque<Character> bracketsSquare = new LinkedList<>();
        Deque<Character> bracketsFigure = new LinkedList<>();
        char openBr = '(';
        char closeBr = ')';
        char openSquare = '[';
        char closeSquare = ']';
        char openFigure = '{';
        char closeFigure = '}';
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(': {
                    bracketsRound.addFirst(openBr);
                    break;
                }
                case ')':
                    bracketsRound.addLast(closeBr);
                    break;
                case '[': {
                    bracketsSquare.addFirst(openSquare);
                    break;
                }
                case ']':
                    bracketsSquare.addLast(closeSquare);
                    break;
                case '{': {
                    bracketsFigure.addFirst(openFigure);
                    break;
                }
                case '}':
                    bracketsFigure.addLast(closeFigure);
                    break;

                default:
                    break;
            }

        }
        while ((bracketsRound.peekFirst() == '(') && (bracketsRound.peekLast() == ')')) {
            bracketsRound.removeFirst();
            bracketsRound.removeLast();
            if(bracketsRound.isEmpty()) {
                break;
            }
        }
        while ((bracketsSquare.peekFirst() == '[') && (bracketsSquare.peekLast() == ']')) {
            bracketsSquare.removeFirst();
            bracketsSquare.removeLast();
            if(bracketsSquare.isEmpty()) {
                break;
            }
        }
        while ((bracketsFigure.peekFirst() == '{') && (bracketsFigure.peekLast() == '}')) {
            bracketsFigure.removeFirst();
            bracketsFigure.removeLast();
            if(bracketsFigure.isEmpty()) {
                break;
            }
        }
        return bracketsRound.isEmpty() && bracketsSquare.isEmpty() && bracketsFigure.isEmpty();
    }
}

