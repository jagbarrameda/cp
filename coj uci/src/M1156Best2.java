import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.StringTokenizer;

public class M1156Best2 {

	void solve() throws IOException {
		int n = nextInt();
		while(n!=42){
			out.println(n);
			n = nextInt();
		}
	}

	private final BufferedReader in;
	private final PrintWriter out;
	private StringTokenizer st;

	M1156Best2() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		eat("");
		solve();
		in.close();
		out.close();
	}

	private void eat(String str) {
		st = new StringTokenizer(str);
	}

	String next() throws IOException {
		Locale.setDefault(Locale.ENGLISH);
		while (!st.hasMoreTokens()) {
			String line = in.readLine();
			if (line == null) {
				return null;
			}
			eat(line);
		}
		return st.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	public static void main(String[] args) throws IOException {
		new M1156Best2();
	}
}