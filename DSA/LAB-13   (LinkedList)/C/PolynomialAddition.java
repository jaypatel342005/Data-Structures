// Node class to represent a term in the polynomial
class Node {
    int coefficient;
    int exponent;
    Node next;

    Node(int coeff, int exp) {
        coefficient = coeff;
        exponent = exp;
        next = null;
    }
}

// Polynomial class to represent a polynomial equation
class Polynomial {
    Node head;

    // Constructor to initialize an empty polynomial
    Polynomial() {
        head = null;
    }

    // Function to add a term to the polynomial
    void addTerm(int coeff, int exp) {
        Node newNode = new Node(coeff, exp);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Function to perform addition of two polynomials
    Polynomial addPolynomials(Polynomial poly) {
        Polynomial result = new Polynomial();
        Node p1 = this.head;
        Node p2 = poly.head;

        while (p1 != null && p2 != null) {
            if (p1.exponent == p2.exponent) {
                int sumCoeff = p1.coefficient + p2.coefficient;
                if (sumCoeff != 0) {
                    result.addTerm(sumCoeff, p1.exponent);
                }
                p1 = p1.next;
                p2 = p2.next;
            } else if (p1.exponent > p2.exponent) {
                result.addTerm(p1.coefficient, p1.exponent);
                p1 = p1.next;
            } else {
                result.addTerm(p2.coefficient, p2.exponent);
                p2 = p2.next;
            }
        }

        // Add remaining terms of first polynomial, if any
        while (p1 != null) {
            result.addTerm(p1.coefficient, p1.exponent);
            p1 = p1.next;
        }

        // Add remaining terms of second polynomial, if any
        while (p2 != null) {
            result.addTerm(p2.coefficient, p2.exponent);
            p2 = p2.next;
        }

        return result;
    }

    // Function to display the polynomial
    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.coefficient + "x^" + current.exponent);
            current = current.next;
            if (current != null) {
                System.out.print(" + ");
            }
        }
        System.out.println();
    }
}

public class PolynomialAddition {
    public static void main(String[] args) {
        // Create first polynomial: 3x^2 + 2x + 1
        Polynomial poly1 = new Polynomial();
        poly1.addTerm(3, 2);
        poly1.addTerm(2, 1);
        poly1.addTerm(1, 0);

        // Create second polynomial: 4x^3 + 2x^2 + 5x + 2
        Polynomial poly2 = new Polynomial();
        poly2.addTerm(4, 3);
        poly2.addTerm(2, 2);
        poly2.addTerm(5, 1);
        poly2.addTerm(2, 0);

        // Display the polynomials
        System.out.println("Polynomial 1: ");
        poly1.display();
        System.out.println("Polynomial 2: ");
        poly2.display();

        // Perform addition of the polynomials
        Polynomial sum = poly1.addPolynomials(poly2);

        // Display the result
        System.out.println("\nSum of the polynomials: ");
        sum.display();
    }
}
