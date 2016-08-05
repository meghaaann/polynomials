package odometer;
public class Polynomial {
	private int[] coef;  // coefficients
	private int deg;     // degree of polynomial (0 for the zero polynomial)

	// a * x^b
	public Polynomial(int a, int b) {
		coef = new int[b+1];
		coef[b] = a;
		deg = degree();
	}

	// return the degree of this polynomial (0 for the zero polynomial)
	public int degree() {
		int d = 0;
		for (int i = 0; i < coef.length; i++)
			if (coef[i] != 0) d = i;
		return d;
	}

	// return c = a + b
	public Polynomial plus(Polynomial b) {
		Polynomial a = this;
		Polynomial c = new Polynomial(0, Math.max(a.deg, b.deg));
		for (int i = 0; i <= a.deg; i++) c.coef[i] += a.coef[i];
		for (int i = 0; i <= b.deg; i++) c.coef[i] += b.coef[i];
		c.deg = c.degree();
		return c;
	}

	// return (a - b)
	public Polynomial minus(Polynomial b) {
		Polynomial a = this;
		Polynomial c = new Polynomial(0, Math.max(a.deg, b.deg));
		for (int i = 0; i <= a.deg; i++) c.coef[i] += a.coef[i];
		for (int i = 0; i <= b.deg; i++) c.coef[i] -= b.coef[i];
		c.deg = c.degree();
		return c;
	}

	// return (a * b)
	public Polynomial times(Polynomial b) {
		Polynomial a = this;
		Polynomial c = new Polynomial(0, a.deg + b.deg);
		for (int i = 0; i <= a.deg; i++)
		for (int j = 0; j <= b.deg; j++)
		c.coef[i+j] += (a.coef[i] * b.coef[j]);
		c.deg = c.degree();
		return c;
	}

	// do a and b represent the same polynomial?
	public boolean eq(Polynomial b) {
		Polynomial a = this;
		if (a.deg != b.deg) return false;
		for (int i = a.deg; i >= 0; i--)
		if (a.coef[i] != b.coef[i]) return false;
		return true;
	}
	
	// convert to string representation
	public String toString() {
		if (deg ==  0) return "" + coef[0];
		if (deg ==  1) return coef[1] + "x + " + coef[0];
     		String s = coef[deg] + "x^" + deg;
			for (int i = deg-1; i >= 0; i--) {
				if(coef[i] == 0) continue;
				else if (coef[i]  > 0) s = s + " + " + ( coef[i]);
				else if (coef[i]  < 0) s = s + " - " + (-coef[i]);
				if(i == 1) s = s + "x";
				else if (i >  1) s = s + "x^" + i;
			}
		return s;
	}

	public static void main(String[] args) { 
		Polynomial zero = new Polynomial(0, 0);
		Polynomial p1   = new Polynomial(4, 9);
		Polynomial p2   = new Polynomial(3, 8);
		Polynomial p3   = new Polynomial(1, 0);
		Polynomial p4   = new Polynomial(2, 1);
		Polynomial p    = p1.plus(p2).plus(p3).plus(p4);

		Polynomial q1   = new Polynomial(3, 2);
		Polynomial q2   = new Polynomial(5, 0);
		Polynomial q    = q1.plus(q2);
		
		Polynomial r    = p.plus(q);
		Polynomial s    = p.times(q);
		
		System.out.println("zero(x) =     " + zero);
		System.out.println("p(x) =        " + p);
		System.out.println("q(x) =        " + q);
		System.out.println("p(x) + q(x) = " + r);
		System.out.println("p(x) * q(x) = " + s);
}

																			}

